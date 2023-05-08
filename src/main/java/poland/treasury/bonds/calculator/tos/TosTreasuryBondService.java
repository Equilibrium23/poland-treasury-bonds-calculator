package poland.treasury.bonds.calculator.tos;

import java.time.LocalDate;

public class TosTreasuryBondService {
    public static TosTreasuryBond buyTosBonds(TosProspectus tosProspectus, long quantity, LocalDate purchaseDay){
        return new TosTreasuryBond(tosProspectus, quantity, purchaseDay);
    }
}
