package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.TreasuryBond;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoiTreasuryBond extends TreasuryBond {
    private final CoiProspectus prospectus;
    private final List<BigDecimal> inflation;
    private final List<BigDecimal> interests;

    public CoiTreasuryBond(CoiProspectus prospectus, long quantity, LocalDate purchaseDay, List<BigDecimal> inflation) {
        super(prospectus, quantity, purchaseDay, purchaseDay.plusYears(CoiProspectus.BOND_DURATION.getYears()));
        this.prospectus = prospectus;
        this.inflation = inflation;
        this.interests = new ArrayList<>();
        this.interests.add(prospectus.getFirstYearInterestRate());
        this.interests.addAll(inflation);
    }

    public CoiProspectus getProspectus() {
        return prospectus;
    }

    public List<BigDecimal> getInflation() {
        return inflation;
    }

    public List<BigDecimal> getInterests() {
        return interests;
    }
}
