package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Alumno;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class AlumnoJpaController {

    public AlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AlumnoJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumno alumno) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Alumno alumno) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Alumno alumno = em.getReference(Alumno.class, id);
        em.remove(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public Alumno findAlumno(Long id) {
        return getEntityManager().find(Alumno.class, id);
    }

    public List<Alumno> findAlumnoEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Alumno.class));
        return em.createQuery(cq).getResultList();
    }
}
