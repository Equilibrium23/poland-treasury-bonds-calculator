package poland.treasury.bonds.calculator.coi;

import java.time.LocalDate;
import java.util.List;

public class CoiTreasuryBond {
    private final CoiProspectus coiProspectus;
    private final long quantity;
    private final LocalDate purchaseDay;
    private final LocalDate defaultBuyBackDay;
    private final List<Double> inflation;

    public CoiTreasuryBond(CoiProspectus coiProspectus, long quantity, LocalDate purchaseDay, List<Double> inflation) {
        this.coiProspectus = coiProspectus;
        this.quantity = quantity;
        this.purchaseDay = purchaseDay;
        this.inflation = inflation;

        // Why not from coiProspectus ??
        this.defaultBuyBackDay = purchaseDay.plusYears(4);
    }

    public CoiProspectus getCoiProspectus() {
        return coiProspectus;
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

    public List<Double> getInflation() {
        return inflation;
    }
}
