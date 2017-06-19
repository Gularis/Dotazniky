/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
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
public class DotaznikDaoImpl implements DotaznikDao{
    
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Dotaznik findById(int id) {

        try {
            return entityManager.find(Dotaznik.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    public Dotaznik findByOwner(Uzivatel owner){
        try {
               return entityManager.createQuery("select d from Dotaznik d where d.owner_id = ?1", Dotaznik.class).setParameter(1, owner.getId()).getSingleResult();
           } catch (Exception e) {
               throw new DaoLayerException(e.getMessage());
           }
    }

    @Override
    public void save(Dotaznik dotaznik) {
            if (findById(dotaznik.getId()) != null) {
            try {
                entityManager.merge(dotaznik);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(dotaznik);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }

    }

    @Override
    public void delete(Dotaznik dotaznik) {
        try {
            entityManager.remove(findById(dotaznik.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public List<Dotaznik> findAll() {
            
        try {
            return entityManager.createQuery("select d from Dotaznik d", Dotaznik.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public Dotaznik findByTitle(String title) {

         try {
            return entityManager.createQuery("select d from Dotaznik d where d.title = ?1", Dotaznik.class).setParameter(1, title).getSingleResult();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        
}

