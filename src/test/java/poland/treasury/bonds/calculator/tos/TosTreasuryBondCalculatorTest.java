package poland.treasury.bonds.calculator.tos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import poland.treasury.bonds.calculator.DateRange;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

class TosTreasuryBondCalculatorTest {

    public static Stream<Arguments> tosEarlierBuyBack() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.MAY, 12), 100.21),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.JUNE, 19), 100.92),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.JULY, 1), 101.14),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2023, Month.DECEMBER, 17), 104.30),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2024, Month.FEBRUARY, 2), 105.18),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2024, Month.JULY, 12 ), 108.29),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2025, Month.MAY, 1), 114.17),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2026, Month.JANUARY, 29), 120.02),
                Arguments.of(LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2026, Month.MAY, 1), 121.99)
        );
    }

    @ParameterizedTest
    @MethodSource("tosEarlierBuyBack")
    public void testEarlierBuyBack(LocalDate purchaseDay, LocalDate buyBackDate, double expectedReturn){
        TosTreasuryBond tosTreasuryBond = TosTreasuryBondService.buyTosBonds(TOS.TOS0526, 1, purchaseDay);

        Assertions.assertEquals(expectedReturn, TosTreasuryBondCalculator.calculate(tosTreasuryBond, buyBackDate));
    }
}