package com.exokata.exokata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exokata.exokata.dao.ClientDao;
import com.exokata.exokata.entity.Client;


@Service
public class ClientServImpl implements ClientService{
	
	
	@Autowired
	private ClientDao clientDao;

	
	/**
	 * constructor
	 */
	public ClientServImpl() {
		super();
	}

	
	/**
	 * this method allows to insert e new client of the bank in the database
	 */
	@Override
	public Client insertClient(Client client) {
		return clientDao.save(client);
	}

	
	
	@Override
	public Client getClientById(long id) {
		
		Client client=clientDao.getById(id);
		/*try {
			client=clientDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return client;
	}



	
	
	@Override
	public Client getClientByNumAndSecretK(long numClient, int key) {
		Client client=null;
		try {
			List<Client> list=clientDao.findAll();
			for (Client c : list) {
				if(c.getClientNum()==numClient && c.getSecretCode()==key) {
					client=c;
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return client;
	}


	@Override
	public Client getClientByNum(long numClient) {
		Client client=null;
		try {
			List<Client> list=clientDao.findAll();
			for (Client c : list) {
				if(c.getClientNum()==numClient) {
					client=c;
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return client;
	}

}
