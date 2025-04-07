package com.example.calculate.controller;

import com.example.calculate.DTO.CalculationResponseDTO;
import com.example.calculate.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalculacteController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculacteController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    public CalculationResponseDTO calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) LocalDate startDate) {
        if (startDate != null) {
            return calculatorService.calculateVacationPayWithDates(averageSalary, startDate, vacationDays);
        } else {
            return calculatorService.calculateVacationPay(averageSalary, vacationDays);
        }
    }
}