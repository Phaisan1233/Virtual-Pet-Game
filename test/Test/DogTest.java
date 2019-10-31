package Test;

import Pet.Animal;
import Pet.Cat;
import Pet.Dog;
import Pet.Pet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phaisan
 */
public class DogTest {

    private Pet dog;

    public DogTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Test : Dog class");

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dog = new Dog("dog");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPetStatsCheck() {
        System.out.println("find : testing pet stats check");
        assertFalse(dog.checkStats());
    }

    @Test
    public void testRandomCheck() {
        System.out.println("find : testing random method");
        int result = dog.getRandom(-3, 3);
        int expect = 0;
        assertEquals(expect, result, 3);
    }

    @Test
    public void testAddDayCount() {
        System.out.println("find : testing adding day coung");
        int expect = dog.getDayCount() + 1;
        dog.addDayCount();
        int result = dog.getDayCount();
        assertEquals(expect, result);

    }

    @Test
    public void testNewPet1() {
        System.out.println("find : testing adding day coung");
        int expect = dog.getEnergy();
        int result = 50;
        assertEquals(expect, result);
    }

    @Test
    public void testNewPet2() {
        System.out.println("find : testing adding day coung");
        int expect = dog.getExcitement();
        int result = 50;
        assertEquals(expect, result);
    }

    @Test
    public void testNewPet3() {
        System.out.println("find : testing adding day coung");
        int expect = dog.getFullness();
        int result = 50;
        assertEquals(expect, result);
    }

}
