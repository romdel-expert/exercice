package com.exokata.exokata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exokata.exokata.dao.BankTrasactionDao;
import com.exokata.exokata.entity.BankTransaction;



@Service
public class BankTransactionServiceImpl implements BankTransactionService{

	
	@Autowired
	BankTrasactionDao bankTrasDao;
	
	public BankTransactionServiceImpl() {
		super();
	}
	
	
	
	
	

	/**
	 * this method is used to insert a new bank transaction in the data base
	 */
	@Override
	public BankTransaction insertTransaction(BankTransaction bTrans) {
		return bankTrasDao.save(bTrans);
	}

	
	
	
	/**
	 * this method is used to get a trasaction by using her id
	 */
	@Override
	public BankTransaction getTransactionById(long id) {
		BankTransaction bankTras=null;
		try {
			List<BankTransaction> allTrans=bankTrasDao.findAll();
			if(allTrans!=null) {
				for (BankTransaction bt : allTrans) {
					if(bt.getAcountId()==id) {
						bankTras=bt;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//return bankTrasDao.getById(id);
		return bankTras;
	}

	
	
	
	
	
	/**
	 * this method is used to get all the bank trasactions of 
	 * an acount of a cliennt of the bank
	 */
	@Override
	public List<BankTransaction> getAllTransactionByAcount(long acountId) {
		List<BankTransaction> list=null;
		
		
		try {
			List<BankTransaction> allTrans=bankTrasDao.findAll();
			if(allTrans!=null) {
				list=new ArrayList<>();
				for (BankTransaction bt : allTrans) {
					if(bt.getAcountId()==acountId) {
						list.add(bt);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}





	/**
	 * this method is used to get the bank transaction of an acount by type
	 */
	@Override
	public List<BankTransaction> getTransactionByType(String transType, long acountId) {
		List<BankTransaction> list=null;
		
		
		try {
			List<BankTransaction> allTrans=bankTrasDao.findAll();
			if(allTrans!=null) {
				list=new ArrayList<>();
				for (BankTransaction bt : allTrans) {
					if(bt.getAcountId()==acountId && bt.getTypeTransaction()==transType) {
						list.add(bt);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
