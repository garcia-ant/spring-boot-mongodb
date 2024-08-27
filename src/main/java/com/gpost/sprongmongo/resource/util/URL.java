package com.gpost.sprongmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeparam(String title) {
		try {
			return URLDecoder.decode(title, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}

