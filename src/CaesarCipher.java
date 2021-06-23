import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        System.out.print("Plaintext: ");
        final Scanner in = new Scanner(System.in);
        final String message = in.nextLine();

        System.out.print("Shift: ");
        int key = in.nextInt();

        System.out.println(coding(message, keyChanging(key)));

    }

    public static String coding(String message, int key) {
        final int NUMBEROFLETTERS = 26;
        final int ENDOFBIGLETTERS = 90;
        final int STARTOFSMALLLETTERS = 96;
        final int ENDOFSMALLLETTERS = 122;
        String cipherMessage = "";

        for (int i = 0; i < message.length(); i++) {
            boolean PUNCTUATION = (((int) message.charAt(i) > 31) && ((int) message.charAt(i) < 65)) || (((int) message.charAt(i) > 90) && ((int) message.charAt(i) < 97)) || ((int) message.charAt(i) > 122);

            if (PUNCTUATION == true) {
                cipherMessage += (char) ((int) message.charAt(i));

            } else if ((int) message.charAt(i) + key > ENDOFBIGLETTERS && (int) message.charAt(i) < STARTOFSMALLLETTERS) {
                cipherMessage += (char) (((int) message.charAt(i) + key) - NUMBEROFLETTERS);

            } else if ((int) message.charAt(i) + key > ENDOFSMALLLETTERS) {
                cipherMessage += (char) (((int) message.charAt(i) + key) - NUMBEROFLETTERS);

            } else {
                cipherMessage += (char) ((int) message.charAt(i) + key);
            }
        }
        return cipherMessage;
    }

    public static int keyChanging(int key) {
        while (key < 0) {
            key += 26;
        }

        while (key >= 26) {
            key -= 26;
        }
        return key;
    }
}
