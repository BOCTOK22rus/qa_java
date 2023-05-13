package com.example;

import org.junit.Test;

import static com.constants.TestData.EXPECTED_CAT_SOUND;
import static com.constants.TestData.EXPECTED_FOOD_FELINE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void getSound() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertThat("Кошка издаёт другой звук",
                cat.getSound(), is(EXPECTED_CAT_SOUND));
    }

    @Test
    public void getFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals("Кошка питается иначе",
                cat.getFood(), EXPECTED_FOOD_FELINE);
    }
}