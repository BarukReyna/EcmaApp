package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Disciplina;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class DisciplinaJpaController {

    public DisciplinaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public DisciplinaJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    

    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Disciplina disciplina) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(disciplina);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Disciplina disciplina) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(disciplina);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Disciplina disciplina = em.getReference(Disciplina.class, id);
        em.remove(disciplina);
        em.getTransaction().commit();
        em.close();
    }

    public Disciplina findDisciplina(Long id) {
        return getEntityManager().find(Disciplina.class, id);
    }

    public List<Disciplina> findDisciplinaEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Disciplina.class));
        return em.createQuery(cq).getResultList();
    }
}
