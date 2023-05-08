package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.DateRange;

public record TosProspectus(double interestRate, double penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange) {
    public static final short PRICE = 100;

    public TosProspectus {
        if (saleDateRange.isAfter(buyBackDateRange))
            throw new IllegalArgumentException();
    }
}
