package io.rcw.uuidv7.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.rcw.uuidv7.UUIDv7;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.UUID;

public class UUIDv7CreationTest {

    // Use the test from the RFC
    final static UUID TEST_UUID = UUID.fromString("017F21CF-D130-7CC3-98C4-DC0C0C07398F");

    @Test
    public void testCreation() {
        long unix_ts = 0x017F21CFD130L;
        long rand_a = 0xCC3L;
        long rand_b = 0x18C4DC0C0C07398FL;

        assertEquals(TEST_UUID, UUIDv7.newUUIDv7(unix_ts, rand_a, rand_b));
    }

    @Test
    public void testGeneration() {
        final SecureRandom random = new SecureRandom();

        for (int i = 0; i < 1_000_000; i++) {
           UUID generated = UUIDv7.newUUIDv7(random);

           assertEquals(7, generated.version());
           assertEquals(0b10, generated.variant(), Long.toBinaryString(generated.getLeastSignificantBits()));
        }
    }

}
