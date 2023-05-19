package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.DateRange;

import java.time.Period;

public record OtsProspectus(double interestRate, DateRange saleDateRange, DateRange buyBackDateRange) {
    public static final short PRICE = 100;
    public static final Period BOND_DURATION = Period.ofMonths(3);

    public OtsProspectus {
        if (saleDateRange.isAfter(buyBackDateRange))
            throw new IllegalArgumentException();
    }
}
