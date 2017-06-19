/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.domain;

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
public class Uzivatel {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private String firstName;
 
    private String lastName;
    
    private String email;
    
    @NotNull
    @Column(nullable = false)
    private String password;
    
    private String age;
        
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Dotaznik> owenersDotazniky;
    
       
    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String pass)
    {
       this.password = pass;
    }
    
    public Set<Dotaznik> getOwnersDotazniky()
    {
        return Collections.unmodifiableSet(owenersDotazniky);
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void setUzivatelsDotazniky(Dotaznik dotaznik)
    {
        if(dotaznik != null) {
            this.owenersDotazniky.add(dotaznik);
        }
    }
       
    
    
    public void setUzivatelsDotazniky(Set<Dotaznik> dotazniky)
    {
        if(dotazniky != null) {
            this.owenersDotazniky.addAll(dotazniky);
        }         
    }

    public Uzivatel() {
    }

    public Uzivatel(String firstName, String lastName, String email, String password, String age, Role role) {
      
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
        this.role=role;
    }
    
        public Uzivatel(String firstName, String lastName, String email, String age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uzivatel)) return false;

        Uzivatel uzivatel = (Uzivatel) o;

        if (!getEmail().equals(uzivatel.getEmail())) return false;
        if (!getFirstName().equals(uzivatel.getFirstName())) return false;
        if (!getLastName().equals(uzivatel.getLastName())) return false;
        return getAge().equals(uzivatel.getAge());

    }

    @Override
    public int hashCode() {
        int result = getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
   
}
