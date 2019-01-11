package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Laptop;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class LaptopManager {

	@PersistenceContext(unitName = "demoPU")
	EntityManager em;

	public void addLaptop(Laptop laptop) {
		em.persist(laptop);
	}

	public Laptop updateLaptop(Laptop laptop, long id) {
		laptop.setId(id);
		Laptop old = getLaptop(id);
		if(old != null) {
			em.merge(laptop);
		}
		return old;
	}

	public void deleteLaptop(long id) {
		Laptop laptop = getLaptop(id);
		if(laptop != null) {
			em.remove(laptop);
		}
 	}

	public Laptop getLaptop(long id) {
		return em.find(Laptop.class, id);
	}

	public List<Laptop> getAllLaptops(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Laptop> criteria = builder.createQuery(Laptop.class);
		Root<Laptop> laptopRoot = criteria.from(Laptop.class);
		laptopRoot.fetch("manufacturer", JoinType.LEFT);
		laptopRoot.fetch("serialCode", JoinType.LEFT);
		criteria.select(laptopRoot);
		return em.createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	public void deleteAllLaptops(){
		em.createNamedQuery("laptop.delete.all").executeUpdate();
	}

}
