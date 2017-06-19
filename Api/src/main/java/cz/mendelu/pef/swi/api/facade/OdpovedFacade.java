/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.facade;

import cz.mendelu.pef.swi.api.dto.OdpovedCreateDTO;
import cz.mendelu.pef.swi.api.dto.OdpovedDTO;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface OdpovedFacade {
    int createOdpoved(OdpovedCreateDTO t);
    
    List<OdpovedDTO> getAllOdpoved();
    
    public OdpovedDTO getOdpovedWithId(int id);
}
