import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipher {
    /*
     * plaintext -> ciphertext
     */
    public static String encrypt(String plainText, int shift) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String cipherText = "";
        int shiftedCharIndex = 0;
        char shiftedChar = ' ';

        // convert plainText to lowercase
        plainText = plainText.toLowerCase();

        for (int i = 0; i < plainText.length(); i++) {
            if (ALPHABET.indexOf(plainText.charAt(i)) != -1) {
                shiftedCharIndex = (ALPHABET.indexOf(plainText.charAt(i)) + shift) % 26;
                shiftedChar = ALPHABET.charAt(shiftedCharIndex);
            } else {
                shiftedChar = ' ';
            }
            cipherText = cipherText.concat(Character.toString(shiftedChar));
        }
        return cipherText;

    }

    /*
     * ciphertext -> plaintext
     */
    public static String decrypt(String cipherText, int shift) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String plainText = "";
        int shiftedCharIndex = 0;
        char shiftedChar = ' ';
        int ogAlphaIndex = 0;

        // convert cipherText to lowercase
        cipherText = cipherText.toLowerCase();

        for (int i = 0; i < cipherText.length(); i++) {
            ogAlphaIndex = ALPHABET.indexOf(cipherText.charAt(i));
            if (ogAlphaIndex != -1) {
                shiftedCharIndex = (ogAlphaIndex + (26 - shift)) % 26;
                shiftedChar = ALPHABET.charAt(shiftedCharIndex);
            } else {
                shiftedChar = ' ';
            }
            plainText = plainText.concat(Character.toString(shiftedChar));
        }
        return plainText;
    }

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            // loop through 25 times, one for each possible shift
            for (int i = 1; i <= 26; i++) {
                reader = new BufferedReader(new FileReader(
                        "./data/HW1_ciphertext.txt"));
                String line = reader.readLine();
                System.out.println("Decrypt with shift " + i + ": ");
                while (line != null) {
                    System.out.println(decrypt(line, i));

                    // read next line
                    line = reader.readLine();
                }
                System.out.println("---------------------------------------------------");
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * // create an instance of Scanner class
 * Scanner sc = new Scanner(System.in);
 * 
 * // take input from the user
 * System.out.println("Enter a string for encryption using Caesar Cipher: ");
 * String plainText = sc.nextLine();
 * 
 * System.out.
 * println("Enter the value by which each character in the plaintext message gets shifted: "
 * );
 * int shiftKey = Integer.valueOf(sc.nextLine());
 * 
 * System.out.println("Encrypted Data ===> " + encrypt(plainText, shiftKey));
 * System.out.println("Decrypted Data ===> " + decrypt(encrypt(plainText,
 * shiftKey), shiftKey));
 * 
 * // close Scanner class object
 * sc.close();
 */
