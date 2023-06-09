package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static com.constants.TestData.EXPECTED_FOOD_FELINE;
import static com.constants.TestData.EXPECTED_LION_ANIMAL;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

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
        Lion lion = new Lion(sex, feline);
        assertThat("Пол не соответствует",
                lion.doesHaveMane(), is(expectedMane));
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertThat("Количество не соответствует",
                lion.getKittens(), is(expectedKittens));
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood(EXPECTED_LION_ANIMAL)).thenReturn(EXPECTED_FOOD_FELINE);
        assertThat("Лев питается иначе",
                lion.getFood(), is(EXPECTED_FOOD_FELINE));
    }
}