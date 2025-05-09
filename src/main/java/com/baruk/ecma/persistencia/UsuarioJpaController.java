package com.baruk.ecma.persistencia;

import com.baruk.ecma.logica.Usuario;
import com.baruk.ecma.persistencia.exceptions.NonexistentEntityException;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioJpaController {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ecmaPU");
    }
    
    
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Usuario usuario) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(int id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.getReference(Usuario.class, id);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario findUsuario(int id) {
        return getEntityManager().find(Usuario.class, id);
    }

    public List<Usuario> findUsuarioEntities() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        return em.createQuery(cq).getResultList();
    }
}
