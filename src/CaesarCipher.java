public class CaesarCipher {

    final int NUMBER_OF_LETTERS = 26;
    final int END_OF_BIG_LETTERS = 90;
    final int START_OF_SMALL_LETTERS = 96;
    final int END_OF_SMALL_LETTERS = 122;

    public String encryption(String message, int key) {
        StringBuilder cipherMessage = new StringBuilder();
        key = keyChanging(key);

        for (int i = 0; i < message.length(); i++) {
            if (punctuationExist(message, i)) {
                cipherMessage.append((char) ((int) message.charAt(i)));

            } else if ((int) message.charAt(i) + key > END_OF_BIG_LETTERS && (int) message.charAt(i) < START_OF_SMALL_LETTERS) {
                cipherMessage.append((char) (((int) message.charAt(i) + key) - NUMBER_OF_LETTERS));

            } else if ((int) message.charAt(i) + key > END_OF_SMALL_LETTERS) {
                cipherMessage.append((char) (((int) message.charAt(i) + key) - NUMBER_OF_LETTERS));

            } else {
                cipherMessage.append((char) ((int) message.charAt(i) + key));
            }
        }
        return cipherMessage.toString();
    }

    private boolean punctuationExist(String message, int i) {
        return (((int) message.charAt(i) > 31) && ((int) message.charAt(i) < 65)) ||
                (((int) message.charAt(i) > 90) && ((int) message.charAt(i) < 97)) ||
                ((int) message.charAt(i) > 122);
    }

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
