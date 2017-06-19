/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.dao.OdpovedDao;
import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.eprieskumy.utils.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.testng.annotations.Test;
/**
 *
 * @author Martin
 */

@ContextConfiguration(classes = DatabaseConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional

public class OdpovedDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private OdpovedDao odpovedDao;
    
    @Test
    public void testSave(){
        Uzivatel uzivatel = new Uzivatel("person","first","person1789@gmail.com","123","20",Role.ROLE_OWNER);
        Dotaznik dotaznik = new Dotaznik("Mega dotaznik", "vyplnte mega dotaznik","Co je toto?",uzivatel.getId());
        Odpoved odpoved = new Odpoved(dotaznik.getId(),uzivatel.getId(),"Jablko");
        
        odpovedDao.save(odpoved);
        System.out.println("testSave: " + odpovedDao.findAll()  );
        
    }
    
    @Test
    public void testFindById(){
        Uzivatel uzivatel = new Uzivatel("person","first","person1789@gmail.com","123","20",Role.ROLE_RESPONDENT);
        Dotaznik dotaznik = new Dotaznik("Mega dotaznik", "vyplnte mega dotaznik","Co je toto?",uzivatel.getId());
        Odpoved odpoved = new Odpoved(dotaznik.getId(),uzivatel.getId(),"Jablko");
        
        odpovedDao.save(odpoved);
        odpovedDao.findById(odpoved.getId()); 
        
        System.out.println("testFindById, Odpoved: "+ odpovedDao.findById(odpoved.getId()) );
        assertEquals(odpoved, odpovedDao.findById(odpoved.getId()));
    }
    
    
    @Test
    public void testFindByUzivatelDotaznik(){
        Uzivatel uzivatel = new Uzivatel("person","first","person1789@gmail.com","123","20",Role.ROLE_OWNER);
        Dotaznik dotaznik = new Dotaznik("Mega dotaznik", "vyplnte mega dotaznik","Co je toto?",uzivatel.getId());
        Odpoved odpoved = new Odpoved(dotaznik.getId(),uzivatel.getId(),"Jablko");
        
        odpovedDao.save(odpoved);
        odpovedDao.findByUzivatelDotaznik(uzivatel.getId(), dotaznik.getId());
         
        System.out.println("testFindByUzivatelDotaznik, Odpoved: "+ odpovedDao.findByUzivatelDotaznik(uzivatel.getId(), dotaznik.getId()) );
        assertEquals(odpoved, odpovedDao.findByUzivatelDotaznik(uzivatel.getId(), dotaznik.getId()));
    }
}
