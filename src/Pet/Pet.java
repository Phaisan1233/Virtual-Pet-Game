/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

/**
 * This is an interface to utilize its methods within the same package
 *
 * @author Phaisan & Shannon
 */
public interface Pet {

    /**
     * This method gets the name of pet
     *
     * @return name of pet
     */
    public String getName();

    /**
     * This method gets the hunger of the pet
     *
     * @return the hunger of pet
     */
    public int getFullness();

    /**
     * This method gets the energy of the pet
     *
     * @return
     */
    public int getEnergy();

    /**
     * This method gets the excitement of the pet
     *
     * @return
     */
    public int getExcitement();

    /**
     * This method allows the user to feed the pet
     */
    public void feed();

    /**
     * This method allows the user to walk the pet
     */
    public void walk();

    /**
     * This method allows the user to play with the pet
     */
    public void pet();

    /**
     * This method allows the user to let the pet sleep everyday and increase
     * the dayCount variable by 1
     */
    public void sleep();

    /**
     * This method allows the user to let the pet rest and recover
     *
     */
    public void rest();

    /**
     * This method counts the days of how many rounds the game has done
     *
     * @return dayCount
     */
    public int getDayCount();

    /**
     * This method increases the day per 3 actions from the user
     */
    public void addDayCount();

    /**
     * This method checks the 3 variables to determine if the game will end
     *
     * @return fullness, excitement, energy
     */
    public boolean checkStats();

    /**
     * Method to create random number
     *
     * @param x minimum
     * @param y maximum
     * @return random number
     */
    public int getRandom(int x, int y);

}
