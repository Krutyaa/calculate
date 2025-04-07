package com.example.calculate.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@Component
public class CalculatorUtil {

    // Праздничные дни
    private final List<MonthDay> publicHolidays = List.of(
            // Новогодние каникулы
            MonthDay.of(1, 1),
            MonthDay.of(1, 2),
            MonthDay.of(1, 3),
            MonthDay.of(1, 4),
            MonthDay.of(1, 5),
            MonthDay.of(1, 6),
            // Рождество Христово
            MonthDay.of(1, 7),
            MonthDay.of(1, 8),
            // День защитника Отечества
            MonthDay.of(2, 23),
            // Международный женский день
            MonthDay.of(3, 8),
            // Праздник Весны и Труда
            MonthDay.of(5, 1),
            // День Победы
            MonthDay.of(5, 9),
            // День России
            MonthDay.of(6, 12),
            // День программиста
            MonthDay.of(9, 12),
            // День народного единства
            MonthDay.of(11, 4)
    );

    @Value("${workDaysInMonth}")
    private double workDaysInMonth;

    // Расчет суммы отпускных без учета выходных и отпускных
    public double calculateVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / workDaysInMonth) * vacationDays;
    }

    // Расчет отпускных с учетом праздников
    public double calculateVacationPayWithDates(double averageSalary, LocalDate startDate, int vacationDays) {
        int actualVacationDays = 0;
        double holidayPay = 0;
        LocalDate date = startDate;

        while (actualVacationDays < vacationDays) {
            if (isPublicHoliday(date)) {
                holidayPay += (averageSalary / workDaysInMonth);
            } else {
                actualVacationDays++;
            }
            date = date.plusDays(1);
        }

        return (averageSalary / workDaysInMonth) * actualVacationDays + holidayPay;
    }

    // Проверка на праздничные дни
    private boolean isPublicHoliday(LocalDate date) {
        MonthDay monthDay = MonthDay.from(date);
        return publicHolidays.contains(monthDay);
    }
}