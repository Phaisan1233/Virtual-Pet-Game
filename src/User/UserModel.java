/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Pet.Pet;


/**
 * This class use as model of MVC
 *
 * @author phaisan
 */
public class UserModel{
    private String name; // user name
    private Pet pet; // pet object 

    /**
     * The constructor create a model
     *
     * @param name
     * @param pet
     */
    public UserModel(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    // Normal set and get method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    //-------------------------------------
    
    
    
    
    
}
