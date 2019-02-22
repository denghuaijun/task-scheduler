package com.ct.admin.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by libin on 2018/3/29.
 */
public class HttpTools {

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip != null && ip.equals("0:0:0:0:0:0:0:1")) {
                ip = "127.0.0.1";
            }
        }

        return ip;
    }
    
    public static String getBodyParamStr(ServletRequest request) {
    	BufferedReader rd = null;
    	String insureresult="";			
    	try {
    		InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream());
    		rd = new BufferedReader(inputStreamReader);
    		String line;
    		while ((line = rd.readLine()) != null) 
    		{
    			insureresult+=line;
    		}
    		rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insureresult;
	}
}
