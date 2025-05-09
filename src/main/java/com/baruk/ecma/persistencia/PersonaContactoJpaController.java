package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.PersonaContacto;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class PersonaContactoJpaController {

    public PersonaContactoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersonaContactoJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonaContacto personaContacto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(personaContacto);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(PersonaContacto personaContacto) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(personaContacto);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        PersonaContacto pc = em.getReference(PersonaContacto.class, id);
        em.remove(pc);
        em.getTransaction().commit();
        em.close();
    }

    public PersonaContacto findPersonaContacto(Long id) {
        return getEntityManager().find(PersonaContacto.class, id);
    }

    public List<PersonaContacto> findPersonaContactoEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(PersonaContacto.class));
        return em.createQuery(cq).getResultList();
    }
}
