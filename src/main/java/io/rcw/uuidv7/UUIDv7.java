package io.rcw.uuidv7;

import java.security.SecureRandom;
import java.util.UUID;

public class UUIDv7 {
    public static final long BIT48_MASK = 0x7FFFFFFFFFFFL;
    public static final long BIT62_MASK = 0x1FFFFFFFFFFFFFFFL;
    public static final long BIT12_MAX = 0x1000; // 4096
    public static final int VER_7_MSB = 0b0111;

    public static UUID newUUIDv7(long ts, long rand_a, long rand_b) {
        /* top 64 bits are 48-bit timestamp - 4-bit version - 12-bit rand_a */
        long msb = ts & BIT48_MASK;

        msb <<= 4;
        msb |= VER_7_MSB;
        msb <<= 12;
        msb |= rand_a;

        /* bottom 64 bits are 2-bit variant - 62-bit rand_b  */
        long lsb = (0b10 & BIT62_MASK) << 62;
        lsb |= rand_b;

        return new UUID(msb, lsb);

    }

    public static UUID newUUIDv7(final SecureRandom random) {
        return newUUIDv7(System.currentTimeMillis(), random.nextLong(BIT12_MAX), random.nextLong(BIT62_MASK));
    }
}