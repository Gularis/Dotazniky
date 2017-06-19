/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.dto;

import javax.management.relation.Role;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Michal
 */
public class UzivatelDTO {
    
    private int id;
    
    @NotNull
    private String firstName;
 
    @NotNull
    private String lastName;
    
    @NotNull
    private String email;
    
    @NotNull
    private String password;
        
    private String age;
    
    @NotNull
    private Role role;

   
       
    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

   public String getPassword()
    {
        return password;
    }
   
    public void setPassowrd(String pass)
    {
        this.password = pass;
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
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UzivatelDTO)) {
            return false;
        }
        final UzivatelDTO other = (UzivatelDTO) obj;
        if (!this.email.equals(other.email)) {
            return false;
        }
        if (!this.email.equals(other.email)) {
            return false;
        }
        return true;
    }
}

