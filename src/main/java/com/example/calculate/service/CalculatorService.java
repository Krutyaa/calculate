package com.example.calculate.service;

import com.example.calculate.DTO.CalculationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.calculate.util.CalculatorUtil;

import java.time.LocalDate;

@Service
public class CalculatorService {

    private final CalculatorUtil vacationCalculatorUtil;

    @Autowired
    public CalculatorService(CalculatorUtil vacationCalculatorUtil) {
        this.vacationCalculatorUtil = vacationCalculatorUtil;
    }

    // Без учета праздников и выходных
    public CalculationResponseDTO calculateVacationPay(double averageSalary, int vacationDays) {
        double vacationPay = vacationCalculatorUtil.calculateVacationPay(averageSalary, vacationDays);
        return new CalculationResponseDTO(vacationPay);
    }

    // С учетом праздников и выходных
    public CalculationResponseDTO calculateVacationPayWithDates(double averageSalary, LocalDate startDate, int vacationDays) {
        double vacationPay = vacationCalculatorUtil.calculateVacationPayWithDates(averageSalary, startDate, vacationDays);
        return new CalculationResponseDTO(vacationPay);
    }
}