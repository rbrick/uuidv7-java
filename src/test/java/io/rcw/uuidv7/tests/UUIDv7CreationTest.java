package io.rcw.uuidv7.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.rcw.uuidv7.UUIDv7;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDv7CreationTest {

    // Use the test from the RFC
    final static UUID TEST_UUID = UUID.fromString("017F21CF-D130-7CC3-98C4-DC0C0C07398F");

    @Test
    public void testCreation() {
        long unix_ts = 0x017F21CFD130L;
        long rand_a = 0xCC3L;
        long rand_b = 0x18C4DC0C0C07398FL;

        assertEquals(UUIDv7.newUUIDv7(unix_ts, rand_a, rand_b), TEST_UUID);
    }

}
