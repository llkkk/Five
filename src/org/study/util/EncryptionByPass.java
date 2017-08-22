package org.study.util;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Encoder;

public class EncryptionByPass {
	public static String getBase64(String str){
		byte[]b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
			if(b != null){
				s = new BASE64Encoder().encode(b);
			}
			return s;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
