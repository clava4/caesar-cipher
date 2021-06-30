public class MessageEncryptor {

    public static void main(String[] args) {
        final CaesarCipher encrypt = new CaesarCipher();
        final String encryptedMessage = encrypt.encrypt("Hello World! I'm Slavik.", 5465);
        System.out.println(encryptedMessage);
    }
}
