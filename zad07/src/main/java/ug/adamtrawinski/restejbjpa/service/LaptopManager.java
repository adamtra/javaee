package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Laptop;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LaptopManager {

	@PersistenceContext(unitName = "demoPU")
	EntityManager em;

	public void addLaptop(Laptop laptop) {
		em.persist(laptop);
	}

//	public Laptop updateLaptop(Laptop laptop) {
//		for (int i = 0; i < db.size(); i++) {
//			if(db.get(i).getId() == laptop.getId()) {
//				db.set(i, laptop);
//				return laptop;
//			}
//		}
//		return null;
//	}
//
//	public void deleteLaptop(long id){
//		Laptop delete = null;
//		for(Laptop laptop: db) {
//			if(laptop.getId() == id) {
//				delete = laptop;
//				break;
//			}
//		}
//		db.remove(delete);
// 	}
//
	public Laptop getLaptop(long id) {
		return em.find(Laptop.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Laptop> getAllLaptops(){
		return em.createNamedQuery("laptop.all").getResultList();
	}

	public void deleteAllLaptops(){
		em.createNamedQuery("laptop.delete.all").executeUpdate();;
	}

}
