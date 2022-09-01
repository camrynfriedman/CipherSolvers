import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecryptionTests {

    /*
     * Tests decryption of "abc" with shift 1
     */
    @Test
    public void testDecryptShift1() {
        String expected = "abc";
        String actual = CaesarCipher.decrypt("bcd", 1);
        assertEquals(expected, actual);
    }

    /*
     * Tests decryption of "abc" with shift 3
     */
    @Test
    public void testDecryptShift3() {
        String expected = "abc";
        String actual = CaesarCipher.decrypt("def", 3);
        assertEquals(expected, actual);
    }

    /*
     * Tests decryption of "abc" with shift 25
     */
    @Test
    public void testDecryptShift25() {
        String expected = "abc";
        String actual = CaesarCipher.decrypt("zab", 25);
        assertEquals(expected, actual);
    }

    /*
     * Tests decryption of "abc" with shift 26
     */
    @Test
    public void testDecryptShift26() {
        String expected = "abc";
        String actual = CaesarCipher.decrypt("abc", 26);
        assertEquals(expected, actual);
    }

    /*
     * Tests decryption of "abc def" with shift 1
     */
    @Test
    public void testDecryptWithSpaces1() {
        String expected = "abc def";
        String actual = CaesarCipher.decrypt("bcd efg", 1);
        assertEquals(expected, actual);
    }

    /*
     * Tests decryption of "abc def" with shift 18
     */
    @Test
    public void testDecryptWithSpaces18() {
        String expected = "abc def";
        String actual = CaesarCipher.decrypt("stu vwx", 18);
        assertEquals(expected, actual);
    }
}