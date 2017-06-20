/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.dao.UzivatelDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.eprieskumy.dao.OdpovedDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.service.exceptions.ServiceException ;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Martin
 */
public class UzivatelServiceImpl implements UzivatelService {

    @Autowired
    private UzivatelDao uzivatelDao;
    
    @Autowired
    private OdpovedService odpovedService;
    
    @Autowired
    private DotaznikService dotaznikService;
    
    @Override
    public void create(Uzivatel uzivatel) {
        uzivatelDao.save(uzivatel);
    }

    @Override
    public Uzivatel findById(int id) {
        return uzivatelDao.findById(id);
        
    }

    @Override
    public Uzivatel findByEmail(String email) {
        return uzivatelDao.findByEmail(email);
    }

    @Override
    public List<Uzivatel> findAll() {
       return uzivatelDao.findAll();
    }

    @Override
    public void delete(Uzivatel uzivatel) {
      uzivatelDao.delete(uzivatel);
    }

    @Override
    public boolean isDotaznikOwner(Uzivatel u){
        for (Dotaznik d : dotaznikService.findAll()){
            if (u.getId() == d.getOwner()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void odpovedNaDotaznik(Dotaznik dotaznik, Odpoved odpoved){
        dotaznikService.addAnswer(dotaznik, odpoved);
    }
    
    
    @Override
    public Role getRoleForUzivatel(Uzivatel u, Dotaznik d){
        if (d.getOwner() == u.getId()){
            return Role.ROLE_OWNER;
        }
        return Role.ROLE_RESPONDENT;
    }
    
    
    @Override
    public List<Odpoved> findUzivatelOdpovede(Uzivatel uzivatel){
        if (uzivatel == null){
            throw new ServiceException("Nemožno nájsť odpovede pre null uzivatela");
        }
        
        List<Odpoved> odpovede = odpovedService.findAll();
        List<Odpoved> result = new ArrayList<>();
        for (Odpoved o : odpovede){
            if (o.getUzivatelId() == uzivatel.getId()){
                result.add(o);
            }
        }
        return result;
    }

    
}
