/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import java.util.List;
/**
 *
 * @author michal.balko
 */
public interface DotaznikDao {
    
 /**
     * Find Dotaznik based on its id.
     *
     * @param id of the Dotaznik instance.
     */
    Dotaznik findById(int id);

    Dotaznik findByOwner(Uzivatel owner);
    
    /**
     * Creates or updates corresponding Dotaznik
     *
     * @param dotaznik instance of Dotaznik to create or update.
     */
    void save(Dotaznik dotaznik);

    /**
     * Deletes provided instance of Dotaznik.
     *
     * @param dotaznik instance of Trainer to delete.
     */
    void delete(Dotaznik dotaznik);

    /**
     * Find all instances of Dotaznik.
     *
     * @return List of Dotaznik instances.
     */
    List<Dotaznik> findAll();

    Dotaznik findByTitle(String Title);
        
    
}
