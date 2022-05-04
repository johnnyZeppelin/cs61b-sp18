package Miscellany.Plaza;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestDate {
    @Test
    public void testDate() {
        Date date = new Date(2022, 5, 14);
        //date.day++;
        assertEquals(13, new Date(2022, 13, 4).month);
    }
}
