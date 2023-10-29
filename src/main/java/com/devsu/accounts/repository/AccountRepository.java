package com.devsu.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.accounts.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
