/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

import Pet.Animal;

/**
 * This class is an Animal class that contains a Cat object with its own
 * attributes
 *
 * @author Phaisan & Shannon
 */
public class Cat extends Animal implements Pet {

    /**
     * This is the Cat constructor
     *
     * @param catName
     * @param fullness
     * @param energy
     * @param excitement
     * @param dayCount
     */
    public Cat(String catName, int fullness, int energy, int excitement, int dayCount) {
        super(catName, fullness, energy, excitement, dayCount);
    }

    /**
     * This is the default constructor
     *
     * @param name
     */
    public Cat(String name) {
        super(name);
    }

    @Override
    public void feed() {
        this.fullness = this.fullness + 10 + getRandom(-2, 2);
        this.energy = this.energy + 3 + getRandom(-2, 2);
        this.excitement = this.excitement - 7 + getRandom(-2, 2);
    }

    @Override
    public void walk() {
        this.fullness = this.fullness - 3 + getRandom(-2, 2);
        this.energy = this.energy - 3 + getRandom(-2, 2);
        this.excitement = this.excitement - 3 + getRandom(-2, 2);

    }

    @Override
    public void rest() {
        this.fullness = this.fullness - 1 + getRandom(-2, 2);
        this.energy = this.energy + 6 + getRandom(-2, 2);
        this.excitement = this.excitement - 3 + getRandom(-2, 2);
    }

    @Override
    public void pet() {
        this.fullness = this.fullness - 2 + getRandom(0, 2);
        this.energy = this.energy - 2 + getRandom(0, 2);
        this.excitement = this.excitement + 15 + getRandom(-2, 2);
    }

    @Override
    public void sleep() {
        this.fullness = this.fullness - 5 + getRandom(-2, 2);
        this.energy = this.energy + 12 + getRandom(-2, 2);
        this.excitement = this.excitement - 2 + getRandom(-2, 2);
    }

}
