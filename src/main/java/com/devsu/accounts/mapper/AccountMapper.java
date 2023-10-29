package com.devsu.accounts.mapper;

import org.springframework.stereotype.Component;

import com.devsu.accounts.model.dto.AccountDto;
import com.devsu.accounts.model.entity.Account;

@Component
public class AccountMapper {

	public Account toAccount(AccountDto accountDto) {
		Account account = new Account();

		account.setAccountNumber(accountDto.getAccountNumber());
		account.setClientId(accountDto.getClientId());
		account.setInitialBalance(accountDto.getInitialBalance());
		account.setType(accountDto.getType());
		account.setState(accountDto.isState());

		return account;
	}

	public AccountDto toAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();

		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setClientId(account.getClientId());
		accountDto.setInitialBalance(account.getInitialBalance());
		accountDto.setType(account.getType());
		accountDto.setState(account.isState());

		return accountDto;
	}
}
