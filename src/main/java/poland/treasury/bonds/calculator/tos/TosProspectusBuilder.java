package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.DateRange;

public class TosProspectusBuilder {
    private double interestRate;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;
    private double penaltyForEarlyBuyBack;

    public TosProspectus build() {
        return new TosProspectus(interestRate, penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange);
    }

    public TosProspectusBuilder interestRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public TosProspectusBuilder penaltyForEarlyBuyBack(double penaltyForEarlyBuyBack) {
        this.penaltyForEarlyBuyBack = penaltyForEarlyBuyBack;
        return this;
    }

    public TosProspectusBuilder saleDateRange(DateRange saleDateRange) {
        this.saleDateRange = saleDateRange;
        this.buyBackDateRange = new DateRange(
                saleDateRange.startDate().plusYears(TosProspectus.BOND_DURATION.getYears()),
                saleDateRange.endDate().plusYears(TosProspectus.BOND_DURATION.getYears())
        );
        return this;
    }

    public TosProspectusBuilder buyBackDateRange(DateRange buyBackDateRange) {
        this.buyBackDateRange = buyBackDateRange;
        this.saleDateRange = new DateRange(
                buyBackDateRange.startDate().minusYears(TosProspectus.BOND_DURATION.getYears()),
                buyBackDateRange.endDate().minusYears(TosProspectus.BOND_DURATION.getYears())
        );
        return this;
    }
}
