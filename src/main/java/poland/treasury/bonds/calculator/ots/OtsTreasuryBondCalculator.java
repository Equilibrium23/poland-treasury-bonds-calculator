package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class OtsTreasuryBondCalculator {
    public static double calculate(OtsTreasuryBond otsTreasuryBond, LocalDate buyBackDate) {
        final var initialAmountOfMoney = otsTreasuryBond.getQuantity() * TreasuryBondProspectus.UNIT_PRICE;
        if(!otsTreasuryBond.getDefaultBuyBackDay().isEqual(buyBackDate)){
            return initialAmountOfMoney;
        }

        long bondDays = DAYS.between(otsTreasuryBond.getPurchaseDay(), buyBackDate);
        int dayOfYear = otsTreasuryBond.getPurchaseDay().lengthOfYear();
        double interest = otsTreasuryBond.getProspectus().getInterestRate().doubleValue() * bondDays / dayOfYear;
        var result = initialAmountOfMoney +
                interest * initialAmountOfMoney;
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
