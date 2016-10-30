package com.barath.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.bank.app.model.Account;
import com.barath.bank.app.model.Bank;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
