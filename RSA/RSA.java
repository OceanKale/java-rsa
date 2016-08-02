import java.math.BigInteger;
import java.util.Random;


public class RSA {

    public static void main(String[] args) {
	rsaExample(421, 13, 10);
	//	rsaExample(13, 31, 6);
	//	rsaExample(7, 19, 6);
    }
    static int[] rsaExample (int x, int y, int u) {
	//   int p = 7;
	//        int q = 19;
        System.out.printf("p = %d and q = %d%n",x,y);

	int nu = x*y; // is n
	int mu = (x-1) * (y-1); // is m
	int e = 2;
	int d = 2;
	//int message = 6;
	
	rsaModulus(x, y);
	rsaFactor(x, y);
	e = publicRSA(e, mu);
	publicRSA(e, mu);
	d = privateRSA(d, e, mu);
	privateRSA(d, e, mu);
	System.out.printf("Original message = %d%n", u);
	int encrypted = encrypting(e, u, nu);
	int decrypted = decrypting(d, encrypted, nu);
	int ret[] = new int[6];
	ret[0] = rsaModulus(x, y);
	ret[1] = rsaFactor(x, y);
	ret[2] = publicRSA(e, mu);
	ret[3] = privateRSA(d, e, mu);
	ret[4] = encrypted;
	ret[5] = decrypted;

	return ret;
	/**
        int n = p * q;
        System.out.printf("modulus n = %d%n",n);

        int m = (p-1) * (q-1);
        System.out.printf("m = %d%n",m);

        int e = 2;
        while (gcd(e,m) != 1) e++;
        System.out.printf("public key exponent e = %d%n",e);

        int d = 2;
        while (d * e % m != 1) d++;
        System.out.printf("private key exponent d = %d%n",d);

        int message = 6;
        System.out.printf("Original message = %d%n",message);

        int encrypted = ((int)Math.pow(message,e)) % n;
        System.out.printf("Encrypted message = %d%n",encrypted);

        int decrypted = ((int)Math.pow(encrypted,d)) % n;
        System.out.printf("Decrypted message = %d%n",decrypted);
	**/
 }
    
    static int rsaModulus(int x, int y) {
	int n = x*y;
	System.out.printf("modulus n = %d%n",n);
	return n;
    }

    static int rsaFactor(int x, int y) {
       //rsaExponent(m);
	int m = (x-1) * (y-1);
	System.out.printf("m = %d%n",x);    
	return m;    
    }

    static int publicRSA(int x, int y) {
        while (gcd(x, y) != 1) x++;
	System.out.printf("public key exponent e = %d%n",x);
	return x;
    }

    static int privateRSA(int x, int y, int z) {
	//int d = 2;
        while (x * y % z != 1) x++;
	System.out.printf("private key exponent d = %d%n",x);
	return x;
    }

    static int  encrypting(int x, int y, int n) {
	int encrypted = ((int)Math.pow(y,x)) % n; // y is message
	System.out.printf("Encrypted message = %d%n",encrypted);
	return encrypted;
    }

    static int decrypting(int x, int y, int n) {
	int decrypted = ((int)Math.pow(y, x)) % n; // y is encrypted
	System.out.printf("Decrypted message = %d%n",decrypted);
	return decrypted;
    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }




}
