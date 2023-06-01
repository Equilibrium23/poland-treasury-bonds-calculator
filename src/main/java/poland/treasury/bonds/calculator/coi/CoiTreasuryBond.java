package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.TreasuryBond;

import java.time.LocalDate;
import java.util.List;

public class CoiTreasuryBond extends TreasuryBond {
    private final CoiProspectus prospectus;
    private final List<Double> inflation;

    public CoiTreasuryBond(CoiProspectus prospectus, long quantity, LocalDate purchaseDay, List<Double> inflation) {
        super(prospectus, quantity, purchaseDay, purchaseDay.plusYears(CoiProspectus.BOND_DURATION.getYears()));
        this.prospectus = prospectus;
        this.inflation = inflation;
    }

    public CoiProspectus getProspectus() {
        return prospectus;
    }

    public List<Double> getInflation() {
        return inflation;
    }
}
