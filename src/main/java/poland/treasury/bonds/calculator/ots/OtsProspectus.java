package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.DateRange;

public record OtsProspectus(double interestRate, DateRange saleDateRange, DateRange buyBackDateRange) {
    public static final short PRICE = 100;

    public OtsProspectus {
        if (saleDateRange.isAfter(buyBackDateRange))
            throw new IllegalArgumentException();
    }
}
