import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EncryptionTests {

    /*
     * Tests encryption of "abc" with shift 1
     */
    @Test
    public void testEncryptShift1() {
        String expected = "bcd";
        String actual = CaesarCipher.encrypt("abc", 1);
        assertEquals(expected, actual);
    }

    /*
     * Tests encryption of "abc" with shift 3
     */
    @Test
    public void testEncryptShift3() {
        String expected = "def";
        String actual = CaesarCipher.encrypt("abc", 3);
        assertEquals(expected, actual);
    }

    /*
     * Tests encryption of "abc" with shift 25
     */
    @Test
    public void testEncryptShift25() {
        String expected = "zab";
        String actual = CaesarCipher.encrypt("abc", 25);
        assertEquals(expected, actual);
    }

    /*
     * Tests encryption of "abc" with shift 26
     */
    @Test
    public void testEncryptShift26() {
        String expected = "abc";
        String actual = CaesarCipher.encrypt("abc", 26);
        assertEquals(expected, actual);
    }

    /*
     * Tests encryption of "abc def" with shift 1
     */
    @Test
    public void testEncryptWithSpaces1() {
        String expected = "bcd efg";
        String actual = CaesarCipher.encrypt("abc def", 1);
        assertEquals(expected, actual);
    }

    /*
     * Tests encryption of "abc def" with shift 18
     */
    @Test
    public void testEncryptWithSpaces18() {
        String expected = "stu vwx";
        String actual = CaesarCipher.encrypt("abc def", 18);
        assertEquals(expected, actual);
    }
}