package ru.sberbank.school.HomeTask8;

public class CryptingClass {
    static byte[] encrypt(byte[] input, String key) {
        byte[] output = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = (byte) (output[i] + key.charAt(i % key.length()));
        }
        return output;
    }
}
