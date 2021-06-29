public class CaesarCipher {

    private static final int NUMBER_OF_LETTERS = 26;
    private static final int END_OF_BIG_LETTERS = 90;
    private static final int START_OF_SMALL_LETTERS = 97;
    private static final int END_OF_SMALL_LETTERS = 122;

    public String encrypt(String message, int key) {
        final StringBuilder encryptedMessage = new StringBuilder();
        key = keyChanging(key);

        for (int i = 0; i < message.length(); i++) {
            if (isMessagePunctuationExist(message, i)) {
                encryptedMessage.append((char) ((int) message.charAt(i)));

            } else if (isEncryptedMessagePunctuationExist(message, i, key)) {
                encryptedMessage.append((char) (((int) message.charAt(i) + key) - NUMBER_OF_LETTERS));

            } else {
                encryptedMessage.append((char) ((int) message.charAt(i) + key));
            }
        }
        return encryptedMessage.toString();
    }

    private boolean isEncryptedMessagePunctuationExist(String message, int i, int key) {
        return ((int) message.charAt(i) + key > END_OF_BIG_LETTERS && (int) message.charAt(i) + key < START_OF_SMALL_LETTERS
                || (int) message.charAt(i) + key > END_OF_SMALL_LETTERS);
    }

    private boolean isMessagePunctuationExist(String message, int i) {
        return (((int) message.charAt(i) > 31) && ((int) message.charAt(i) < 65)) ||
                (((int) message.charAt(i) > 90) && ((int) message.charAt(i) < 97)) ||
                ((int) message.charAt(i) > 122);
    }


    private int keyChanging(int key) {
        while (key < 0) {
            key += NUMBER_OF_LETTERS;
        }

        while (key >= NUMBER_OF_LETTERS) {
            key -= NUMBER_OF_LETTERS;
        }
        return key;
    }
}
