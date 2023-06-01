package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.time.Period;

public class OtsProspectus extends TreasuryBondProspectus {
    public static final Period BOND_DURATION = Period.ofMonths(3);

    private final BigDecimal interestRate;

    public OtsProspectus(BigDecimal penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange,
                         BigDecimal interestRate) {
        super(penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange);
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}