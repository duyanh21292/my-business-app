/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.utils;

import java.text.DecimalFormat;

/**
 *
 * @author ldanh
 */
public class MyBusinessUtils {
    
    public static boolean checkStringIsDigit(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(Character.isAlphabetic(charArray[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static String formatDecimalString(String string, boolean comma) {
        Double num = Double.valueOf(string);
        String pattern = "###";
        if (comma) {
            pattern = "#,###";
        }
        DecimalFormat formater = new DecimalFormat(pattern);
        return formater.format(num);
    }
}
