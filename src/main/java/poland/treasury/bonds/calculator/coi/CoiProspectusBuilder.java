package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.ots.OtsProspectus;

public class CoiProspectusBuilder {
    private double firstYearInterestRate;
    private double margin;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;

    public CoiProspectus build() {
        return new CoiProspectus(firstYearInterestRate, margin, saleDateRange, buyBackDateRange);
    }

    public CoiProspectusBuilder firstYearInterestRate(double firstYearInterestRate) {
        this.firstYearInterestRate = firstYearInterestRate;
        return this;
    }

    public CoiProspectusBuilder margin(double margin) {
        this.margin = margin;
        return this;
    }

    public CoiProspectusBuilder saleDateRange(DateRange saleDateRange) {
        this.saleDateRange = saleDateRange;
        this.buyBackDateRange = new DateRange(
                saleDateRange.startDate().plusYears(CoiProspectus.BOND_DURATION.getYears()),
                saleDateRange.endDate().plusYears(CoiProspectus.BOND_DURATION.getYears())
        );
        return this;
    }

    public CoiProspectusBuilder buyBackDateRange(DateRange buyBackDateRange) {
        this.buyBackDateRange = buyBackDateRange;
        this.saleDateRange = new DateRange(
                buyBackDateRange.startDate().minusYears(CoiProspectus.BOND_DURATION.getYears()),
                buyBackDateRange.endDate().minusYears(CoiProspectus.BOND_DURATION.getYears())
        );
        return this;
    }
}
