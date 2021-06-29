public class Encrypting {

    public static void main(String[] args) {
        final CaesarCipher encrypt = new CaesarCipher();
        String encryptedMessage = encrypt.encrypt("Hello World! I'm Slavik.", 5465);
        System.out.println(encryptedMessage);
    }
}
