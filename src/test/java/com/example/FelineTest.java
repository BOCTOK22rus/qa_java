package com.example;

import org.junit.Test;

import static com.constants.TestData.EXPECTED_FELINE_FAMILY;
import static com.constants.TestData.EXPECTED_FOOD_FELINE;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final int expectedKittensCount = 1;

    @Test
    public void getFood() throws Exception {
        Feline feline = new Feline();
        assertEquals("Кошачьи питаются по-другому",
                feline.getFood("Хищник"), EXPECTED_FOOD_FELINE);
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        assertEquals("Семейство не соответствует",
                feline.getFamily(), EXPECTED_FELINE_FAMILY);
    }

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals("Хищники питаются по-другому",
                feline.eatMeat(), EXPECTED_FOOD_FELINE);
    }

    @Test
    public void getKittensKittensCount() {
        Feline feline = new Feline();
        assertEquals("Количество не соответствует",
                feline.getKittens(1), expectedKittensCount);
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        assertEquals("Количество не соответствует",
                feline.getKittens(), expectedKittensCount);
    }
}