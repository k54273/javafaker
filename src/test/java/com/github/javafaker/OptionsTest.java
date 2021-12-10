package com.github.javafaker;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class OptionsTest extends AbstractFakerTest {

    private String[] options;

    @Before
    public void setupOptions() {
        options = new String[]{"A", "B", "C"};
    }

    @Test
    public void testOptionWithArray() {
        assertThat(faker.options().option(options), isOneOf(options));
    }

    @Test
    public void testOptionWithVarargsString() {
        assertThat(faker.options().option("A", "B", "C"), isOneOf(options));
    }

    @Test
    public void testOptionWithVarargsInteger() {
        Integer[] integerOptions = new Integer[] { 1, 3, 4, 5};
        assertThat(faker.options().option(1, 3, 4, 5), isOneOf(integerOptions));
    }

    @Test
    public void testOptionWithEnum() {
        assertThat(faker.options().option(Day.class), isOneOf(Day.values()));
    }

    @Test
    public void testNextArrayElement() {
        Integer[] array = new Integer[] { 1, 2, 3, 5, 8, 13, 21 };

        for (int i = 1; i < 10; i++) {
            assertThat(faker.options().nextElement(array), isIn(array));
        }
    }

    @Test
    public void testNextListElement() {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 13, 21);
        for (int i = 1; i < 10; i++) {
            assertThat(faker.options().nextElement(list), isIn(list));
        }
    }

    @Test
    // check that nextNull returns the app object or null
    public void testNextNullAppElement() {
        App app = faker.app();
        List<App> list = Arrays.asList(null, app);
        assertThat(faker.options().nextNull(app), isIn(list));
    }

    @Test
    // check that nextNull returns the commerce object or null
    public void testNextNullCommerceElement() {
        Commerce commerce  = faker.commerce();
        List<Commerce> list = Arrays.asList(null, commerce);
        assertThat(faker.options().nextNull(commerce), isIn(list));
    }

    @Test
    // check that nextNull returns the file object or null
    public void testNextNullFileElement() {
        File file = faker.file();
        List<File> list = Arrays.asList(null, file);
        assertThat(faker.options().nextNull(file), isIn(list));
    }

    @Test
    // check that nextNull returns the guide object or null
    public void testNextNullGuideElement() {
        HitchhikersGuideToTheGalaxy guide = faker.hitchhikersGuideToTheGalaxy();
        List<HitchhikersGuideToTheGalaxy> list = Arrays.asList(null, guide);
        assertThat(faker.options().nextNull(guide), isIn(list));
    }

    @Test
    // check that nextNull returns the space object or null
    public void testNextNullSpaceElement() {
        Space space = faker.space();
        List<Space> list = Arrays.asList(null, space);
        assertThat(faker.options().nextNull(space), isIn(list));
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
