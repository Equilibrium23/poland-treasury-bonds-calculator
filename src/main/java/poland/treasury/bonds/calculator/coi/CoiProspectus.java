package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.DateRange;

import java.time.Period;

public record CoiProspectus(double firstYearInterestRate, double margin, DateRange saleDateRange, DateRange buyBackDateRange) {
    public static final short PRICE = 100;
    public static final Period BOND_DURATION = Period.ofYears(4);

    public CoiProspectus {
        if (saleDateRange.isAfter(buyBackDateRange))
            throw new IllegalArgumentException();
    }
}
