package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.DateRange;

import java.math.BigDecimal;

public class OtsProspectusBuilder {
    private BigDecimal interestRate;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;

    public OtsProspectus build() {
        return new OtsProspectus(BigDecimal.ZERO, saleDateRange, buyBackDateRange, interestRate);
    }

    public OtsProspectusBuilder interestRate(BigDecimal interestRate) {
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
                buyBackDateRange.startDate().minusMonths(OtsProspectus.BOND_DURATION.getMonths()),
                buyBackDateRange.endDate().minusMonths(OtsProspectus.BOND_DURATION.getMonths())
        );
        return this;
    }
}
