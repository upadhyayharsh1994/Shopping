package controller;
import java.math.*;

import java.security.*;

public class Encryption {

	
	public static String MD5(String input){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString();
			while(hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
