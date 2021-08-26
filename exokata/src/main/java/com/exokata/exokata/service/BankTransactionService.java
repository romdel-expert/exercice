package com.exokata.exokata.service;

import java.util.List;

import com.exokata.exokata.entity.BankTransaction;

public interface BankTransactionService {
	
	
	public BankTransaction insertTransaction(BankTransaction bTrans);
	
	
	public BankTransaction getTransactionById(long id);
	
	
	public List<BankTransaction> getAllTransactionByAcount(long AcountId);
	
	
	public List<BankTransaction> getTransactionByType(String transType, long AcId);
	
}
