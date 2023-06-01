package poland.treasury.bonds.calculator;

import java.time.LocalDate;

public class TreasuryBond {
    private final long quantity;
    private final LocalDate purchaseDay;
    private final LocalDate defaultBuyBackDay;

    public TreasuryBond(TreasuryBondProspectus prospectus, long quantity, LocalDate purchaseDay, LocalDate defaultBuyBackDay) {
        if(!prospectus.getSaleDateRange().containsDate(purchaseDay)){
            throw new IllegalArgumentException();
        }

        this.quantity = quantity;
        this.purchaseDay = purchaseDay;
        this.defaultBuyBackDay = defaultBuyBackDay;
    }

    public long getQuantity() {
        return quantity;
    }

    public LocalDate getPurchaseDay() {
        return purchaseDay;
    }

    public LocalDate getDefaultBuyBackDay() {
        return defaultBuyBackDay;
    }
}
