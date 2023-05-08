package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.ots.OtsProspectus;

import java.time.LocalDate;

public class TosTreasuryBond {
    private final TosProspectus tosProspectus;
    private final long quantity;
    private final LocalDate purchaseDay;
    private final LocalDate defaultBuyBackDay;

    public TosTreasuryBond(TosProspectus tosProspectus, long quantity, LocalDate purchaseDay) {
        if(!tosProspectus.saleDateRange().containsDate(purchaseDay)){
            throw new IllegalArgumentException();
        }

        this.tosProspectus = tosProspectus;
        this.quantity = quantity;
        this.purchaseDay = purchaseDay;
        this.defaultBuyBackDay = purchaseDay.plusYears(3);
    }

    public TosProspectus getTosProspectus() {
        return tosProspectus;
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
