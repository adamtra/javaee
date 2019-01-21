package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Laptop;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Stateless
public class LaptopManager {

	@PersistenceContext(unitName = "demoPU")
	EntityManager em;

	public void addLaptop(Laptop laptop) {
		em.persist(laptop);
	}

	public boolean updateLaptop(Laptop laptop, long id) {
		laptop.setId(id);
		Laptop old = getLaptop(id);
		if(old != null) {
			em.merge(laptop);
			return true;
		}
		return false;
	}

	public void deleteLaptop(long id) {
		Laptop laptop = getLaptop(id);
		if(laptop != null) {
			em.remove(laptop);
		}
 	}

	@SuppressWarnings("unchecked")
	public Laptop getLaptop(long id) {
		Query q = em.createNamedQuery("laptop.findById");
		q.setParameter("id", id);
		List<Laptop> resultList = q.getResultList();
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		return null;
	}

	public List<Laptop> getAllLaptops(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Laptop> criteria = builder.createQuery(Laptop.class);
		Root<Laptop> laptopRoot = criteria.from(Laptop.class);
		laptopRoot.fetch("manufacturer", JoinType.LEFT);
		laptopRoot.fetch("serialCode", JoinType.LEFT);
		laptopRoot.fetch("owners", JoinType.LEFT);
		criteria.distinct(true);
		return em.createQuery(criteria).getResultList();
	}

	public List<Laptop> getLaptopsNewerOrOlderThan(boolean newer, Date releaseDate){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Laptop> criteria = builder.createQuery(Laptop.class);
		Root<Laptop> laptopRoot = criteria.from(Laptop.class);
		laptopRoot.fetch("manufacturer", JoinType.LEFT);
		laptopRoot.fetch("serialCode", JoinType.LEFT);
		laptopRoot.fetch("owners", JoinType.LEFT);
		Predicate condition = builder.greaterThanOrEqualTo(laptopRoot.get("releaseDate"), releaseDate);
		if(!newer) {
			condition = builder.lessThanOrEqualTo(laptopRoot.get("releaseDate"), releaseDate);
		}
		criteria.where(condition);
		criteria.distinct(true);
		return em.createQuery(criteria).getResultList();
	}


	@SuppressWarnings("unchecked")
	public void deleteAllLaptops(){
		em.createNamedQuery("laptop.delete.all").executeUpdate();
	}

}
