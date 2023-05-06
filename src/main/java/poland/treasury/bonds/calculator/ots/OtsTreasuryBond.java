package poland.treasury.bonds.calculator.ots;

import java.time.LocalDate;

public class OtsTreasuryBond {
    private final OtsProspectus otsProspectus;
    private final long quantity;
    private final LocalDate purchaseDay;
    private final LocalDate defaultBuyBackDay;


    public OtsTreasuryBond(OtsProspectus otsProspectus, long quantity, LocalDate purchaseDay) {
        if(!otsProspectus.saleDateRange().containsDate(purchaseDay)){
            throw new IllegalArgumentException();
        }

        this.otsProspectus = otsProspectus;
        this.quantity = quantity;
        this.purchaseDay = purchaseDay;
        this.defaultBuyBackDay = purchaseDay.plusMonths(3);
    }

    public OtsProspectus getOtsProspectus() {
        return otsProspectus;
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
