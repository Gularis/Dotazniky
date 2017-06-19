/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.eprieskumy.utils.DaoLayerException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author michal.balko
 */
@Repository
public class UzivatelDaoImpl implements UzivatelDao{
 
    @PersistenceContext
    private EntityManager entityManager;
   
    
    @Override
    public Uzivatel findById(int id) {
        try {
            return entityManager.find(Uzivatel.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public void save(Uzivatel uzivatel) {
            if (findById(uzivatel.getId()) != null) {
            try {
                entityManager.merge(uzivatel);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(uzivatel);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }

    }

    @Override
    public void delete(Uzivatel uzivatel) {
        try {
            entityManager.remove(findById(uzivatel.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public List<Uzivatel> findAll() {
            
        try {
            return entityManager.createQuery("select d from Uzivatel d", Uzivatel.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public Uzivatel findByEmail(String email) {

         try {
            return entityManager.createQuery("select u from Uzivatel u where u.email = ?1", Uzivatel.class).setParameter(1, email).getSingleResult();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    
}
