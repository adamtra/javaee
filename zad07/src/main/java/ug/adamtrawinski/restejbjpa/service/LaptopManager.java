package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Laptop;
import ug.adamtrawinski.restejbjpa.domain.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

	@Inject
	PersonManager pm;

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
	public List<Laptop> getLaptopsByNameLike(String name) {
		Query q = em.createNamedQuery("laptop.findByNameLike");
		q.setParameter("name", name);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Laptop> getLaptopsPriceBetween(double min, double max) {
		Query q = em.createNamedQuery("laptop.findPriceBetween");
		q.setParameter("min", min);
		q.setParameter("max", max);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Laptop getLaptopBySerialCode(String code) {
		Query q = em.createNamedQuery("laptop.findBySerialCode");
		q.setParameter("code", code);
		List<Laptop> resultList = q.getResultList();
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Laptop> getLaptopsByManufacturer(String manufacturer) {
		Query q = em.createNamedQuery("laptop.findByManufacturer");
		q.setParameter("manufacturer", manufacturer);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Laptop> getLaptopsByOwner(String firstName) {
		Query q = em.createNamedQuery("laptop.findByOwnerFirstName");
		q.setParameter("first_name", firstName);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Person> getOwners(long id) {
		Query q = em.createNamedQuery("laptop.getOwners");
		q.setParameter("id", id);
		return q.getResultList();
	}

	public boolean addOwner(long laptopId, long personId) {
		Laptop laptop = getLaptop(laptopId);
		Person person = pm.getPerson(personId);
		if(laptop == null || person == null) {
			return false;
		}
		laptop.addOwner(person);
		em.persist(laptop);
		return true;
	}

	public boolean removeOwner(long laptopId, long personId) {
		Laptop laptop = getLaptop(laptopId);
		Person person = pm.getPerson(personId);
		if(laptop == null || person == null) {
			return false;
		}
		laptop.removeOwner(person);
		em.persist(laptop);
		return true;
	}


	@SuppressWarnings("unchecked")
	public void deleteAllLaptops(){
		em.createNamedQuery("laptop.delete.all").executeUpdate();
	}

}
