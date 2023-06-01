package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.ots.OtsProspectus;
import poland.treasury.bonds.calculator.tos.TosProspectusBuilder;

import java.math.BigDecimal;

public class CoiProspectusBuilder {
    private BigDecimal firstYearInterestRate;
    private BigDecimal margin;
    private DateRange saleDateRange;
    private DateRange buyBackDateRange;
    private BigDecimal penaltyForEarlyBuyBack;


    public CoiProspectus build() {
        return new CoiProspectus(penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange, firstYearInterestRate, margin);
    }

    public CoiProspectusBuilder firstYearInterestRate(BigDecimal firstYearInterestRate) {
        this.firstYearInterestRate = firstYearInterestRate;
        return this;
    }

    public CoiProspectusBuilder margin(BigDecimal margin) {
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

    public CoiProspectusBuilder penaltyForEarlyBuyBack(BigDecimal penaltyForEarlyBuyBack) {
        this.penaltyForEarlyBuyBack = penaltyForEarlyBuyBack;
        return this;
    }
}
