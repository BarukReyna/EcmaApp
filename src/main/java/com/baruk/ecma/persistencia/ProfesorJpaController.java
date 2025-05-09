package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Profesor;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class ProfesorJpaController {

    public ProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProfesorJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesor profesor) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(profesor);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Profesor profesor) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(profesor);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Profesor profesor = em.getReference(Profesor.class, id);
        em.remove(profesor);
        em.getTransaction().commit();
        em.close();
    }

    public Profesor findProfesor(Long id) {
        return getEntityManager().find(Profesor.class, id);
    }

    public List<Profesor> findProfesorEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Profesor.class));
        return em.createQuery(cq).getResultList();
    }
}
