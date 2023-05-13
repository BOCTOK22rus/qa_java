package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.constants.TestData.EXPECTED_FOOD_FELINE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class LionTest {

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedMane;

    @Parameterized.Parameter(2)
    public int expectedKittens;

    @Parameterized.Parameters
    public static List<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {"Самец", true, 1},
                {"Самка", false, 1}
        });
    }

    @Test
    public void doesHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertThat("Пол не соответствует",
                lion.doesHaveMane(), is(expectedMane));
    }

    @Test
    public void getKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertThat("Количество не соответствует",
                lion.getKittens(), is(expectedKittens));
    }

    @Test
    public void getFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertThat("Лев питается иначе",
                lion.getFood(), is(EXPECTED_FOOD_FELINE));
    }
}