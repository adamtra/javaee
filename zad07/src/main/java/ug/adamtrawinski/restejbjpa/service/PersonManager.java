package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.Laptop;
import ug.adamtrawinski.restejbjpa.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonManager {

    @PersistenceContext
    EntityManager em;

    public void addPerson(Person person) {
        em.persist(person);
    }

    public Person updatePerson(Person person, long id) {
        person.setId(id);
        Person old = getPerson(id);
        if(old != null) {
            em.merge(person);
        }
        return old;
    }

    public void deletePerson(long id) {
        Person person = getPerson(id);
        if(person != null) {
            em.remove(person);
        }
    }

    @SuppressWarnings("unchecked")
    public Person getPerson(long id) {
        Query q = em.createNamedQuery("person.findById");
        q.setParameter("id", id);
        List<Person> resultList = q.getResultList();
        if(!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Laptop> getLaptops(long id) {
        Query q = em.createNamedQuery("person.getLaptops");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        return em.createNamedQuery("person.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAllPersons(){
        em.createNamedQuery("person.delete.all").executeUpdate();
    }
}
