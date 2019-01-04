package ug.adamtrawinski.restejbjpa.service;

import ug.adamtrawinski.restejbjpa.domain.SerialCode;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SerialCodeManager {

    @PersistenceContext
    EntityManager em;

    public void addSerialCode(SerialCode serialCode) {
        em.persist(serialCode);
    }

    public SerialCode updateSerialCode(SerialCode serialCode, long id) {
        serialCode.setId(id);
        SerialCode old = getSerialCode(id);
        if(old != null) {
            em.merge(serialCode);
        }
        return old;
    }

    public void deleteSerialCode(long id) {
        SerialCode serialCode = getSerialCode(id);
        if(serialCode != null) {
            em.remove(serialCode);
        }
    }

    public SerialCode getSerialCode(long id) {
        return em.find(SerialCode.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<SerialCode> getAllSerialCodes() {
        return em.createNamedQuery("serialCode.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAllSerialCodes(){
        em.createNamedQuery("serialCode.delete.all").executeUpdate();
    }
}
