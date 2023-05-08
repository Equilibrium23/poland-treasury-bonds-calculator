package poland.treasury.bonds.calculator;

import java.time.LocalDate;
import java.time.YearMonth;

import static java.time.temporal.ChronoUnit.DAYS;

public record DateRange(LocalDate startDate, LocalDate endDate) {
    public static DateRange fromString(String string){
        if (string.length() != 4){
            throw new IllegalArgumentException();
        }
        int month = Integer.parseInt(string.substring(0, 2));
        int year = Integer.parseInt("20" + string.substring(2, 4));
        return new DateRange(LocalDate.of(year, month, 1), LocalDate.of(year, month, YearMonth.of(year, month).lengthOfMonth()));
    }
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

    @Override
    public String toString() {
        return "DateRange{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
