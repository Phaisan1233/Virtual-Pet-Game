/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

import Pet.Animal;

/**
 * This class is an Animal class that contains a Dog object with its own
 * attributes
 *
 * @author Phaisan & Shannon
 */
public class Dog extends Animal implements Pet {

    /**
     * This is the constructor for the Dog class
     *
     * @param dogName
     * @param fullness
     * @param energy
     * @param excitement
     * @param dayCount
     */
    public Dog(String dogName, int fullness, int energy, int excitement, int dayCount) {
        super(dogName, fullness, energy, excitement, dayCount);
    }

    /**
     * This is the default constructor
     *
     * @param dogName
     */
    public Dog(String dogName) {
        super(dogName);
    }

    @Override
    public void feed() {
        this.fullness = this.fullness + 15 + getRandom(-4, 4);
        this.energy = this.energy + 5 + getRandom(-4, 4);
        this.excitement = this.excitement - 7 + getRandom(-4, 4);
    }

    @Override
    public void walk() {
        this.fullness = this.fullness - 7 + getRandom(-4, 4);
        this.energy = this.energy - 18 + getRandom(-4, 4);
        this.excitement = this.excitement + 15 + getRandom(-4, 4);

    }

    @Override
    public void rest() {
        this.fullness = this.fullness - 5 + getRandom(-2, 2);
        this.energy = this.energy + 7 + getRandom(-2, 2);
        this.excitement = this.excitement - 7 + getRandom(-2, 2);
    }

    @Override
    public void pet() {
        this.fullness = this.fullness - 7 + getRandom(-2, 2);
        this.energy = this.energy - 10 + getRandom(-4, 4);
        this.excitement = this.excitement + 10 + getRandom(-2, 2);
    }

    @Override
    public void sleep() {
        this.fullness = this.fullness - 10 + getRandom(-4, 4);
        this.energy = this.energy + 12 + getRandom(-7, 7);
        this.excitement = this.excitement - 7 + getRandom(-4, 4);
    }

}
