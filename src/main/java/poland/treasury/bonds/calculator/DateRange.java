package poland.treasury.bonds.calculator;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public record DateRange(LocalDate startDate, LocalDate endDate) {
    public boolean containsDate(LocalDate date) {
        return (date.isEqual(startDate) || date.isAfter(startDate))
                &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }

    public boolean isBefore(DateRange dateRange) {
        return this.startDate.isBefore(dateRange.startDate) && this.endDate.isBefore(dateRange.endDate);
    }

    public boolean isAfter(DateRange dateRange) {
        return this.startDate.isAfter(dateRange.startDate) && this.endDate.isAfter(dateRange.endDate);
    }

    public long daysBetweenRange(){
        return DAYS.between(startDate, endDate);
    }
}
