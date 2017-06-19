/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.dto;

import java.util.Set;

/**
 *
 * @author Martin
 */
public class DotaznikDTO {
    private int id;
    
    private String title;
    
    private String description;
    
    private String question;
    
    private Set<UzivatelDTO> respondents;
    
    private UzivatelDTO owner;
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestion() {
        return question;
    }
    
    public Set<UzivatelDTO> getRespondents() {
        return respondents;
    }
    
    public UzivatelDTO getOwner(){
        return owner;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setRespondents(Set<UzivatelDTO> respondents){
        this.respondents = respondents;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setOwner(UzivatelDTO owner){
        this.owner = owner;
    }
}
