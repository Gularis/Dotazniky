/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.domain;

import static cz.mendelu.pef.swi.eprieskumy.domain.Role.ROLE_OWNER;
import static cz.mendelu.pef.swi.eprieskumy.domain.Role.ROLE_RESPONDENT;
import java.lang.reflect.Array;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 *
 * @author michal.balko
 */

@Entity
public class Dotaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Uzivatel> respondents = new HashSet();
    
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private int owner;
    
    private Set<Odpoved> answers;
    
    public int getId() {
        return id;
    }
    
    public Set<Odpoved> getAnswers()
    {
        return answers;
    }
    public void setAnswer(Odpoved odpoved)
    {
        this.answers.add(odpoved);
    }

    public void setAnswer(Set<Odpoved> odpovede)
    {
        this.answers.addAll(odpovede);
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
    
    public Set<Uzivatel> getRespondents() {
        return Collections.unmodifiableSet(respondents);
    }
    
    public int getOwner(){
        return owner;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestion(String q) {
        this.title = q;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRespondents(Uzivatel respondent) {
        if (respondent != null) {
            respondent.setRole(ROLE_RESPONDENT);
            this.respondents.add(respondent);
        }
    }
    
    public void setRespondents(Collection<Uzivatel> respondents) {
        if (respondents != null) {
            for (Uzivatel r : respondents){
                r.setRole(ROLE_RESPONDENT);
            }
            this.respondents.addAll(respondents);
        }
    }

    public void setOwnerId(int owner){
        this.owner = owner;
    }
    

    public Dotaznik() {
    }
    
    public Dotaznik( String title, String description, String question, int owner) { /*,Set<Uzivatel> respondents*/
        this.title = title;
        this.description = description;
        this.question = question;
        this.owner = owner;
        this.answers = null;
        //owner.setRole(ROLE_OWNER);
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dotaznik other = (Dotaznik) obj;
        return Objects.equals(this.description, other.description);
    }
 
   
}
