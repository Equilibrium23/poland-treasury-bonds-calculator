package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.DateRange;

public class OtsProspectusBuilder {
    private double interestRate;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;

    public OtsProspectus build() {
        return new OtsProspectus(interestRate, saleDateRange, buyBackDateRange);
    }

    public OtsProspectusBuilder interestRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public OtsProspectusBuilder saleDateRange(DateRange saleDateRange) {
        this.saleDateRange = saleDateRange;
        this.buyBackDateRange = new DateRange(
                saleDateRange.startDate().plusMonths(OtsProspectus.BOND_DURATION.getMonths()),
                saleDateRange.endDate().plusMonths(OtsProspectus.BOND_DURATION.getMonths())
        );
        return this;
    }

    public OtsProspectusBuilder buyBackDateRange(DateRange buyBackDateRange) {
        this.buyBackDateRange = buyBackDateRange;
        this.saleDateRange = new DateRange(
                saleDateRange.startDate().minusMonths(OtsProspectus.BOND_DURATION.getMonths()),
                saleDateRange.endDate().minusMonths(OtsProspectus.BOND_DURATION.getMonths())
        );
        return this;
    }
}
