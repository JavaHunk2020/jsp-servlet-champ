package com.servlet.utils;

import java.security.SecureRandom;

public class Utils {
	
	// Function to generate random alpha-numeric password of specific length
		public static String generateRandomPassword(int len){
			// ASCII range - alphanumeric (0-9, a-z, A-Z)
			final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			SecureRandom random = new SecureRandom();
			StringBuilder sb = new StringBuilder();
			// each iteration of loop choose a character randomly from the given ASCII range
			// and append it to StringBuilder instance
			for (int i = 0; i < len; i++) {
				int randomIndex = random.nextInt(chars.length());
				sb.append(chars.charAt(randomIndex));
			}
			return sb.toString();
		}
		
		public static void main(String[] args) {
			System.out.println(Utils.generateRandomPassword(5));
		}

}
