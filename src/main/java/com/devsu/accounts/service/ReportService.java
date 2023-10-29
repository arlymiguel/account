package com.devsu.accounts.service;

import com.devsu.accounts.model.dto.ReportDto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ReportService {

   List<ReportDto> getReport(String startDate, String endDate, Long clientId) throws ParseException;

}
