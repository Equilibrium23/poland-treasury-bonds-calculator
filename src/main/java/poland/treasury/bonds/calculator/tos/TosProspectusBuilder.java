package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.DateRange;

import java.math.BigDecimal;

public class TosProspectusBuilder {
    private BigDecimal interestRate;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;
    private BigDecimal penaltyForEarlyBuyBack;

    public TosProspectus build() {
        return new TosProspectus(penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange, interestRate);
    }

    public TosProspectusBuilder interestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public TosProspectusBuilder penaltyForEarlyBuyBack(BigDecimal penaltyForEarlyBuyBack) {
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
