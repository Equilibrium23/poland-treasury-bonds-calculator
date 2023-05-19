package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.DateRange;

import java.time.Period;

public record TosProspectus(double interestRate, double penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange) {
    public static final short PRICE = 100;
    public static final Period BOND_DURATION = Period.ofYears(3);

    public TosProspectus {
        if (saleDateRange.isAfter(buyBackDateRange))
            throw new IllegalArgumentException();
    }
}
