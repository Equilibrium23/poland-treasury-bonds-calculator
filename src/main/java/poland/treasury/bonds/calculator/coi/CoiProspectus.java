package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.time.Period;

public class CoiProspectus extends TreasuryBondProspectus {
    public static final Period BOND_DURATION = Period.ofYears(4);

    private final BigDecimal firstYearInterestRate;
    private final BigDecimal margin;

    public CoiProspectus(BigDecimal penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange,
                         BigDecimal firstYearInterestRate, BigDecimal margin) {
        super(penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange);
        this.firstYearInterestRate = firstYearInterestRate;
        this.margin = margin;
    }

    public BigDecimal getFirstYearInterestRate() {
        return firstYearInterestRate;
    }

    public BigDecimal getMargin() {
        return margin;
    }
}
