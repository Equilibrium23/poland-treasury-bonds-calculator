package poland.treasury.bonds.calculator.database;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.tos.TosProspectus;
import poland.treasury.bonds.calculator.tos.TosProspectusBuilder;

import java.math.BigDecimal;

public class TOS {
    public static TosProspectus TOS0825 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.065))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0825"))
            .build();

    public static TosProspectus TOS0925 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.065))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0925"))
            .build();

    public static TosProspectus TOS1025 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("1025"))
            .build();

    public static TosProspectus TOS1125 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("1125"))
            .build();

    public static TosProspectus TOS1225 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("1225"))
            .build();

    public static TosProspectus TOS0126 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0126"))
            .build();

    public static TosProspectus TOS0226 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0226"))
            .build();

    public static TosProspectus TOS0326 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0326"))
            .build();

    public static TosProspectus TOS0426 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0426"))
            .build();

    public static TosProspectus TOS0526 = new TosProspectusBuilder()
            .interestRate(BigDecimal.valueOf(0.0685))
            .penaltyForEarlyBuyBack(BigDecimal.valueOf(0.7))
            .buyBackDateRange(DateRange.fromString("0526"))
            .build();
}
