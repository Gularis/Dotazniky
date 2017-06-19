/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.facade;

import cz.mendelu.pef.swi.api.dto.DotaznikCreateDTO;
import cz.mendelu.pef.swi.api.dto.DotaznikDTO;
import java.util.List;
/**
 *
 * @author Martin
 */
public interface DotaznikFacade {
    int createDotaznik(DotaznikCreateDTO t);
    
    List<DotaznikDTO> getAllDotaznik();
    
    public DotaznikDTO getDotaznikWithId(int id);
}
