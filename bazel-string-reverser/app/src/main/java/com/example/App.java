package com.example;

import com.example.mylib.TextFormatter;
import org.apache.commons.lang3.StringUtils;

public class App {
    public static void main(String[] args) {
        String text = "Hello, World!";
        String reversed = StringUtils.reverse(text);

        System.out.println(reversed);
        System.out.println(TextFormatter.addPrefix(reversed));
    }
}
