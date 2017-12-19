package hu.ppke.itk.dao;

import java.util.List;

import hu.ppke.itk.model.PaymentType;

public interface PaymentTypeDao {

	void save(PaymentType p);
	void saveAll(List<PaymentType> p);
	PaymentType find(int id);
	List<PaymentType> findAll();

}
