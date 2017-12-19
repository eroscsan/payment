package hu.ppke.itk;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hu.ppke.itk.dao.DataManager;
import hu.ppke.itk.dao.PartnersDao;
import hu.ppke.itk.dao.PaymentPartnersDaoImpl;
import hu.ppke.itk.dao.PaymentTransactionDaoImpl;
import hu.ppke.itk.dao.PaymentTypeDao;
import hu.ppke.itk.dao.PaymentTypeDaoImpl;
import hu.ppke.itk.dao.TransactionsDao;
import hu.ppke.itk.model.Partners;
import hu.ppke.itk.model.PaymentType;
import hu.ppke.itk.model.Transactions;

public class TestDataManager {

	@Test
	public void test() {
		DataManager manager = DataManager.getInstance();
		/*ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:OrderPersistenceTests-context.xml");
		
		PaymentTypeDao paymentTypeDao = appContext.getBean("paymentTypeDao", PaymentTypeDaoImpl.class);
		PartnersDao partnersDao = appContext.getBean("partnersDao", PaymentPartnersDaoImpl.class);
		TransactionsDao transactionsDao = appContext.getBean("transactionDao", PaymentTransactionDaoImpl.class);
		*/
		PaymentType typeForint = new PaymentType();
		typeForint.setName("forint");
		
		PaymentType typeDeviza = new PaymentType();
		typeDeviza.setName("deviza");
		
		Partners partner = new Partners();
		partner.setName("Csanád");
		partner.setAccountNumber("2");
		
		
		Transactions t = new Transactions();
		t.setId(1);
		t.setPartners(partner);
		t.setPaymentType(typeDeviza);
		t.setAmount(3.14F);
		t.setCreate(System.currentTimeMillis());
		t.setFeeCalculation(true);
		t.setTransferDate(System.currentTimeMillis());
		
		manager.insertTransaction(t);
		
		Transactions t2 = manager.getTransactionByID(t.getId());
		
		assertEquals(t2.getId(), 1);

		
	}

}
