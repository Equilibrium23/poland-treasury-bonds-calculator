package poland.treasury.bonds.calculator.coi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondProspectus;
import poland.treasury.bonds.calculator.TreasuryBondService;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;


class CoiTreasuryBondCalculatorTest {
    private static CoiTreasuryBond coi0124TreasuryBond;
    private static final BigDecimal firstYearExpectedReturn = new BigDecimal("2.4");
    private static final BigDecimal secondYearExpectedReturn = new BigDecimal("4.25");
    private static final BigDecimal thirdYearExpectedReturn = new BigDecimal("9.05");
    private static final BigDecimal fourthYearExpectedReturn = new BigDecimal("18.75");

    @BeforeAll
    static void beforeAll() {
        CoiProspectus coi0124Prospectus = new CoiProspectusBuilder()
                .firstYearInterestRate(BigDecimal.valueOf(0.024))
                .margin(BigDecimal.valueOf(0.0125))
                .saleDateRange(new DateRange(LocalDate.of(2020,1,1), LocalDate.of(2020, 1, 31)))
                .build();

        List<BigDecimal> inflation = List.of(new BigDecimal("0.0425"),new BigDecimal("0.0905") ,new BigDecimal("0.1875"));

        coi0124TreasuryBond = TreasuryBondService.buyCoiBonds(coi0124Prospectus, 1, LocalDate.of(2020, 1, 1), inflation);
    }

    @ParameterizedTest
    @MethodSource("buyBackDateWithExpectedReturn")
    public void firstTermBuyBack(LocalDate buyBackDate, double expectedInvestmentReturn){
        //given

        //when
        double investmentReturn = CoiTreasuryBondCalculator.calculate(coi0124TreasuryBond, buyBackDate);

        //then
        Assertions.assertEquals(expectedInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> buyBackDateWithExpectedReturn() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 1, 12), 100.07),
                Arguments.of(LocalDate.of(2020, 2, 23), 100.35),
                Arguments.of(LocalDate.of(2020, 3, 3), 100.41),
                Arguments.of(LocalDate.of(2020, 4, 21), 100.73),
                Arguments.of(LocalDate.of(2020, 5, 17), 100.90),
                Arguments.of(LocalDate.of(2020, 6, 15), 101.09),
                Arguments.of(LocalDate.of(2020, 7, 10), 101.25),
                Arguments.of(LocalDate.of(2020, 8, 1), 101.40),
                Arguments.of(LocalDate.of(2020, 9, 5), 101.63),
                Arguments.of(LocalDate.of(2020, 10, 9), 101.85),
                Arguments.of(LocalDate.of(2020, 11, 28), 102.18),
                Arguments.of(LocalDate.of(2020, 12, 11), 102.26),
                Arguments.of(LocalDate.of(2021, 1, 1),
                        firstYearExpectedReturn.add(BigDecimal.valueOf(TreasuryBondProspectus.UNIT_PRICE)).doubleValue())
        );
    }

    @ParameterizedTest
    @MethodSource("secondTermBuyBackDateWithExpectedReturn")
    public void secondTermBuyBack(LocalDate buyBackDate, double expectedInvestmentReturn){
        //given

        //when
        double investmentReturn = CoiTreasuryBondCalculator.calculate(coi0124TreasuryBond, buyBackDate);

        //then
        Assertions.assertEquals(expectedInvestmentReturn, investmentReturn);
    }

    public static Stream<Arguments> secondTermBuyBackDateWithExpectedReturn() {
        return Stream.of(
                Arguments.of(LocalDate.of(2021, 1, 12), firstYearExpectedReturn.add(new BigDecimal("100.13")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 2, 23), firstYearExpectedReturn.add(new BigDecimal("100.62")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 3, 3), firstYearExpectedReturn.add(new BigDecimal("100.71")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 4, 21), firstYearExpectedReturn.add(new BigDecimal("101.28")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 5, 17), firstYearExpectedReturn.add(new BigDecimal("101.58")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 6, 15), firstYearExpectedReturn.add(new BigDecimal("101.92")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 7, 10), firstYearExpectedReturn.add(new BigDecimal("102.21")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 8, 1), firstYearExpectedReturn.add(new BigDecimal("102.47")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 9, 5), firstYearExpectedReturn.add(new BigDecimal("102.88")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 10, 9), firstYearExpectedReturn.add(new BigDecimal("103.27")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 11, 28), firstYearExpectedReturn.add(new BigDecimal("103.85")).doubleValue()),
                Arguments.of(LocalDate.of(2021, 12, 11), firstYearExpectedReturn.add(new BigDecimal("104.01")).doubleValue()),
                Arguments.of(LocalDate.of(2022, 1, 1),
                         firstYearExpectedReturn.add(secondYearExpectedReturn).add(BigDecimal.valueOf(TreasuryBondProspectus.UNIT_PRICE)).doubleValue())
        );
    }

    @Test
    public void fullTimeBuyBack(){
        //given
        final double expectedInvestmentReturn =
                firstYearExpectedReturn.add(secondYearExpectedReturn).add(thirdYearExpectedReturn).add(fourthYearExpectedReturn).doubleValue();

        //when
        double investmentReturn = CoiTreasuryBondCalculator.calculate(coi0124TreasuryBond, coi0124TreasuryBond.getDefaultBuyBackDay());

        //then
        Assertions.assertEquals(TreasuryBondProspectus.UNIT_PRICE +  expectedInvestmentReturn, investmentReturn);
    }
}