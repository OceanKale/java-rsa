import org.junit.*;
import static org.junit.Assert.*; 

public class RSATest {

    public static void main(String[] args) {
	org.junit.runner.JUnitCore.main("RSATest");
    }

    @Test public void testRSAExample() {
	/**
	int p = 7;
	int q = 19;
	int mes = 6;
	int expec[] = new int[6];
	expec[0] = 133;
	expec[1] = 108;
	expec[2] = 5;
	expec[3] = 65;
	expec[4] = 62;
	expec[5] = 62;
	**/

	int expect[] = new int[6];
	expect[0] = 403;
	expect[1] = 360;
	expect[2] = 7;
	expect[3] = 103;
	expect[4] = 254;
	expect[5] = 254;

	int expecte[] = new int[6];
	expecte[0] = 5473;
	expecte[1] = 5040;
	expecte[2] = 11;
	expecte[3] = 2291;
	expecte[4] = 4326;
	expecte[5] = 4326;

	//	assertArrayEquals("Not right", expec, RSA.rsaExample(p, q, mes));
	//assertArrayEquals("Not right 2", expect, RSA.rsaExample(13, 33, 6));
	assertArrayEquals("Not right 3", expecte, RSA.rsaExample(421, 13, 10));
    } 	

    @Test public void testRsaModulus() {
	int a = 13;
	int b = 31;
	int c = 403;

	int p = 7;
	int q = 19;
	int x = 133; //7*19
	
	//	assertEquals("Wrong 1st modulus", x, RSA.rsaModulus(p, q));
	//assertEquals("Wrong 2nd modulus", c, RSA.rsaModulus(a, b));
	assertEquals("Wrong 3rd modulus", 5473, RSA.rsaModulus(421, 13)); 
    } 

    @Test public void testRsaFactor() {
	int a = 13;
	int b = 31;
	int c = 360;
	
	int p = 7;
	int q = 19;
	int m = 108; //6*18

	//assertEquals("Wrong M", m, RSA.rsaFactor(p, q));
	//assertEquals("Wrong M 2", c, RSA.rsaFactor(a, b));
	assertEquals("Wrong M 3", 5040, RSA.rsaFactor(421, 13));
    }

    @Test public void testPublicRSA() {
	int a = 360;
	int b = 2;
	int c = 7;

	int m = 6*18;
	int e = 2;
	int x = 5;

	//assertEquals("Public key incorrect", x, RSA.publicRSA(e, m));
	//assertEquals("Public key 2 incorrect", c, RSA.publicRSA(b, a));
	assertEquals("Public key 3 incorrect", 11, RSA.publicRSA(2, 421));
    }

    @Test public void testPrivateRSA() {
	int a = 103;
	int b = 2;
	int c = 7;
	int f = 360;
	
	int x = 65;
	int d = 2;
	int e = 5;
	int m = 6*18;

	//assertEquals("Private key incorrect", x, RSA.privateRSA(d, e, m));
	//assertEquals("Private key 2 incorrect", a, RSA.privateRSA(b, c, 360));
	assertEquals("Private key 3 incorrect", 2291, RSA.privateRSA(2, 11, 421));
    }

    @Test public void testEncrypting() {
	int a = 254;
	int b = 403;
	int c = 7;
	int d = 6;
	
	int x = 62;
	int n = 7*19;
	int e = 5;;
	int mes = 6;

	//assertEquals("Encryption incorrect", x, RSA.encrypting(e, mes, n));
	//assertEquals("Encryption 2 incorrect", a, RSA.encrypting(c, d, b));
	assertEquals("Encryption 3 incorrect", 4326, RSA.encrypting(11, 10, 5473));
	}

    @Test public void testDecrypting() {
	int a = 103;
	int encryptt = 254;
	int b = 403;
	int c = 165;

	int d = 65;
	int encrypt = 62;
	int n = 7*19;
	int x = 62;

	//assertEquals("Decryption incorrect", x, RSA.decrypting(d, encrypt, n));
	//assertEquals("Decryption 2 incorrect", c, RSA.decrypting(a, encryptt, b));
	assertEquals("Decryption 3 incorrect", 4326, RSA.decrypting(2291, 4326, 5473));
    }
}
