package com.exokata.exokata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exokata.exokata.dao.AcountDao;
import com.exokata.exokata.entity.Acount;

@Service
public class AcountServImpl implements AcountService{

	@Autowired
	private AcountDao acountDao;
	
	
	public AcountServImpl() {
		super();
	}

	
	
	
	
	/**
	 * innsert a new acount for a client in the database
	 */
	@Override
	public Acount insertAcount(Acount acount) {
		return acountDao.save(acount);
	}

	
	
	
	@Override
	public Acount getAcountById(long id) {
		Acount acount=null;
		
		try {
			List<Acount> list=acountDao.findAll();
			for (Acount a : list) {
				if(a.getId()==id) {
					acount=a;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return acount;
		//return acountDao.getById(id);
	}
	
	
	
	
	
	
	
	/**
	 * Get acount of a client of the bank by using the acount number
	 */
	@Override
	public Acount getAcountByNumber(String acNum) {
		Acount acount=null;
		
		try {
			List<Acount> list=acountDao.findAll();
			for (Acount a : list) {
				if(a.getAccountNum().equals(acNum)) {
					acount=a;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return acount;
	}
	
	
	
	
	
	/**
	 * get all the acount for one cleint of the bank
	 */
	@Override
	public List<Acount> getListAcount(long clientId) {
		List<Acount> list=null;
		try {
			List<Acount> allAcount=acountDao.findAll();
			System.out.print(allAcount);
			
			if(allAcount!=null){
				list=new ArrayList<>();
				for (Acount acount : allAcount) {
					if(acount.getClientId()==clientId) {
						list.add(acount);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}





	@Override
	public Acount updateAcount(Acount acount) {
		return acountDao.save(acount);
	}
}
