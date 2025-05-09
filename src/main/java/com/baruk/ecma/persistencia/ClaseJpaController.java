package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Clase;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class ClaseJpaController {

    public ClaseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ClaseJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clase clase) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(clase);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Clase clase) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(clase);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Clase clase = em.getReference(Clase.class, id);
        em.remove(clase);
        em.getTransaction().commit();
        em.close();
    }

    public Clase findClase(Long id) {
        return getEntityManager().find(Clase.class, id);
    }

    public List<Clase> findClaseEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clase.class));
        return em.createQuery(cq).getResultList();
    }
}
