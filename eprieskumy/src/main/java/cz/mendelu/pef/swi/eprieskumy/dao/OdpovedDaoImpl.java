/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martin
 */
@Repository
public class OdpovedDaoImpl implements OdpovedDao{

    @PersistenceContext
    private EntityManager entityManager;
       
    @Override
    public Odpoved findById(int id) {
         try {
            return entityManager.find(Odpoved.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public void save(Odpoved odpoved) {
                    if (findById(odpoved.getId()) != null) {
            try {
                entityManager.merge(odpoved);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(odpoved);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Odpoved odpoved) {
           try {
            entityManager.remove(findById(odpoved.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public List<Odpoved> findAll() {
      try {
            return entityManager.createQuery("select d from Odpoved d", Odpoved.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public Odpoved findByText(String text) {
        
         try {
            return entityManager.createQuery("select d from Odpoved d where d.title = ?1", Odpoved.class).setParameter(1, text).getSingleResult();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    

    //niak nastavit treba select d from Odpoved d where d.uzivatel_id = ?1 AND d.dotaznik_id =?2
    @Override
    public Odpoved findByUzivatelDotaznik(int uzivatel_id, int dotaznik_id) {
                 try {
            return entityManager.createQuery("select d from Odpoved d where d.uzivatel_id = ?1 and d.dotaznik_id = ?2", Odpoved.class)
                    .setParameter(1, uzivatel_id)
                    .setParameter(2, dotaznik_id)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    
}
