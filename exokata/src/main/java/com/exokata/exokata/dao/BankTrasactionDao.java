package com.exokata.exokata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exokata.exokata.entity.BankTransaction;

public interface BankTrasactionDao extends JpaRepository<BankTransaction, Long>{

}
