package com.example.calculate.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Component
public class CalculatorUtil {

    // Каникулы
    private final List<LocalDate> publicHolidays = List.of(
            // Новогодние каникулы
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),
            // Рождество Христово
            LocalDate.of(2024, 1, 7),
            LocalDate.of(2024, 1, 8),
            // День защитника Отечества
            LocalDate.of(2024, 2, 23),
            // Международный женский день
            LocalDate.of(2024, 3, 8),
            // Праздник Весны и Труда
            LocalDate.of(2024, 5, 1),
            // День Победы
            LocalDate.of(2024, 5, 9),
            // День России
            LocalDate.of(2024, 6, 12),
            // День программиста
            LocalDate.of(2024, 9, 12),
            // День народного единства
            LocalDate.of(2024, 11, 4)
    );

    @Value("${workDaysInMonth}")
    private double workDaysInMonth;

    // Расчет суммы отпускных без учета выходных и отпускных
    public double calculateVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / workDaysInMonth) * vacationDays;
    }

    // Расчет суммы отпускных с учетом выходных и отпускных (?)
    public double calculateVacationPayWithDates(double averageSalary, LocalDate startDate, int vacationDays) {
        int actualVacationDays = 0;
        LocalDate date = startDate;

        while (actualVacationDays < vacationDays) {
            System.out.println("Checking date: " + date);
            if (!isWeekend(date) && !isPublicHoliday(date)) {
                actualVacationDays++;
                System.out.println("Included: " + date);
            } else {
                System.out.println("Excluded: " + date);
            }
            date = date.plusDays(1);
        }

        System.out.println("Total included vacation days: " + actualVacationDays);
        return (averageSalary / workDaysInMonth) * actualVacationDays;
    }

    // Суббота и воскресенье - выходные дни
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    // Проверка даты на праздниные дни
    private boolean isPublicHoliday(LocalDate date) {
        return publicHolidays.contains(date);
    }
}