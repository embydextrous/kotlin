import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 123e4567-e89b-12d3-a456-426655440000
 * xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx - M is version, N is variant
 */
public class Uuid {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID()); // M is type 4
        System.out.println(UUID5.fromUTF8("954aac7d-47b2-5975-9a80-37eeed186527")); // M is type 5
    }
}
class UUID5 
{
    public static UUID fromUTF8(String name) {
        return fromBytes(name.getBytes(Charset.forName("UTF-8")));
    }
     
    private static UUID fromBytes(byte[] name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            return makeUUID(md.digest(name), 5);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
     
    private static UUID makeUUID(byte[] hash, int version) {
        long msb = peekLong(hash, 0, ByteOrder.BIG_ENDIAN);
        long lsb = peekLong(hash, 8, ByteOrder.BIG_ENDIAN);
        // Set the version field
        msb &= ~(0xfL << 12);
        msb |= ((long) version) << 12;
        // Set the variant field to 2
        lsb &= ~(0x3L << 62);
        lsb |= 2L << 62;
        return new UUID(msb, lsb);
    }
     
    private static long peekLong(final byte[] src, final int offset, final ByteOrder order) {
        long ans = 0;
        if (order == ByteOrder.BIG_ENDIAN) {
            for (int i = offset; i < offset + 8; i += 1) {
                ans <<= 8;
                ans |= src[i] & 0xffL;
            }
        } else {
            for (int i = offset + 7; i >= offset; i -= 1) {
                ans <<= 8;
                ans |= src[i] & 0xffL;
            }
        }
        return ans;
    }
}
