/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

import java.util.Random;

/**
 * This class allows multiple objects to be created and use its methods. We used
 * cat and dog to extend this.
 *
 * @author Phaisan & Shannon
 */
public abstract class Animal implements Pet {

    protected int fullness; // pet's fullness point 
    protected int energy;// pet's energy point 
    protected int excitement;// pet's excitement point
    protected String name;// pet's name
    protected int dayCount = 1;// pet's day counting

    /**
     * The constructor to create new animal
     *
     * @param animalName name
     * @param fullness fullness point
     * @param energy energy point
     * @param excitement excitement point
     * @param dayCount day counting
     */
    public Animal(String animalName, int fullness, int energy, int excitement, int dayCount) {
        setName(animalName);
        setFullness(fullness);
        setEnergy(energy);
        setExcitement(excitement);
        setDayCount(dayCount);
    }

    /**
     * The constructor create new animal with name
     *
     * @param animalName name
     */
    public Animal(String animalName) {
        setName(animalName);
        setFullness(50);
        setEnergy(50);
        setExcitement(50);
        setDayCount(1);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name
     *
     * @param name pet name
     */
    public void setName(String name) {
        if (name == null || name.equals("")) {
            this.name = "";
        } else {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
    }

    @Override
    public int getFullness() {
        return fullness;
    }

    /**
     * set fullness point
     *
     * @param fullness fullness point
     */
    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    /**
     * Set energy point
     *
     * @param energy energy point
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int getExcitement() {
        return excitement;
    }

    /**
     * Set excitement point
     *
     * @param excitement excitement point
     */
    public void setExcitement(int excitement) {
        this.excitement = excitement;
    }

    @Override
    public int getDayCount() {
        return dayCount;
    }

    /**
     * Set day count
     *
     * @param dayCount day counting
     */
    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    @Override
    public void addDayCount() {
        this.dayCount++;
    }

    @Override
    public int getRandom(int x, int y) {
        return new Random().nextInt(y - x) + x;
    }

    @Override
    public boolean checkStats() {
        return (this.excitement < 15 || this.energy < 25 || this.fullness < 20);

    }

    @Override
    public String toString() {
        return "\n  " + this.name + "'s status:\n" + "    Fullness : " + this.fullness + " \n    Energy : " + this.energy + "\n    Excitement : " + this.excitement;
    }

}
