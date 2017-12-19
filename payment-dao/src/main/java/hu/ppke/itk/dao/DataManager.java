package hu.ppke.itk.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hu.ppke.itk.model.Transactions;

public class DataManager {
	
	private static DataManager instance = null;
	private ApplicationContext appContext;
	
	private PaymentTypeDao paymentTypeDao;
	private PartnersDao partnersDao;
	private TransactionsDao transactionsDao;
	
	public static DataManager getInstance() {
		if(instance == null) {
			instance = new DataManager();
		}
		
		return instance;
	}

	private DataManager() {
		appContext = new ClassPathXmlApplicationContext("classpath*:app-context.xml");
		paymentTypeDao = (PaymentTypeDao) appContext.getBean("paymentTypeDao");
		partnersDao = appContext.getBean("partnersDao", PaymentPartnersDaoImpl.class);
		transactionsDao = appContext.getBean("transactionDao", PaymentTransactionDaoImpl.class);

	}
	
	public void insertTransaction(Transactions transactions) {
		transactionsDao.save(transactions);
	}
	
	public Transactions getTransactionByID(int id) {
		
		return transactionsDao.find(id);
	}
}
