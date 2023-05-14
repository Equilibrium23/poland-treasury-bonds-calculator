package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.tos.TosTreasuryBond;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class CoiTreasuryBondCalculator {
    public static double calculate(CoiTreasuryBond coiTreasuryBond) {
        final double price = coiTreasuryBond.getQuantity() * CoiProspectus.PRICE;
        double output1 = coiTreasuryBond.getCoiProspectus().firstYearInterestRate() * price * 0.81;
        double output2_4 = coiTreasuryBond.getInflation().stream()
                .map(inflation -> (inflation + coiTreasuryBond.getCoiProspectus().margin()) * price * 0.81)
                .reduce(Double::sum).get();

        BigDecimal bd = new BigDecimal(output1 + output2_4).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
