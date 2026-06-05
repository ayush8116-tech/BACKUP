import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person = null;

    @BeforeEach
    void setUp() {
       person = new Person("haji", 20);
    }

    @Test
    void hajiShouldBeAdult() {
        assertTrue(person.isAdult());
    }

    @Test
    void hajiShouldNotBeAdult() {
        assertFalse(person.isAdult());
    }
}

