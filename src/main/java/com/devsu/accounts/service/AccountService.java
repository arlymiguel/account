package com.devsu.accounts.service;

import java.util.List;

import com.devsu.accounts.model.dto.AccountDto;

public interface AccountService {

	AccountDto create(AccountDto account);

	AccountDto update(AccountDto account, Long id);

	void deleteById(Long id);

	AccountDto getById(Long id);

	List<AccountDto> getAll();

}
