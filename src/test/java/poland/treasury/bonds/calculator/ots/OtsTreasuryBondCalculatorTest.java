package poland.treasury.bonds.calculator.ots;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

class OtsTreasuryBondCalculatorTest {
    private final short ANY_DAY_OF_MONTH = 1;

    public static Stream<Arguments> otsSampleProspectus() {
        LocalDate startDay = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate endDay = LocalDate.of(2022, Month.JANUARY, 31);
        return Stream.of(
                Arguments.of(new DateRange(startDay, endDay), 0.005, 100.12),
                Arguments.of(new DateRange(startDay.plusMonths(1), endDay.plusMonths(1)), 0.01, 100.24),
                Arguments.of(new DateRange(startDay.plusMonths(2), endDay.plusMonths(2)), 0.01, 100.25),
                Arguments.of(new DateRange(startDay.plusMonths(3), endDay.plusMonths(3)), 0.015, 100.37),
                Arguments.of(new DateRange(startDay.plusMonths(4), endDay.plusMonths(4)), 0.015, 100.38),
                Arguments.of(new DateRange(startDay.plusMonths(5), endDay.plusMonths(5)), 0.03, 100.76),
                Arguments.of(new DateRange(startDay.plusMonths(6), endDay.plusMonths(6)), 0.03, 100.76),
                Arguments.of(new DateRange(startDay.plusMonths(7), endDay.plusMonths(7)), 0.03, 100.76),
                Arguments.of(new DateRange(startDay.plusMonths(8), endDay.plusMonths(8)), 0.03, 100.75),
                Arguments.of(new DateRange(startDay.plusMonths(9), endDay.plusMonths(9)), 0.03, 100.76),
                Arguments.of(new DateRange(startDay.plusMonths(10), endDay.plusMonths(10)), 0.03, 100.76),
                Arguments.of(new DateRange(startDay.plusMonths(11), endDay.plusMonths(11)), 0.03, 100.74)
        );
    }

    @ParameterizedTest
    @MethodSource("otsSampleProspectus")
    public void testFullTimeBuyBack(DateRange saleDateRange, double interestRate, double expectedReturn){
        OtsProspectus otsProspectus = new OtsProspectusBuilder()
                .interestRate(BigDecimal.valueOf(interestRate))
                .saleDateRange(saleDateRange)
                .build();

        LocalDate startDate = saleDateRange.startDate();
        LocalDate endDate = saleDateRange.startDate().plusMonths(3);

        OtsTreasuryBond otsTreasuryBond = TreasuryBondService.buyOtsBonds(otsProspectus, 1, startDate);

        Assertions.assertEquals(expectedReturn, OtsTreasuryBondCalculator.calculate(otsTreasuryBond, endDate));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.01, 0.1, 1})
    public void testEarlierBuyBack(double ANY_INTEREST){
        OtsProspectus otsProspectus = new OtsProspectusBuilder()
                .interestRate(BigDecimal.valueOf(ANY_INTEREST))
                .saleDateRange(new DateRange(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31)))
                .build();

        OtsTreasuryBond otsTreasuryBond = TreasuryBondService.buyOtsBonds(otsProspectus, 1, LocalDate.of(2023, 1, ANY_DAY_OF_MONTH));

        Assertions.assertEquals(100, OtsTreasuryBondCalculator.calculate(otsTreasuryBond, LocalDate.of(2023, 2, ANY_DAY_OF_MONTH)));
    }
}