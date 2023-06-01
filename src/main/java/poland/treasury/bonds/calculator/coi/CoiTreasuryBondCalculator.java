package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CoiTreasuryBondCalculator {
    public static double calculate(CoiTreasuryBond coiTreasuryBond) {
        final double price = coiTreasuryBond.getQuantity() * TreasuryBondProspectus.UNIT_PRICE;
        double output1 = coiTreasuryBond.getProspectus().getFirstYearInterestRate().doubleValue() * price * 0.81;
        double output2_4 = coiTreasuryBond.getInflation().stream()
                .map(inflation -> (inflation + coiTreasuryBond.getProspectus().getMargin().doubleValue()) * price * 0.81)
                .reduce(Double::sum).get();

        BigDecimal bd = new BigDecimal(output1 + output2_4).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
