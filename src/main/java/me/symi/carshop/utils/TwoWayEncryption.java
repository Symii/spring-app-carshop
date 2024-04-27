package me.symi.carshop.utils;

import java.util.HashMap;

public class TwoWayEncryption {

    private static final HashMap<Character, Character> encryptionMap = new HashMap<>();
    private static final HashMap<Character, Character> decryptionMap = new HashMap<>();

    static {
        // Utwórz mapowanie znaków dla szyfrowania
        for (char c = '0'; c <= '9'; c++) {
            char encrypted = (char) ('9' - (c - '0'));
            encryptionMap.put(c, encrypted);
            decryptionMap.put(encrypted, c);
        }
    }

    public static String encrypt(int number) {
        if (number < 1 || number > 999999) {
            throw new IllegalArgumentException("Liczba musi być z zakresu od 1 do 999999");
        }

        String numberStr = String.format("%06d", number); // Uzupełnij zerami z przodu do 6 cyfr
        StringBuilder encrypted = new StringBuilder();
        for (char c : numberStr.toCharArray()) {
            encrypted.append(encryptionMap.get(c));
        }
        return encrypted.toString();
    }

    // Metoda deszyfrująca liczbę
    public static int decrypt(String encryptedNumber) {
        if (encryptedNumber.length() != 6) {
            throw new IllegalArgumentException("Zaszyfrowana liczba musi mieć 6 znaków");
        }

        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedNumber.toCharArray()) {
            decrypted.append(decryptionMap.get(c));
        }
        return Integer.parseInt(decrypted.toString());
    }




}
