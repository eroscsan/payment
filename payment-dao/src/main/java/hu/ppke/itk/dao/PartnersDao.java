package hu.ppke.itk.dao;

import java.util.List;

import hu.ppke.itk.model.Partners;

public interface PartnersDao {
	void save(Partners p);
	void saveAll(List<Partners> p);
	Partners find(int id);
	List<Partners> findAll();
}
 