package poland.treasury.bonds.calculator.coi;

import poland.treasury.bonds.calculator.TreasuryBondProspectus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class CoiTreasuryBondCalculator {
    public static double calculate(CoiTreasuryBond coiTreasuryBond, LocalDate buyBackDate) {
        final BigDecimal price = BigDecimal.valueOf(coiTreasuryBond.getQuantity() * TreasuryBondProspectus.UNIT_PRICE);

        int years = (int) YEARS.between(coiTreasuryBond.getPurchaseDay(), buyBackDate);


        Optional<BigDecimal> result = Stream.of(0, 1, 2, 3)
                .limit(years + 1)
                .map(i -> {
                    BigDecimal interest = coiTreasuryBond.getInterests().get(i);
                    if (i <  years) return fullYearInvestmentReturn(price, interest);
                    else return partYearInvestmentReturn(coiTreasuryBond, price, interest, buyBackDate, years);
                }).reduce(BigDecimal::add);

        return result.get().add(price).doubleValue();
    }

    private static BigDecimal fullYearInvestmentReturn(BigDecimal price, BigDecimal interest){
        return price.multiply(interest);
    }

    private static BigDecimal partYearInvestmentReturn(CoiTreasuryBond coiTreasuryBond, BigDecimal price, BigDecimal interest,
                                                       LocalDate buyBackDate, long year) {
        if(year > 3){
            throw new IllegalArgumentException();
        }
        BigDecimal a = BigDecimal.valueOf(DAYS.between(coiTreasuryBond.getPurchaseDay().plusYears(year), buyBackDate));
        BigDecimal ACT = BigDecimal.valueOf(DAYS.between(coiTreasuryBond.getPurchaseDay().plusYears(year),
                coiTreasuryBond.getPurchaseDay().plusYears(year + 1)));

        BigDecimal x = interest.multiply(a).divide(ACT, 4, RoundingMode.HALF_UP);

        return price.multiply(x);
    }
}
