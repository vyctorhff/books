/*
 * Created on 19/06/2011, 19:28:07
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaArranjoTest.java
 *
 * @autor torugo
 */
package base.cap6.listas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaArranjoTest {

    private ListaArranjo<String> dinamicList;

    @BeforeEach
    void setup() {
        this.dinamicList = new ListaArranjo<>();
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, this.dinamicList.size());

        this.dinamicList.add(0, "victor");
        assertEquals(1, this.dinamicList.size());

        this.dinamicList.add(0, "albe");
        assertEquals(2, this.dinamicList.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(this.dinamicList.isEmpty());

        this.dinamicList.add(0, "victor");
        assertFalse(this.dinamicList.isEmpty());
    }

    @Test
    public void testGet() throws Exception {
        this.dinamicList.add(0, "victor");
        this.dinamicList.add(1, "albe");
        this.dinamicList.add(2, "miguel");

        var value = this.dinamicList.get(0);
        assertEquals("victor", value);

        value = this.dinamicList.get(1);
        assertEquals("albe", value);

        value = this.dinamicList.get(2);
        assertEquals("miguel", value);
    }

    @Test
    public void testSet() throws Exception {
        this.dinamicList.add(0, "victor");
        this.dinamicList.add(1, "albe");

        this.dinamicList.add(1, "miguel");

        var value = this.dinamicList.get(0);
        assertEquals("victor", value);

        value = this.dinamicList.get(1);
        assertEquals("miguel", value);

        value = this.dinamicList.get(2);
        assertEquals("albe", value);
    }

    @Test
    public void testAddWithNegativeIndex() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> this.dinamicList.add(-1, " "));
    }

    @Test
    public void testRemove() throws Exception {
        this.dinamicList.add(0, "victor");
        this.dinamicList.add(1, "albe");

        this.dinamicList.remove(1);
        assertEquals(1, this.dinamicList.size());

        this.dinamicList.remove(0);
        assertTrue(this.dinamicList.isEmpty());
    }

}
