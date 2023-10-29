package com.devsu.accounts.controller;

import com.devsu.accounts.model.dto.MovementDto;
import com.devsu.accounts.model.dto.ReportDto;
import com.devsu.accounts.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportDto> getReport(@RequestParam(value = "startDate") String startDate,
                                     @RequestParam(value = "endDate") String endDate,
                                     @RequestParam(value = "clientId") Long clientId) throws ParseException {
        return reportService.getReport(startDate,endDate, clientId);
    }

}
