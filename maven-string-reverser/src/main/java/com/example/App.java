package com.example;

import org.apache.commons.lang3.StringUtils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String text = "Hello World!";
        String reversed = StringUtils.reverse(text);

        System.out.println(reversed);
    }
}
