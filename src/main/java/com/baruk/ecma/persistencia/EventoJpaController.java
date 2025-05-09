package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Evento;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class EventoJpaController {

    public EventoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EventoJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Evento evento) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Evento evento) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Evento evento = em.getReference(Evento.class, id);
        em.remove(evento);
        em.getTransaction().commit();
        em.close();
    }

    public Evento findEvento(Long id) {
        return getEntityManager().find(Evento.class, id);
    }

    public List<Evento> findEventoEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Evento.class));
        return em.createQuery(cq).getResultList();
    }
}
