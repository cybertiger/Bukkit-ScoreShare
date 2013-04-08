/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

/**
 *
 * @author antony
 */
public class StringUtil {

    public static String clampSize(String s, int maxLength) {
        if (s.length() < maxLength) {
            return s;
        } else {
            return s.substring(0, maxLength - 2) + "..";
        }
    }
    
}
