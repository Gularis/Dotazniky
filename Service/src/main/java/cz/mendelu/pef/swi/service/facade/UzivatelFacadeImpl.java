/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.facade;

import cz.mendelu.pef.swi.api.dto.UzivatelCreateDTO;
import cz.mendelu.pef.swi.api.dto.UzivatelDTO;
import cz.mendelu.pef.swi.api.facade.UzivatelFacade;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;
import cz.mendelu.pef.swi.service.services.BeanMappingService;
import cz.mendelu.pef.swi.service.services.UzivatelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Martin
 */
public class UzivatelFacadeImpl implements UzivatelFacade {
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private UzivatelService uzivatelService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public int createUzivatel(UzivatelCreateDTO t) {
        Uzivatel newUzivatel= new Uzivatel(t.getFirstName(),t.getLastName(),t.getEmail(),t.getAge());
        uzivatelService.create(newUzivatel);
        return newUzivatel.getId();
    }

    @Override
    public List<UzivatelDTO> getAllUzivatel() {
         return beanMappingService.mapTo(uzivatelService.findAll(), UzivatelDTO.class);
    }

    @Override
    public UzivatelDTO getUzivatelWithId(int id) {
         return beanMappingService.mapTo(uzivatelService.findById(id), UzivatelDTO.class);
    }
    
}
