package com.arindam.ethereum;
import java.math.BigInteger;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class Ethereum {
	
	/* input : Address 
     * Output: true or false 
     * purpose: to validate an Ethereum Address
     * 
     * Procedure :
     * If the string begins with 0x and contain numbers between 0 to 9 and a to f
     * then it is valid ethereum address
	 */
	
	public static boolean isValidAddress(String addr)
	{
		String regex = "^0x[0-9a-f]{40}$";
		
		//Print for testing purpose and more verbose output
	    System.out.println("Incoming Address " + addr);
	    
		if(addr.matches(regex))
		{
			return true;
		}
		return false;
		
	}
	
	
	/* input : Address 
     * Output: true or false 
     * purpose: to validate a checksum an Ethereum Address 
     * Actual Checksum Procedure :
     * If the ith digit of the Address is a letter (ie. it's one of abcdef) print it in uppercase 
     * if the ith bit of the hash of the address (in binary form) is 1
     * otherwise print it in lowercase.
     * 
     * Ref URL: https://github.com/ethereum/EIPs/issues/55
	 */
	
	public static boolean isChecksumAddress(String addr)
	{	
		    //Print for testing purpose and more verbose output
		    System.out.println("Incoming Address " + addr);
		    
		    // First we need to check the address has the value between 0-9a-fA-F
		    String regex = "^0x[0-9a-fA-F]{40}$";
		    if(!addr.matches(regex))
		    {
		    	return false;
		    }
		    
		    //to fetch the part after 0x
		    String subAddr = addr.substring(2);
		    //Make it to original lower case address
		    String subAddrLower = subAddr.toLowerCase();
		    
		  //Print for testing purpose and more verbose output
		    System.out.println("Fetched Original Address " + subAddrLower);
		    
		    // if the previous step validates then we will test the checksum part
		    
		    // Create a SHA3256 hash (Keccak-256)
			SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest256();
		    digestSHA3.update(subAddrLower.getBytes());
		    String digestMessage = Hex.toHexString(digestSHA3.digest());
		    
		    //Print for testing purpose and more verbose output
		    System.out.println("Hex String " + digestMessage);
		   
		    /* Check each letter is upper case or not
		     * if it is upper case then the corresponding binary position of the hashed address
		     * should be 1 i.e the message digest letter should be getter than 7
		     * as 7 is the last Hex digit which starts with 0 in binary
		     * rest of all 8 to f starts with 1
		     */
		    
		    for(short i=0 ;i < subAddr.length();i++)
		    {
		    	if(subAddr.charAt(i)>=65 && subAddr.charAt(i)<=91)
		    	{
		    		
		    		System.out.println("Position Upper " + (subAddr.charAt(i)) );
		    		System.out.println("Position digest " + (digestMessage.charAt(i)));

		    		String ss = Character.toString(digestMessage.charAt(i));
		    		if(!(Integer.parseInt(ss,16) > 7 ))
		    		{
		    			return false;
		    		}
		    	}
		    }
		    
		    return true;
		    
		    
		    
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		
		/*
		 * Created one test Checksum address and checking it 
		 * web3.toChecksumAddress('0x65601db7431427e32ce2d60e6a373bc7a7f68eb4')
		 * '0x65601DB7431427E32Ce2d60e6a373bc7A7F68EB4'
		*/
		
		String input = "0x65601DB7431427E32Ce2d60e6a373bc7A7F68EB4";
		//Normal Address
		//String input = "0x0a99e4c3ecdfcaeb5281cfe8d81cbdefa93ff555";
		//CheckSum Address
		//String input = "0x0a99e4c3ecdfcaeb5281cfe8d81cbdefa93fG555";
		if(Ethereum.isValidAddress(input))
		{
			 System.out.println("Valid Ethereum Address");
		}
		else if(Ethereum.isChecksumAddress(input))
		{
			System.out.println("Valid Checksummed Ethereum Address");
		}
		else
		{
			System.out.println("Not A Valid Ethereum Address");
		}
		 
      
	}

}
