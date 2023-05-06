package poland.treasury.bonds.calculator.ots;

import java.time.LocalDate;

public class OtsTreasuryBondService {
    public static OtsTreasuryBond buyOtsBonds(OtsProspectus otsProspectus, long quantity, LocalDate purchaseDay){
        return new OtsTreasuryBond(otsProspectus, quantity, purchaseDay);
    }
}
