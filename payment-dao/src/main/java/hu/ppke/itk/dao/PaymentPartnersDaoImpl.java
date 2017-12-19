package hu.ppke.itk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hu.ppke.itk.model.Partners;

public class PaymentPartnersDaoImpl implements PartnersDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Partners p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(p);
		tx.commit();
		session.close();
	}

	public void saveAll(List<Partners> p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (Partners partners : p) {
			session.merge(partners);
		}
		tx.commit();
		session.close();
	}

	public Partners find(int id) {
		Session session = this.sessionFactory.openSession();
		Partners partners = (Partners) session.getNamedQuery("findByID")
				.setInteger("id", id).uniqueResult();
		session.close();
		return partners;
	}

	@SuppressWarnings("unchecked")
	public List<Partners> findAll() {
		Session session = this.sessionFactory.openSession();
		List<Partners> partners = session.getNamedQuery("findAll").list();
		session.close();
		return partners;
	}
}