package me.symi.carshop.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class TwoWayEncryptionTest {

    // Test metody encrypt i decrypt, oczekuje się tej samej wartości bo szyfrowaniu dwukierunkowym
    @Test
    void testEncryptAndDecrypt() {

        HashMap<Integer, String> hashMap =  new HashMap<>();
        hashMap.put(1, TwoWayEncryption.encrypt(1));
        hashMap.put(7, TwoWayEncryption.encrypt(7));
        hashMap.put(13, TwoWayEncryption.encrypt(13));
        hashMap.put(14, TwoWayEncryption.encrypt(14));
        hashMap.put(22, TwoWayEncryption.encrypt(22));
        hashMap.put(153, TwoWayEncryption.encrypt(153));
        hashMap.put(285, TwoWayEncryption.encrypt(285));
        hashMap.put(863, TwoWayEncryption.encrypt(863));
        hashMap.put(1237, TwoWayEncryption.encrypt(1237));
        hashMap.put(2614, TwoWayEncryption.encrypt(2614));
        hashMap.put(9899, TwoWayEncryption.encrypt(9899));
        hashMap.put(10100, TwoWayEncryption.encrypt(10100));
        hashMap.put(68422, TwoWayEncryption.encrypt(68422));
        hashMap.put(87754, TwoWayEncryption.encrypt(87754));
        hashMap.put(97421, TwoWayEncryption.encrypt(97421));
        hashMap.put(99999, TwoWayEncryption.encrypt(99999));
        hashMap.put(123456, TwoWayEncryption.encrypt(123456));
        hashMap.put(555444, TwoWayEncryption.encrypt(555444));
        hashMap.put(987654, TwoWayEncryption.encrypt(987654));

        for(int key : hashMap.keySet()) {
            assertEquals(key, TwoWayEncryption.decrypt(hashMap.get(key)));
            System.out.println("Liczba " + key + " zostala zaszyfrowana w ciag znakow: " + hashMap.get(key));
        }
    }

    // Test metody encrypt, oczekuje się wyjątku IllegalArgumentException z dokładnie określoną wiadomością
    @Test
    public void testEncryptWithInvalidInput() {
        assertThrowsExactly(IllegalArgumentException.class, () -> TwoWayEncryption.encrypt(0));
    }

    // Test metody decrypt, oczekuje się wyjątku IllegalArgumentException z dokładnie określoną wiadomością
    @Test
    public void testDecryptWithInvalidInput() {
        assertThrowsExactly(IllegalArgumentException.class, () -> TwoWayEncryption.decrypt("123"));
    }
}
