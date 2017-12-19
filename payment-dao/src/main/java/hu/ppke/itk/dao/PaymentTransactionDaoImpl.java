package hu.ppke.itk.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hu.ppke.itk.model.PaymentType;
import hu.ppke.itk.model.Transactions;

public class PaymentTransactionDaoImpl implements TransactionsDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Transactions p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(p);
		tx.commit();
		session.close();
	}

	public void saveAll(List<Transactions> p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (Transactions transactions : p) {
			session.merge(transactions);
		}
		tx.commit();
		session.close();
	}

	public Transactions find(int id) {
		Session session = this.sessionFactory.openSession();
		Transactions transaction = (Transactions) session.getNamedQuery("findByID")
				.setInteger("id", id).uniqueResult();
		session.close();
		return transaction;
	}

	@SuppressWarnings("unchecked")
	public List<Transactions> findByDate(Date d) {
		Session session = this.sessionFactory.openSession();
		List<Transactions> transaction = session.getNamedQuery("findByDate")
				.setLong("transferDate", d.getTime()).list();
		session.close();
		return transaction;
	}

	@SuppressWarnings("unchecked")
	public List<Transactions> findByType(PaymentType pt) {
		Session session = this.sessionFactory.openSession();
		List<Transactions> transaction = session.getNamedQuery("findByType")
				.setEntity("paymentType", pt).list();
		session.close();
		return transaction;
	}

	@SuppressWarnings("unchecked")
	public List<Transactions> findAll() {
		Session session = this.sessionFactory.openSession();
		List<Transactions> transaction = session.getNamedQuery("findAll").list();
		session.close();
		return transaction;
	}

}
