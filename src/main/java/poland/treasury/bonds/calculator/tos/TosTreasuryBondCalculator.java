package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.ots.OtsProspectus;
import poland.treasury.bonds.calculator.ots.OtsTreasuryBond;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class TosTreasuryBondCalculator {
    public static double calculate(TosTreasuryBond tosTreasuryBond, LocalDate buyBackDate) {
        long k = YEARS.between(tosTreasuryBond.getPurchaseDay(), buyBackDate) + 1;
        LocalDate newStartDate = tosTreasuryBond.getPurchaseDay().plusYears(k - 1);
        double ak = DAYS.between(newStartDate, buyBackDate);
        double ACT = DAYS.between(newStartDate, newStartDate.plusYears(1));
        double r = tosTreasuryBond.getTosProspectus().interestRate();

        double WP = Nk_1(k, r) * (1 + r * ak / ACT);
        BigDecimal bd = new BigDecimal(WP).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    private static double Nk_1(long year, double interestRate){
        return 100 * Math.pow(1 + interestRate, year - 1);
    }
}
