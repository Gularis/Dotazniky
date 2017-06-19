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
public class UzivatelCreateDTO {
    
    
    @NotNull
    private String firstName;
 
    @NotNull
    private String lastName;
    
    @NotNull
    private String email;
    
    @NotNull
    private String password;
    
    private String age;
    
    private Role role;

 
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
    public void setPassowrd(String pass)
    {
        this.password = pass;
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

    public void setRole(Role role) {
        this.role = role;
    }
    
}
