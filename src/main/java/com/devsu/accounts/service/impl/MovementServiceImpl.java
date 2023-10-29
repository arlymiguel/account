package com.devsu.accounts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devsu.accounts.exception.BalanceException;
import com.devsu.accounts.exception.MovementNotFoundException;
import com.devsu.accounts.model.entity.Account;
import com.devsu.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.accounts.mapper.MovementMapper;
import com.devsu.accounts.repository.MovementRepository;
import com.devsu.accounts.service.MovementService;

import com.devsu.accounts.model.dto.MovementDto;
import com.devsu.accounts.model.entity.Movement;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private MovementMapper movementMapper;

	@Override
	public MovementDto create(MovementDto movementDto) {



		Optional<Account> account = accountRepository.findById(movementDto.getAccountId());
		if (account.isPresent()) {
			Double valueToApply = movementDto.getValue();
			Account accountToUpdate = account.get();

			double amount = calculateBalance(valueToApply, accountToUpdate.getInitialBalance());

			accountToUpdate.setInitialBalance( amount );
			accountRepository.save(accountToUpdate);

			Movement movement = movementMapper.toMovement(movementDto);
			movement.setBalance(amount);
			movement.setAccountId(movementDto.getAccountId());
			movementRepository.save(movement);

			movementDto.setBalance(amount);
		}



		return movementDto;
	}

	private Double calculateBalance(Double valueToApply, Double initialBalance) {
		double balance =  initialBalance + valueToApply;
		if (balance < 0) {
			throw  new BalanceException("Insufficient balance");
		}
		return balance;
	}

	@Override
	public MovementDto update(MovementDto movementDto, Long id) {
		MovementDto movementFound = getById(id);

		movementFound = movementDto;

		Movement movementToUpdate = movementMapper.toMovement(movementFound);

		movementToUpdate.setId(id);

		movementRepository.save(movementToUpdate);

		return movementDto;
	}

	@Override
	public void deleteById(Long id) {

		movementRepository.deleteById(id);

	}

	@Override
	public MovementDto getById(Long id) {

		Optional<Movement> movementFound = movementRepository.findById(id);
		if (movementFound.isPresent()) {
			return movementMapper.toMovementDto(movementFound.get());

		}

		throw new MovementNotFoundException("Movement not found");

	}

	@Override
	public List<MovementDto> getAll() {

		List<MovementDto> listMovementsDto = new ArrayList<>();

		movementRepository.findAll().stream()
				.forEach(movement -> listMovementsDto.add(movementMapper.toMovementDto(movement)));

		return listMovementsDto;
	}

}
