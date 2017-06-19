/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import java.util.List;
/**
 *
 * @author michal.balko
 */
public interface UzivatelDao {
    
    Uzivatel findById(int id);

    void save(Uzivatel uzivatel);

    void delete(Uzivatel uzivatel);

    List<Uzivatel> findAll();

    Uzivatel findByEmail(String email);
    
}
