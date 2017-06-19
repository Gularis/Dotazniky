/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Martin
 */
public interface OdpovedService extends UserDetailsService{
    void create(Odpoved odpoved);
    
    Odpoved findById(int id);
     
    Odpoved findByUtivatelDoataznik(int uzivatel_id, int dotaznik_id);

    List<Odpoved> findAll();

    void delete(Odpoved odpoved);

    
    // void update(Dotaznik dotaznik, String title,String description);
    
}
