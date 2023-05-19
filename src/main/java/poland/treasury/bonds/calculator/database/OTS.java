package poland.treasury.bonds.calculator.database;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.ots.OtsProspectus;
import poland.treasury.bonds.calculator.ots.OtsProspectusBuilder;

public class OTS {
    public static OtsProspectus TOS0126 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0126"))
            .interestRate(0.005)
            .build();

    public static OtsProspectus TOS0226 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0226"))
            .interestRate(0.01)
            .build();

    public static OtsProspectus TOS0326 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0326"))
            .interestRate(0.01)
            .build();

    public static OtsProspectus TOS0426 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0426"))
            .interestRate(0.015)
            .build();

    public static OtsProspectus TOS0526 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0526"))
            .interestRate(0.015)
            .build();

    public static OtsProspectus TOS0626 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0626"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS0726 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0726"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS0826 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0826"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS0926 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("0926"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS1026 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("1026"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS1126 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("1126"))
            .interestRate(0.03)
            .build();

    public static OtsProspectus TOS1226 = new OtsProspectusBuilder()
            .saleDateRange(DateRange.fromString("1226"))
            .interestRate(0.03)
            .build();
}
