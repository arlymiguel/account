package com.devsu.accounts.service.impl;

import com.devsu.accounts.client.ClientServiceFeignClient;
import com.devsu.accounts.mapper.MovementMapper;
import com.devsu.accounts.model.dto.ClientDto;
import com.devsu.accounts.model.dto.ReportDto;
import com.devsu.accounts.model.entity.Movement;
import com.devsu.accounts.repository.AccountRepository;
import com.devsu.accounts.repository.MovementRepository;
import com.devsu.accounts.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientServiceFeignClient clientServiceFeignClient;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<ReportDto> getReport(String startDate, String endDate, Long clientId) throws ParseException {


        List<Movement> movementFiltered = movementRepository.findByDateBetween(sdf.parse(startDate), sdf.parse(endDate)).stream()
                .filter(movement -> movement.getAccount().getClientId().equals(clientId) ).toList();

        List<ReportDto> reportList = new ArrayList<>();
        movementFiltered.stream().forEach(movement->{

            ClientDto client = clientServiceFeignClient.getById(clientId);

            ReportDto reportDto = ReportDto.builder()
                    .movementDate(movement.getDate())
                    .client(client.getPerson().getName())
                    .accountNumber(movement.getAccount().getAccountNumber())
                    .accountType(movement.getAccount().getType())
                    .balance(movement.getAccount().getInitialBalance())
                    .state(movement.getAccount().isState())
                    .movementValue(movement.getValue())
                    .build();
            reportList.add(reportDto);
        });

        return reportList;
    }
}
