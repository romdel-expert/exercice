package com.exokata.exokata.service;

import com.exokata.exokata.entity.Client;

public interface ClientService {
	
	
	
	public Client insertClient(Client client);
	
	public Client getClientById(long id);
	
	public Client getClientByNum(long numClient);
	
	public Client getClientByNumAndSecretK(long numClient, int key);
}
