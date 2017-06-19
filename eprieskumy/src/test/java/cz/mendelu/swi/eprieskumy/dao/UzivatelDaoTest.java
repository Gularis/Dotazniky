/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.dao.UzivatelDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.eprieskumy.utils.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Martin
 */

@ContextConfiguration(classes = DatabaseConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UzivatelDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UzivatelDao uzivatelDao;
    
    @Test
    public void testSave(){
        Uzivatel uzivatel = new Uzivatel("person","number1","person1@gmail.com","123","20",Role.ROLE_OWNER);
        uzivatelDao.save(uzivatel);
    }
    
    @Test
    public void testSetRole(){
        Uzivatel uzivatel = new Uzivatel("person","number1","person1@gmail.com","123","20",Role.ROLE_OWNER);
        uzivatelDao.save(uzivatel);
        uzivatel.setRole(Role.ROLE_RESPONDENT);
        assertEquals(uzivatel.getRole(),Role.ROLE_RESPONDENT);
    }   
    
    
}
