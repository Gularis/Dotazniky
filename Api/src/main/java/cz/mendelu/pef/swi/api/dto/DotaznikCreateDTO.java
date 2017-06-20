/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.dto;

import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import cz.mendelu.pef.swi.eprieskumy.domain.Uzivatel;

import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author Martin
 */
public class DotaznikCreateDTO {
    @NotNull
    @Size(min = 5, max = 50)
    private String title;
    
    @NotNull
    private String description;
    
    @NotNull
    private String question;
    
    @NotNull
    private Uzivatel owner;
    
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public Uzivatel getOwner(){
        return owner;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    
    public void setOwner(Uzivatel owner){
        this.owner = owner;
    }
   
}
