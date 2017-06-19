/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetailsService;
        
/**
 *
 * @author Martin
 */
public interface DotaznikService extends UserDetailsService{
    void create(Dotaznik dotaznik);
    
     Dotaznik findById(int id);
     
     Dotaznik findByTitle(String title);

    List<Dotaznik> findAll();

    void delete(Dotaznik dotaznik);

   // void update(Dotaznik dotaznik, String title,String description);
    
    void addAnswer(Dotaznik d, Odpoved o);
    
    List<Odpoved> findDotaznikOdpovede(Dotaznik d);
            
    List<Uzivatel> findDotaznikRespondents(Dotaznik d);
    
    Uzivatel findDotaznikOwner(Dotaznik dotaznik);
    
    Role getRoleForDotaznik(Dotaznik dotaznik);
    
    boolean isAdminUser(Dotaznik dotaznik);
    


}
