package poland.treasury.bonds.calculator.coi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


class CoiTreasuryBondCalculatorTest {
    @Test
    public void testFullTimeBuyBack(){
        CoiProspectus coiProspectus = new CoiProspectusBuilder()
                .firstYearInterestRate(BigDecimal.valueOf(0.055))
                .margin(BigDecimal.valueOf(0.01))
                .saleDateRange(new DateRange(LocalDate.of(2022,6,1), LocalDate.of(2022, 6, 30)))
                .build();

        List<Double> inflation = List.of(0.1, 0.1, 0.1);

        CoiTreasuryBond coiTreasuryBond = TreasuryBondService.buyCoiBonds(coiProspectus, 1, LocalDate.of(2022, 6, 2), inflation);

        Assertions.assertEquals(31.19, CoiTreasuryBondCalculator.calculate(coiTreasuryBond));
    }
}