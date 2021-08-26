package com.exokata.exokata.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exokata.exokata.entity.Acount;
import com.exokata.exokata.entity.BankTransaction;
import com.exokata.exokata.entity.Client;
import com.exokata.exokata.param.Login;
import com.exokata.exokata.param.ParamValue;
import com.exokata.exokata.service.AcountService;
import com.exokata.exokata.service.BankTransactionService;
import com.exokata.exokata.service.ClientService;

@RestController
@CrossOrigin
public class BankController {
	
	@Autowired
	private ClientService clientServ;
	
	@Autowired
	private AcountService acountServ;
	
	
	@Autowired
	private BankTransactionService bTransServ;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param clientId
	 * @return
	 * this method is used to get a client of the bank by using his id
	 */
	@GetMapping("/client/{clientId}")
	public Client getClientById(@PathVariable String clientId) {
		Client client=clientServ.getClientById(Long.parseLong(clientId));
		return client;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param login
	 * @return
	 * this method allows to the user to connect on the application
	 */
	@PostMapping("/login")
	public Client logingClient(@RequestBody Login login) {
		
		
		Client client=null;
		
		try {
			Client c=clientServ.getClientByNumAndSecretK(login.getClientNum(), login.getSecretCode());
			//System.out.println(c.getId());
			if(c!=null) {
				client=c;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return client;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param client
	 * @return
	 * insert a new client of the bank in the database
	 */
	@PostMapping("/client_insert")
	public Client insertClient(@RequestBody Client client) {
		Client newClient=null;
		long clientNumber;
		
		try {
			
			do {
				clientNumber=this.createClienttNum();
				//System.out.print(this.isAcountNumberExist(acNumber));
			}while(this.isClientNumberExist(clientNumber));
			if(clientNumber!=0) {
				client.setClientNum(clientNumber);
				Client c=clientServ.insertClient(client);
				if(c!=null) {
					newClient=clientServ.getClientByNum(clientNumber);
					//System.out.print(newClient);
					Acount ac=new Acount();
					ac.setId(0);
					ac.setAcTitle("Compte principal");
					ac.setBalance(0);
					ac.setClientId(newClient.getId());
					
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = new Date();				
					ac.setDateCreatedAcc(format.format(date));
					
					List<Acount> princ=this.saveNewAcount(ac);
					//System.out.print(princ);
				}
				
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		
		return newClient;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param acount
	 * @return
	 * insert a new acount in the database
	 */
	@PostMapping("/acount_insert")
	public List<Acount> insertAcount(@RequestBody Acount ac) {
		return this.saveNewAcount(ac);
	}
	
	
	
	
	
	private List<Acount>  saveNewAcount(Acount ac) {
		List<Acount> list=null;
		String acNumber="";
		try {
			do {
				acNumber=this.createAcountNum();
				//System.out.print(this.isAcountNumberExist(acNumber));
			}while(this.isAcountNumberExist(acNumber));
			if(ac!=null) {
				ac.setAccountNum(acNumber);
				Acount a=acountServ.insertAcount(ac);
				if(a!=null) {
					list=acountServ.getListAcount(ac.getClientId());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	/**
	 * create automatialy the acount number
	 * @return
	 */
	private String createAcountNum() {
		String acountNum="";
		Random rand = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int lengthNum = alphabet.length();
		for(int i = 0; i < 10; i++) {
		  int k = rand.nextInt(lengthNum);
		  acountNum=acountNum+alphabet.charAt(k);
		}
		//System.out.print(acountNum);
		return acountNum;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * create automatialy the client number
	 * @return
	 */
	private long createClienttNum() {
		long clientNum=0;
		String acText="";
		Random rand = new Random();
		String allNumber = "0123456789";
		int lengthNum = allNumber.length();
		for(int i = 0; i < 8; i++) {
		  int k = rand.nextInt(lengthNum);
		  acText=acText+allNumber.charAt(k);
		  clientNum=Long.parseLong(acText);
		}
		//System.out.print(acountNum);
		return clientNum;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * chek if the acount number doesn't existed in the data base
	 * @param acNum
	 * @return
	 */
	private boolean isAcountNumberExist(String acNum) {
		boolean isExist=false;
		Acount a=acountServ.getAcountByNumber(acNum);
		if (a!=null) {
			isExist=true;
		}
		return isExist;
	}
	
	
	
	
	
	
	
	
	/**
	 * chek if the client number doesn't existed in the data base
	 * @param acNum
	 * @return
	 */
	private boolean isClientNumberExist(long clientNum) {
		boolean isExist=false;
		Client c=clientServ.getClientByNum(clientNum);
		if (c!=null) {
			isExist=true;
		}
		return isExist;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param clientId
	 * @return
	 * get all the acount of a client of the bank
	 */
	@GetMapping("/acount/{clientId}")
	public List<Acount> getAllAcountByClientId(@PathVariable String clientId) {
		return acountServ.getListAcount(Long.parseLong(clientId));
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param acNum
	 * @return
	 * get a specific acount by using his id
	 */
	@GetMapping("/ac_id/{acId}")
	public Acount getAcountById(@PathVariable String acId) {
		return acountServ.getAcountById(Long.parseLong(acId));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param acNum
	 * @return
	 * get a specific acount by using his number
	 */
	@GetMapping("/acount_one/{acNum}")
	public Acount getAcountByNum(@PathVariable String acNum) {
		return acountServ.getAcountByNumber(acNum);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param bakTranns
	 * @return
	 * to insert a new bank transaction relative to an acount of a client of the bank
	 */
	@PostMapping("/trans_insert")
	public List<BankTransaction> insertBankTransaction(@RequestBody BankTransaction bankTranns) {
		
		List<BankTransaction> list=null;
		
		try {
			
			Acount acount=acountServ.getAcountById(bankTranns.getAcountId());
			if(acount!=null) {
				if(bankTranns.getTypeTransaction().equals(ParamValue.CREDIT_BANK_TRANSACTION)) {
					float balance=(float) acount.getBalance();
					balance+=bankTranns.getAmountTransaction();
					bankTranns.setBalance(balance);
					BankTransaction b=bTransServ.insertTransaction(bankTranns);
					if(b!=null) {
						list=bTransServ.getAllTransactionByAcount(bankTranns.getAcountId());
						acount.setBalance(balance);
						acountServ.updateAcount(acount);
					}
				}
				
				else if (bankTranns.getTypeTransaction().equals(ParamValue.DEB_BANK_TRANSACTION)) {
					float balance=(float) acount.getBalance();
					if(balance>bankTranns.getAmountTransaction()) {
						balance-=bankTranns.getAmountTransaction();
						bankTranns.setBalance(balance);
						BankTransaction b=bTransServ.insertTransaction(bankTranns);
						if(b!=null) {
							list=bTransServ.getAllTransactionByAcount(bankTranns.getAcountId());
							acount.setBalance(balance);
							acountServ.updateAcount(acount);
						}
					}else {
						list=bTransServ.getAllTransactionByAcount(bankTranns.getAcountId());
					}
				}
				else {
					list=bTransServ.getAllTransactionByAcount(bankTranns.getAcountId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param transId
	 * @return
	 * get a transaction by using his id
	 */
	@GetMapping("/trans_id/{transId}")
	public BankTransaction getBankTransactionById(@PathVariable String transId) {
		BankTransaction transact=null;
		try {
			BankTransaction bt=bTransServ.getTransactionById(Long.parseLong(transId));
			if(bt!=null) {
				transact=bt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transact;
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param acId
	 * @return
	 * get all the bank trasactions of an acount of a client of the bank
	 */
	@GetMapping("/transaction/{acId}")
	public List<BankTransaction> getBankTransaction(@PathVariable String acId) {
		List<BankTransaction> list=null;
		try {
			List<BankTransaction> all=bTransServ.getAllTransactionByAcount(Long.parseLong(acId));
			if(all!=null) {
				list=all;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	@GetMapping("/transac_type")
	public List<BankTransaction> getBankTransactionByType() {
		return bTransServ.getTransactionByType("CREDIT", 100);
	}
}
