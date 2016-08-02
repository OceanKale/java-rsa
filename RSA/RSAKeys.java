import java.math.BigInteger;
import java.util.Random;


    /**
   An implementation of RSA using big int.
   See: https://en.wikipedia.org/wiki/RSA_(cryptosystem)
   */
   public class RSAKeys {
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
