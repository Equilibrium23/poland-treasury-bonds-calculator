package poland.treasury.bonds.calculator.tos;

import poland.treasury.bonds.calculator.TreasuryBond;

import java.time.LocalDate;

public class TosTreasuryBond extends TreasuryBond {
    private final TosProspectus prospectus;

    public TosTreasuryBond(TosProspectus prospectus, long quantity, LocalDate purchaseDay) {
        super(prospectus, quantity, purchaseDay, purchaseDay.plusYears(TosProspectus.BOND_DURATION.getYears()));
        this.prospectus = prospectus;
    }

    public TosProspectus getProspectus() {
        return prospectus;
    }
}

