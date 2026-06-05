import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonTest {

    @Test
    void shouldReturnsSurname() {
        Person person = mock(Person.class);
        when(person.addSurname("verma")).thenReturn("verma");

        assertEquals("verma", person.addSurname("verma"));
    }

    @Test
    void shouldReturnsAge() {
        Person person = mock(Person.class);
        when(person.addAge(1)).thenReturn(1);

        assertEquals(1, person.addAge(1));
    }

    @Test
    void shouldThrowsErrorOnAge0() {
        Person person = mock(Person.class);
        when(person.addAge(0)).thenThrow(new RuntimeException("age is not valid"));
    }

    @Test
    void shouldReturnIsAdultTrue() {
        Person person = mock(Person.class);

        when(person.isAdult(19)).thenReturn(true);

        assertEquals(true, person.isAdult(19));
    }

    @Test
    void shouldVerifyTheMock() {
        Person person = mock(Person.class);
        when(person.isAdult(19)).thenReturn(true);

        assertEquals(true, person.isAdult(19));
    }

    @Test
    void throwException() {
        Person person = mock(Person.class);

        doThrow(new RuntimeException())
                .when(person).isAdult(0);

        person.isAdult(0);
    }

    @Test
    void verifyListInOrder() {
        List mockedList = mock(List.class);

        mockedList.add("added first");
        mockedList.add("added second");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("added second");
        inOrder.verify(mockedList).add("added first");
    }

    @Test
    void verifyNeverCalled() {
        List mockedList = mock(List.class);

        mockedList.add("one");

        verify(mockedList).add("one");
        verify(mockedList, never()).add("two");
    }

    @Test
    void verifyRedundantInteractions() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.add("two");

        verifyNoMoreInteractions(mockedList);
    }

    @Test
    void consecutiveStubbing() {
        List mockedList = mock(List.class);

        when(mockedList.add("one")).thenThrow(new RuntimeException()).thenReturn(true);
        mockedList.add("one");

        assertEquals(true,mockedList.add("one"));
    }
}
