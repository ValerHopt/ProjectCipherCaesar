public class Main {
    public static  void main(String[] args) {

        Criptography cryptography = new Criptography();

        String inputFile = "input.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";
        String bruteForceFile = "bruteForce.txt";
        String key = "2";


        cryptography.encrypt(inputFile, encryptedFile, key);


        cryptography.decrypt(encryptedFile, decryptedFile, key);


        cryptography.bruteForceDecrypt(encryptedFile, bruteForceFile);
    }
}


