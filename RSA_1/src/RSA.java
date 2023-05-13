import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger fi;
    private BigInteger e;
    private BigInteger d;

    public RSA(int length) {
        Random rnd = new Random();
        p = BigInteger.probablePrime(length, rnd);
        q = BigInteger.probablePrime(length, rnd);
        n = p.multiply(q);
        fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(length / 2, rnd);
        while (fi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(fi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(fi);
    }

    // Шифрование
    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, n).toByteArray();
    }

    // Расшивровка
    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, n).toByteArray();
    }
}


