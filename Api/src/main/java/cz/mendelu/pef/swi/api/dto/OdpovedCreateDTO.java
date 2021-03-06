/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Martin
 */
public class OdpovedCreateDTO {
    @NotNull
    @Size(min = 2, max = 50)
    private String text;
    
    @NotNull
    private int uzivatel_id;
    
    @NotNull
    private int dotaznik_id;
    
    private String getText() {
        return text;
    }
    
    public void setText(String text){
        this.text=text;
    }
 
        private int getUzivatelId(){
        return uzivatel_id;
    }
    
    private void setUzivatelId(int uzivatel_id){
        this.uzivatel_id=uzivatel_id;
    }
    
    private int getDotaznikId(){
        return dotaznik_id;
    }
    
    private void setDotaznikId(int dotaznik_id){
        this.dotaznik_id=dotaznik_id;
    }
}
