import java.io.*;
import java.util.*;

public class Criptography {
    private final String alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя.,:\"-!? ";
    private final int alphabetSize = alphabet.length();

    public void encrypt(String inputFile, String outputFile, String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encryptLine(line, key);
                writer.write(encryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt(String inputFile, String outputFile, String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decryptLine(line, key);
                writer.write(decryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bruteForceDecrypt(String inputFile, String outputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < alphabetSize; i++) {
                    String decryptedLine = decryptLine(line, String.valueOf(i));
                    writer.write("Key: " + i + "\n");
                    writer.write(decryptedLine);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String encryptLine(String line, String key) {
        StringBuilder encryptedLine = new StringBuilder();

        for (char c : line.toCharArray()) {
            int index = alphabet.indexOf(Character.toLowerCase(c));
            if (index != -1) {
                int encryptedIndex = (index + Integer.parseInt(key)) % alphabetSize;
                encryptedLine.append(alphabet.charAt(encryptedIndex));
            } else {
                encryptedLine.append(c);
            }
        }

        return encryptedLine.toString();
    }

    private String decryptLine(String line, String key) {
        StringBuilder decryptedLine = new StringBuilder();

        for (char c : line.toCharArray()) {
            int index = alphabet.indexOf(Character.toLowerCase(c));
            if (index != -1) {
                int decryptedIndex = (index - Integer.parseInt(key) + alphabetSize) % alphabetSize;
                decryptedLine.append(alphabet.charAt(decryptedIndex));
            } else {
                decryptedLine.append(c);
            }
        }

        return decryptedLine.toString();
    }
}
