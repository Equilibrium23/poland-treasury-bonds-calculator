package poland.treasury.bonds.calculator.tos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import poland.treasury.bonds.calculator.TreasuryBondService;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static poland.treasury.bonds.calculator.database.TOS.*;

class TosTreasuryBondCalculatorTest {
    @ParameterizedTest
    @MethodSource("tosSampleProspectusWithExpectedReturn")
    public void testFullTimeBuyBack(TosProspectus tosProspectus, double expectedInvestmentReturn) {
        //given
        LocalDate firstDayOfBondRelease = tosProspectus.getSaleDateRange().startDate();
        TosTreasuryBond tosTreasuryBond = TreasuryBondService.buyTosBonds(tosProspectus, 1, firstDayOfBondRelease);

        //when
        double investmentReturn = TosTreasuryBondCalculator.calculate(tosTreasuryBond, tosTreasuryBond.getDefaultBuyBackDay());

        //then
        Assertions.assertEquals(expectedInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> tosSampleProspectusWithExpectedReturn() {
        return Stream.of(
                Arguments.of(TOS0825, 120.79),
                Arguments.of(TOS0925, 120.79),
                Arguments.of(TOS1025, 121.99),
                Arguments.of(TOS1125, 121.99),
                Arguments.of(TOS1225, 121.99),
                Arguments.of(TOS0126, 121.99),
                Arguments.of(TOS0226, 121.99),
                Arguments.of(TOS0326, 121.99),
                Arguments.of(TOS0426, 121.99),
                Arguments.of(TOS0526, 121.99)
        );
    }

    @ParameterizedTest
    @MethodSource("tosEarlierBuyBack")
    public void testEarlierBuyBack(LocalDate purchaseDay, LocalDate buyBackDate, double expectedInvestmentReturn) {
        //given
        TosTreasuryBond tosTreasuryBond = TreasuryBondService.buyTosBonds(TOS0526, 1, purchaseDay);

        //when
        double investmentReturn = TosTreasuryBondCalculator.calculate(tosTreasuryBond, buyBackDate);

        //then
        Assertions.assertEquals(expectedInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> tosEarlierBuyBack() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.MAY, 12), 100.21),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.JUNE, 19), 100.92),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.JULY, 1), 101.14),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.DECEMBER, 17), 104.30),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2024, Month.FEBRUARY, 2), 105.18),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2024, Month.JULY, 12), 108.29),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2025, Month.MAY, 1), 114.17),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2026, Month.JANUARY, 29), 120.02),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2026, Month.MAY, 1), 121.99)
        );
    }
}