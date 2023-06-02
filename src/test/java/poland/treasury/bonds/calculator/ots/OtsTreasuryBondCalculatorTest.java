package poland.treasury.bonds.calculator.ots;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import poland.treasury.bonds.calculator.TreasuryBondProspectus;
import poland.treasury.bonds.calculator.TreasuryBondService;

import java.time.LocalDate;
import java.util.stream.Stream;

import static poland.treasury.bonds.calculator.database.OTS.*;

class OtsTreasuryBondCalculatorTest {
    @ParameterizedTest
    @MethodSource("otsSampleProspectusWithExpectedReturn")
    public void testFullTimeBuyBack(OtsProspectus otsProspectus, double expectedInvestmentReturn){
        //given
        LocalDate firstDayOfBondRelease = otsProspectus.getSaleDateRange().startDate();
        OtsTreasuryBond otsTreasuryBond = TreasuryBondService.buyOtsBonds(otsProspectus, 1, firstDayOfBondRelease);

        //when
        double investmentReturn = OtsTreasuryBondCalculator.calculate(otsTreasuryBond, otsTreasuryBond.getDefaultBuyBackDay());

        //then
        Assertions.assertEquals(expectedInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> otsSampleProspectusWithExpectedReturn() {
        return Stream.of(
                Arguments.of(OTS0422, 100.12),
                Arguments.of(OTS0522, 100.24),
                Arguments.of(OTS0622, 100.25),
                Arguments.of(OTS0722, 100.37),
                Arguments.of(OTS0822, 100.38),
                Arguments.of(OTS0922, 100.76),
                Arguments.of(OTS1022, 100.76),
                Arguments.of(OTS1122, 100.76),
                Arguments.of(OTS1222, 100.75),
                Arguments.of(OTS0123, 100.76),
                Arguments.of(OTS0223, 100.76),
                Arguments.of(OTS0323, 100.74)
        );
    }

    @ParameterizedTest
    @MethodSource("otsSampleProspectus")
    public void testEarlierBuyBack(OtsProspectus otsProspectus){
        //given
        final double zeroInvestmentReturn = TreasuryBondProspectus.UNIT_PRICE;
        LocalDate firstDayOfBondRelease = otsProspectus.getSaleDateRange().startDate();
        OtsTreasuryBond otsTreasuryBond = TreasuryBondService.buyOtsBonds(otsProspectus, 1, firstDayOfBondRelease);

        //when
        double investmentReturn = OtsTreasuryBondCalculator.calculate(otsTreasuryBond, firstDayOfBondRelease.plusMonths(1));

        //then
        Assertions.assertEquals(zeroInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> otsSampleProspectus() {
        return Stream.of(
                Arguments.of(OTS0422),
                Arguments.of(OTS0522),
                Arguments.of(OTS0622),
                Arguments.of(OTS0722),
                Arguments.of(OTS0822),
                Arguments.of(OTS0922),
                Arguments.of(OTS1022),
                Arguments.of(OTS1122),
                Arguments.of(OTS1222),
                Arguments.of(OTS0123),
                Arguments.of(OTS0223),
                Arguments.of(OTS0323)
        );
    }
}