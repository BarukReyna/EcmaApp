package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.AsistenciaProfesor;
import com.baruk.ecma.logica.AsistenciaProfesorId;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class AsistenciaProfesorJpaController {

    public AsistenciaProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AsistenciaProfesorJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    

    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsistenciaProfesor asistencia) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(AsistenciaProfesor asistencia) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(AsistenciaProfesorId id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        AsistenciaProfesor asistencia = em.getReference(AsistenciaProfesor.class, id);
        em.remove(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public AsistenciaProfesor findAsistenciaProfesor(AsistenciaProfesorId id) {
        return getEntityManager().find(AsistenciaProfesor.class, id);
    }

    public List<AsistenciaProfesor> findAsistenciaProfesorEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AsistenciaProfesor.class));
        return em.createQuery(cq).getResultList();
    }
}
