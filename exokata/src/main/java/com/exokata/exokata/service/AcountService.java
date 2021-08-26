package com.exokata.exokata.service;

import java.util.List;

import com.exokata.exokata.entity.Acount;

public interface AcountService {
	
	
	public Acount insertAcount(Acount acount);
	
	
	public Acount getAcountById(long id);
	
	
	public Acount getAcountByNumber(String AcNum);
	
	
	public List<Acount> getListAcount(long clientId);
	
	public Acount updateAcount(Acount acount);
	
}
