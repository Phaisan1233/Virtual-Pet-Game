/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Pet.Pet;
import java.util.HashMap;

/**
 *
 * @author Phaisan & Shannon
 */
public class UserList {

    private HashMap<String, Pet> userList;

    /**
     *This is the constructor to create new collection
     */
    public UserList() {
        this.userList = new HashMap<>();
    }

    /**
     *This method gets the list of users
     * @return user list
     */
    public HashMap<String, Pet> getUserList() {
        return userList;
    }

    /**
     *This method adds a new user to the user list
     * @param userName
     * @param animal
     */
    public void addUser(String userName, Pet animal) {
        this.userList.put(userName.toLowerCase(), animal);
    }

    /**
     *This method removes a user from the user list
     * @param userName
     */
    public void removeUser(String userName) {
        this.userList.remove(userName.toLowerCase());
    }

    /**
     *This will clear the user list (for later use)
     */
    public void clear() {
        this.userList.clear();
    }

    /**
     *checks if the user lists contains a previous users
     * @param userName
     * @return boolean
     */
    public boolean containsUser(String userName) {
        return this.userList.containsKey(userName.toLowerCase());
    }

    /**
     *This method gets a pet class from the user list
     * @param userName username
     * @return pet
     */
    public Pet getPet(String userName) {
        return this.userList.get(userName.toLowerCase());
    }
    
    /**
     * This method gets a model class from the user list
     *
     * @param userName username
     * @return model
     */
    public UserModel getUser(String userName){
        return new UserModel(userName,this.userList.get(userName.toLowerCase()));
    }

}
