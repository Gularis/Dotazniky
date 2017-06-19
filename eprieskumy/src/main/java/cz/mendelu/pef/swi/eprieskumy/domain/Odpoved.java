/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Martin
 */

@Entity
public class Odpoved {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private int uzivatel_id;
    private int dotaznik_id;
    private String text;
    
    public int getId(){
        return id;
    }
    public int getUzivatelId(){
        return uzivatel_id;
    }
    
    public int getDotaznikId(){
        return dotaznik_id;
    }
    
    public String getText(){
        return text;
    }
    
    public void setUzivatelId(int uzivatel_id){
        this.uzivatel_id=uzivatel_id;
    }
    public void setDotaznikId(int dotaznik_id){
        this.dotaznik_id=dotaznik_id;
    }
    public void setText(String text){
        this.text=text;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public Odpoved(){
        
    }
    
    public Odpoved(Integer dotaznik_id,Integer uzivatel_id, String text){
        this.dotaznik_id=dotaznik_id;
        this.uzivatel_id=uzivatel_id;
        this.text=text;
    }
    
}
