/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface UzivatelService {
    void create(Uzivatel uzivatel);
    
     Uzivatel findById(int id);
     
     Uzivatel findByEmail(String email);

    List<Uzivatel> findAll();

    void delete(Uzivatel uzivatel);
    
  // void odpovedNaDotaznik(Dotaznik dotaznik, Odpoved odpoved);
    
    boolean isDotaznikOwner(Uzivatel u);
            
    Role getRoleForUzivatel(Uzivatel u, Dotaznik d);
    
    List<Odpoved> findUzivatelOdpovede(Uzivatel uzivatel);

}
