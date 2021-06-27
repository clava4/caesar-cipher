public class CaesarCipher {

    // TODO: make this constants private and static
    final int NUMBER_OF_LETTERS = 26;
    final int END_OF_BIG_LETTERS = 90;
    final int START_OF_SMALL_LETTERS = 96;
    final int END_OF_SMALL_LETTERS = 122;

    // TODO: rename from encryption to encrypt (names of methods should be noun)
    // TODO: add final modifier where it is possible
    public String encryption(String message, int key) {
        StringBuilder cipherMessage = new StringBuilder(); // TODO: maybe encryptedMessage? 
        key = keyChanging(key);

        for (int i = 0; i < message.length(); i++) {
            // TODO: work only with uppercase and lowercase letters, skip the other symbols
            if (punctuationExist(message, i)) {
                cipherMessage.append((char) ((int) message.charAt(i)));

            // TODO: extract the condition to separate method
            } else if ((int) message.charAt(i) + key > END_OF_BIG_LETTERS && (int) message.charAt(i) < START_OF_SMALL_LETTERS) {
                cipherMessage.append((char) (((int) message.charAt(i) + key) - NUMBER_OF_LETTERS)); // TODO: this operation as the same as the operation in the line 26, merge conditions from the 21 and 25 lines 

            // TODO: extract the condition to separate method
            } else if ((int) message.charAt(i) + key > END_OF_SMALL_LETTERS) {
                cipherMessage.append((char) (((int) message.charAt(i) + key) - NUMBER_OF_LETTERS));

            } else {
                cipherMessage.append((char) ((int) message.charAt(i) + key));
            }
        }
        return cipherMessage.toString();
    }

    // TODO: rename to isPunctuationExist
    private boolean punctuationExist(String message, int i) {
        return (((int) message.charAt(i) > 31) && ((int) message.charAt(i) < 65)) ||
                (((int) message.charAt(i) > 90) && ((int) message.charAt(i) < 97)) ||
                ((int) message.charAt(i) > 122);
    }

    // TODO: reuse NUMBER_OF_LETTERS constant
    private int keyChanging(int key) {
        while (key < 0) {
            key += 26;
        }

        while (key >= 26) {
            key -= 26;
        }
        return key;
    }
}
