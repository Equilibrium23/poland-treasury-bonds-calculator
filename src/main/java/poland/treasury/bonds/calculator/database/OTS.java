package poland.treasury.bonds.calculator.database;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.ots.OtsProspectus;
import poland.treasury.bonds.calculator.ots.OtsProspectusBuilder;

import java.math.BigDecimal;

public class OTS {
    public static OtsProspectus OTS0422 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0422"))
            .interestRate(BigDecimal.valueOf(0.005))
            .build();

    public static OtsProspectus OTS0522 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0522"))
            .interestRate(BigDecimal.valueOf(0.01))
            .build();

    public static OtsProspectus OTS0622 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0622"))
            .interestRate(BigDecimal.valueOf(0.01))
            .build();

    public static OtsProspectus OTS0722 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0722"))
            .interestRate(BigDecimal.valueOf(0.015))
            .build();

    public static OtsProspectus OTS0822 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0822"))
            .interestRate(BigDecimal.valueOf(0.015))
            .build();

    public static OtsProspectus OTS0922 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0922"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS1022 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1022"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS1122 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1122"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS1222 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1222"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS0123 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0123"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS0223 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0223"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();

    public static OtsProspectus OTS0323 = new OtsProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0323"))
            .interestRate(BigDecimal.valueOf(0.03))
            .build();
}
