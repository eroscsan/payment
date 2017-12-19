package hu.ppke.itk.dao;

import java.util.Date;
import java.util.List;

import hu.ppke.itk.model.PaymentType;
import hu.ppke.itk.model.Transactions;

public interface TransactionsDao {
	
	void save(Transactions p);
	void saveAll(List<Transactions> p);
	Transactions find(int id);
	List<Transactions> findByDate(Date d);
	List<Transactions> findByType(PaymentType pt);
	List<Transactions> findAll();

}
