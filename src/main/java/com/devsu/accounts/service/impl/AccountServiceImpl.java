package com.devsu.accounts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devsu.accounts.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.accounts.mapper.AccountMapper;
import com.devsu.accounts.repository.AccountRepository;
import com.devsu.accounts.service.AccountService;

import com.devsu.accounts.model.dto.AccountDto;
import com.devsu.accounts.model.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public AccountDto create(AccountDto accountDto) {
		
		Account account = accountMapper.toAccount(accountDto);
		accountRepository.save(account);

		return accountDto;
	}

	@Override
	public AccountDto update(AccountDto accountDto, Long id) {

		AccountDto accountFound = getById(id);

		accountFound = accountDto;

		Account accountToUpdate = accountMapper.toAccount(accountFound);

		accountToUpdate.setId(id);

		accountRepository.save(accountToUpdate);

		return accountDto;
	}

	@Override
	public void deleteById(Long id) {

		accountRepository.deleteById(id);

	}

	@Override
	public AccountDto getById(Long id) {

		Optional<Account> accountFound = accountRepository.findById(id);
		if (accountFound.isPresent()) {
			return accountMapper.toAccountDto(accountFound.get());

		}

		throw new AccountNotFoundException("Account not found");
	}

	@Override
	public List<AccountDto> getAll() {

		List<AccountDto> listAccountsDto = new ArrayList<>();

		accountRepository.findAll().stream()
				.forEach(account -> listAccountsDto.add(accountMapper.toAccountDto(account)));

		return listAccountsDto;
	}

}
