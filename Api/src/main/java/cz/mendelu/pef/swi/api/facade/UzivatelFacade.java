/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.facade;

import cz.mendelu.pef.swi.api.dto.UzivatelCreateDTO;
import cz.mendelu.pef.swi.api.dto.UzivatelDTO;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface UzivatelFacade {
    int createUzivatel(UzivatelCreateDTO t);
    
    List<UzivatelDTO> getAllUzivatel();
    
    public UzivatelDTO getUzivatelWithId(int id);
}
