package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.time.Period;

public class TosProspectus extends TreasuryBondProspectus {
    public static final Period BOND_DURATION = Period.ofYears(3);

    private final BigDecimal interestRate;

    public TosProspectus(BigDecimal penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange,
                         BigDecimal interestRate) {
        super(penaltyForEarlyBuyBack, saleDateRange, buyBackDateRange);
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
