package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.AsistenciaAlumno;
import com.baruk.ecma.logica.AsistenciaAlumnoId;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class AsistenciaAlumnoJpaController {

    public AsistenciaAlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AsistenciaAlumnoJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsistenciaAlumno asistencia) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(AsistenciaAlumno asistencia) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(AsistenciaAlumnoId id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        AsistenciaAlumno asistencia = em.getReference(AsistenciaAlumno.class, id);
        em.remove(asistencia);
        em.getTransaction().commit();
        em.close();
    }

    public AsistenciaAlumno findAsistenciaAlumno(AsistenciaAlumnoId id) {
        return getEntityManager().find(AsistenciaAlumno.class, id);
    }

    public List<AsistenciaAlumno> findAsistenciaAlumnoEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AsistenciaAlumno.class));
        return em.createQuery(cq).getResultList();
    }
}
