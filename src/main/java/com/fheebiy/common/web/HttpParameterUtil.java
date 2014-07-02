package com.fheebiy.common.web;


import com.fheebiy.common.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class HttpParameterUtil {

    public static int getParameterInt(HttpServletRequest request, String parameter) {
        try {
            return Integer.valueOf(request.getParameter(parameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long getParameterLong(HttpServletRequest request, String parameter) {
        try {
            return Long.valueOf(request.getParameter(parameter));
        } catch (NumberFormatException e) {
            return 0l;
        }
    }
    
    public static double getParameterDouble(HttpServletRequest request, String parameter) {
        try {
            return Double.valueOf(request.getParameter(parameter));
        } catch (Exception e) {
            return 0d;
        }
    }

	public static String[] getParameterArrays(HttpServletRequest request, String parameter) {
		try {
			String[] array = request.getParameterValues(parameter);
			if(array == null){
				array = new String[]{};
			}
			return array;
		} catch (Exception e) {
			return new String[]{};
		}
	}

    public static Date getParameterDate(HttpServletRequest request, String parameter) {
        return DateUtil.parseDate(request.getParameter(parameter));
    }

    public static String getParameter(HttpServletRequest request, String parameter) {
        String s = request.getParameter(parameter);
        return s == null ? "" : s;
    }

}
