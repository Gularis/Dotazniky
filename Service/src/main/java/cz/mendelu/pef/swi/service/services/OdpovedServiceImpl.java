/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.dao.OdpovedDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martin
 */
@Service
public class OdpovedServiceImpl implements OdpovedService{
    
    @Autowired
    private OdpovedDao odpovedDao;
    
    @Override
    public void create(Odpoved odpoved) {
        odpovedDao.save(odpoved);
    }

    @Override
    public Odpoved findById(int id) {
        return odpovedDao.findById(id);
    }

    @Override
    public List<Odpoved> findAll() {
        return odpovedDao.findAll();
    }

    @Override
    public void delete(Odpoved odpoved) {
        odpovedDao.delete(odpoved);
    }
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Odpoved findByUtivatelDoataznik(int uzivatel_id,int dotaznik_id) {
        return odpovedDao.findByUzivatelDotaznik(uzivatel_id, dotaznik_id);
    }
    
}
