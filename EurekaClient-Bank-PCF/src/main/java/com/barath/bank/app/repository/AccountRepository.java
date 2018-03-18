package com.barath.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.bank.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
