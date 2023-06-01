package poland.treasury.bonds.calculator.ots;

import poland.treasury.bonds.calculator.TreasuryBond;

import java.time.LocalDate;

public class OtsTreasuryBond extends TreasuryBond {
    private final OtsProspectus prospectus;

    public OtsTreasuryBond(OtsProspectus prospectus, long quantity, LocalDate purchaseDay) {
        super(prospectus, quantity, purchaseDay, purchaseDay.plusMonths(OtsProspectus.BOND_DURATION.getMonths()));
        this.prospectus = prospectus;
    }

    public OtsProspectus getProspectus() {
        return prospectus;
    }
}
