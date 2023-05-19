package poland.treasury.bonds.calculator.database;

import poland.treasury.bonds.calculator.DateRange;
import poland.treasury.bonds.calculator.coi.CoiProspectus;
import poland.treasury.bonds.calculator.coi.CoiProspectusBuilder;

public class COI {
    public static CoiProspectus COI0126 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0126"))
            .firstYearInterestRate(0.013)
            .margin(0.0075)
            .build();

    public static CoiProspectus COI0226 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0226"))
            .firstYearInterestRate(0.018)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0326 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0326"))
            .firstYearInterestRate(0.018)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0426 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0426"))
            .firstYearInterestRate(0.023)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0526 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0526"))
            .firstYearInterestRate(0.033)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0626 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0626"))
            .firstYearInterestRate(0.055)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0726 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0726"))
            .firstYearInterestRate(0.06)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0826 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0826"))
            .firstYearInterestRate(0.065)
            .margin(0.01)
            .build();

    public static CoiProspectus COI0926 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("0926"))
            .firstYearInterestRate(0.065)
            .margin(0.01)
            .build();

    public static CoiProspectus COI1026 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1026"))
            .firstYearInterestRate(0.07)
            .margin(0.01)
            .build();

    public static CoiProspectus COI1126 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1126"))
            .firstYearInterestRate(0.07)
            .margin(0.01)
            .build();

    public static CoiProspectus COI1226 = new CoiProspectusBuilder()
            .buyBackDateRange(DateRange.fromString("1226"))
            .firstYearInterestRate(0.07)
            .margin(0.01)
            .build();
}
