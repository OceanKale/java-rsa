import java.math.BigInteger;
import java.util.Random;


    /**
   An implementation of RSA using big integers.
   <p>
   Algorithm: 
   <ul>
    <li>Generate two large prime numbers p and q
    <li>Let n = p * q
    <li>Let m = (p-1) * (q-1)
    <li>Choose a small number e, coprime to m, i.e., gcd(e,m) = 1
    <li>Find d such that for some i, d = (i * m + 1) / e is an integer 
    <li>Publish e and n as public key
    <li>Keep d and n as the private key
    <li>To encrypt P calculate P^e % n
    <li>To decrypt C calculate C^d % n
   </ul>
    A tiny example...
   <ul>
    <li>p = 7 and q = 19
    <li>n = 133
    <li>m = 108
    <li>Loop starting with e=2:
         <ul>
         <li>gcd(2,108) = 2 -- no
         <li>gcd(3,108) = 3 -- no
         <li>gcd(4,108) = 4 -- no
         <li>gcd(5,108) = 1 -- yes
         </ul>
      e=5
    <li>d = 65
    <li>Public key n = 133, e = 5
    <li>Private key n = 133, d = 65
    <li>Encrypt 6 ==> 6^5 % 133 = 62
    <li>Decrypt 62 ==> 62^65 % 133 = 6
    </ul>
    */
    public class RSAKeys {
	//---------------------------------------------------------------------
	// Static 
	/**
       Takes a message and a public key and encrypts the message using that
       public key. For simplicity our messages are represented as an array of
       ints where each int in that array should be individually encrypted.
	*/
	public static String[] encrypt (int[] message, 
					String modulus, 
					String publicExponent) {
	    BigInteger e = new BigInteger(publicExponent);
	    BigInteger n = new BigInteger(modulus);
	    String[] result = new String[message.length];
	    for (int i=0; i<message.length; i++) {
		BigInteger m = BigInteger.valueOf(message[i]);
		BigInteger enc = m.modPow(e,n);
		result[i] = enc.toString();
	    }
	    return result;
	}

	//---------------------------------------------------------------------
	// Instance variables
	private String modulus;
	private String publicExponent;
	private String privateExponent;

	//---------------------------------------------------------------------
	// Constructor
	/**
       Generates keys of the given length in bits. To generate the two primes
       <code>p</code> and <code>q</code>, use the following code snippet:
       <pre>
       Random r = new java.util.Random();
       BigInteger p = BigInteger.probablePrime(bitLength/2,r);
       BigInteger q = BigInteger.probablePrime(bitLength/2,r);
       </pre>
	*/
	public RSAKeys (int bitLength) {
	    BigInteger n; // modulus
	    BigInteger e; // public exponent
	    BigInteger d; // secret exponent

	    Random r = new Random();
	    BigInteger p = BigInteger.probablePrime(bitLength/2,r);
	    BigInteger q = BigInteger.probablePrime(bitLength/2,r);
	    n = p.multiply(q);
	    BigInteger pm = p.subtract(BigInteger.ONE);
	    BigInteger qm = q.subtract(BigInteger.ONE);
	    BigInteger m = pm.multiply(qm);
	    e = new BigInteger("2");
	    while (e.gcd(m).intValue() != 1) 
		e = e.add(BigInteger.ONE);
	    d = e.modInverse(m);

	    this.modulus = n.toString();
	    this.publicExponent = e.toString();
	    this.privateExponent = d.toString();
	}

	//---------------------------------------------------------------------
	// Instance methods
	/**
       Returns the modulus.
	*/
	public String getModulus () { return modulus; }


	/**
       Returns the public exponent.
	*/
	public String getPublicExponent () { return publicExponent; }

	/**
       Returns the private exponent.
	*/
	public String getPrivateExponent () { return privateExponent; }

    }
