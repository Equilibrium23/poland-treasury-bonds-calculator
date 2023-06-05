package poland.treasury.bonds.calculator;

import java.math.BigDecimal;

public abstract class TreasuryBondProspectus {
    public static final int UNIT_PRICE = 100;
    public static final BigDecimal CAPITAL_GAINS_TAX = BigDecimal.valueOf(0.19);

    private final BigDecimal penaltyForEarlyBuyBack;
    private final DateRange saleDateRange;
    private final DateRange buyBackDateRange;

    public TreasuryBondProspectus(BigDecimal penaltyForEarlyBuyBack, DateRange saleDateRange, DateRange buyBackDateRange) {
        if (saleDateRange.isAfter(buyBackDateRange)) throw new IllegalArgumentException();
        this.penaltyForEarlyBuyBack = penaltyForEarlyBuyBack;
        this.saleDateRange = saleDateRange;
        this.buyBackDateRange = buyBackDateRange;
    }

    public BigDecimal getPenaltyForEarlyBuyBack() {
        return penaltyForEarlyBuyBack;
    }

    public DateRange getSaleDateRange() {
        return saleDateRange;
    }

    public DateRange getBuyBackDateRange() {
        return buyBackDateRange;
    }
}
