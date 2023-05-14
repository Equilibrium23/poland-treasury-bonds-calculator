package poland.treasury.bonds.calculator.coi;

import java.time.LocalDate;
import java.util.List;

public class CoiTreasuryBondService {
    public static CoiTreasuryBond buyCoiBonds(CoiProspectus coiProspectus, long quantity, LocalDate purchaseDay, List<Double> inflation){
        return new CoiTreasuryBond(coiProspectus, quantity, purchaseDay, inflation);
    }
}
