/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.dao.UzivatelDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martin
 */

@Service
public class DotaznikServiceImpl implements DotaznikService{
    
    @Autowired
    private DotaznikDao dotaznikDao;
    
    @Autowired
    private UzivatelDao uzivatelDao;
    
    @Autowired
    private OdpovedService odpovedService;
    
    @Override
    public void create(Dotaznik dotaznik) {
        dotaznikDao.save(dotaznik);
    }

    @Override
    public Dotaznik findById(int id) {
       return dotaznikDao.findById(id);
    }

    @Override
    public List<Dotaznik> findAll() {
        return dotaznikDao.findAll();
    }

    @Override
    public void delete(Dotaznik dotaznik) {
        dotaznikDao.delete(dotaznik);
    }

    @Override
    public Dotaznik findByTitle(String Title){
        return dotaznikDao.findByTitle(Title);
        
    }
    
    @Override
    public void addAnswer(Dotaznik d, Odpoved o){
        Dotaznik dot = dotaznikDao.findById(d.getId());
       // dot.setAnswer(o);
        //dotaznikDao.save(dot);
    }
    
    
    @Override
    public List<Odpoved> findDotaznikOdpovede(Dotaznik d){
        List<Odpoved> odpovede = odpovedService.findAll();
        List<Odpoved> result = new ArrayList<>();
        for(Odpoved o : odpovede){
            if(o.getDotaznikId() == d.getId())
                result.add(o);
        }
        return result;
    }
    
    @Override
    public List<Uzivatel> findDotaznikRespondents(Dotaznik d){
        List<Odpoved> odpovede = odpovedService.findAll();
   //     UzivatelService u;
        List<Uzivatel> result = new ArrayList<>();
        for(Odpoved o : odpovede){
            if(o.getDotaznikId() == d.getId())
                result.add(uzivatelDao.findById(o.getUzivatelId()));
        }
        return result;
    }
    
    @Override 
    public Uzivatel findDotaznikOwner(Dotaznik dotaznik){
        return uzivatelDao.findById(dotaznik.getOwner());
    }
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Dotaznik dotaznik = dotaznikDao.findByTitle(s);

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(getRoleForDotaznik(dotaznik).toString()));

        return buildUserForAuthentication(dotaznik, auths);
    }
    
    @Override
    public Role getRoleForDotaznik(Dotaznik dotaznik) {
        if (isAdminUser(dotaznik)) return Role.ROLE_OWNER;
        return Role.ROLE_RESPONDENT;
    }

    @Override
    public boolean isAdminUser(Dotaznik dotaznik) {
        return false;
    }
   
    private UserDetails buildUserForAuthentication(Dotaznik dotaznik, List<GrantedAuthority> auths) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
