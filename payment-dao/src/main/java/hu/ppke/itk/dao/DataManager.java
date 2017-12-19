package hu.ppke.itk.dao;

import hu.ppke.itk.model.Transactions;

public class DataManager {
	
	private PaymentTypeDao paymentTypeDao;
	private PartnersDao partnersDao;
	private TransactionsDao transactionsDao;

	public void setPaymentTypeDao(PaymentTypeDao paymentTypeDao) {
		this.paymentTypeDao = paymentTypeDao;
	}

	public void setPartnersDao(PartnersDao partnersDao) {
		this.partnersDao = partnersDao;
	}

	public void setTransactionsDao(TransactionsDao transactionsDao) {
		this.transactionsDao = transactionsDao;
	}

	public DataManager() {}
	
	public void insertTransaction(Transactions transactions) {
		transactionsDao.save(transactions);
	}
	
	public Transactions getTransactionByID(int id) {
		
		return transactionsDao.find(id);
	}
}
