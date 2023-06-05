package poland.treasury.bonds.calculator;

import poland.treasury.bonds.calculator.coi.CoiProspectus;
import poland.treasury.bonds.calculator.coi.CoiTreasuryBond;
import poland.treasury.bonds.calculator.ots.OtsProspectus;
import poland.treasury.bonds.calculator.ots.OtsTreasuryBond;
import poland.treasury.bonds.calculator.tos.TosProspectus;
import poland.treasury.bonds.calculator.tos.TosTreasuryBond;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TreasuryBondService {
    public static TosTreasuryBond buyTosBonds(TosProspectus tosProspectus, long quantity, LocalDate purchaseDay){
        return new TosTreasuryBond(tosProspectus, quantity, purchaseDay);
    }

    public static OtsTreasuryBond buyOtsBonds(OtsProspectus otsProspectus, long quantity, LocalDate purchaseDay){
        return new OtsTreasuryBond(otsProspectus, quantity, purchaseDay);
    }

    public static CoiTreasuryBond buyCoiBonds(CoiProspectus coiProspectus, long quantity, LocalDate purchaseDay, List<BigDecimal> inflation){
        return new CoiTreasuryBond(coiProspectus, quantity, purchaseDay, inflation);
    }
}
