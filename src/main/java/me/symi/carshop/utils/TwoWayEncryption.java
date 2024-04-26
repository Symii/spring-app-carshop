package me.symi.carshop.utils;

public class TwoWayEncryption {
    public static String encrypt(String data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            int unicodeValue = data.charAt(i);
            builder.append(String.format("%06d", unicodeValue));
        }
        return builder.toString().substring(0, 6);
    }

    public static String decrypt(String encryptedData) {
        int unicodeValue = Integer.parseInt(encryptedData);
        return String.valueOf((char) unicodeValue);
    }




}
