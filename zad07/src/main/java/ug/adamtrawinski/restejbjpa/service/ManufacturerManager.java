package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Manufacturer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class ManufacturerManager {

    @PersistenceContext
    EntityManager em;

    public void addManufacturer(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer, long id) {
        manufacturer.setId(id);
        Manufacturer old = getManufacturer(id);
        if(old != null) {
            em.merge(manufacturer);
        }
        return old;
    }

    public void deleteManufacturer(long id) {
        Manufacturer manufacturer = getManufacturer(id);
        if(manufacturer != null) {
            em.remove(manufacturer);
        }
    }

    public Manufacturer getManufacturer(long id) {
        return em.find(Manufacturer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Manufacturer> getAllManufacturers() {
        return em.createNamedQuery("manufacturer.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAllManufacturers(){
        em.createNamedQuery("manufacturer.delete.all").executeUpdate();
    }
}
