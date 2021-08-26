package com.exokata.exokata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exokata.exokata.entity.Client;

public interface ClientDao extends JpaRepository<Client, Long>{
	
	
	
}
