public class Encrypting {

    public static void main(String[] args) {
        final CaesarCipher encrypt = new CaesarCipher();
        String encryptedMessage = encrypt.encryption("Hello World! I'm Slavik.", 7);
        System.out.println(encryptedMessage);
    }
}
