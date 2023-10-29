package com.devsu.accounts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.accounts.service.AccountService;

import com.devsu.accounts.model.dto.AccountDto;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public AccountDto crear(@RequestBody @Valid AccountDto account) {
		AccountDto newAccount = accountService.create(account);

		return newAccount;
	}

	@DeleteMapping("/{idParam}")
	public void delete(@PathVariable(value = "idParam") Long id) {
		accountService.deleteById(id);

	}

	@PutMapping("/{id}")
	public AccountDto update(@RequestBody @Valid AccountDto client, @PathVariable(value = "id") Long id) {
		AccountDto accountUpdated = accountService.update(client, id);
		return accountUpdated;

	}

	@GetMapping("/{id}")
	public AccountDto getByid(@PathVariable(value = "id") Long id) {
		AccountDto accountObtain = accountService.getById(id);
		return accountObtain;
	}

	@GetMapping
	public List<AccountDto> getAll() {

		return accountService.getAll();
	}

}
