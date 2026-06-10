package PracticalWorkNumberThree;

import java.util.Stack;

public class HTMLValidator {

    public static boolean isValid(String html) {
        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < html.length()) {

            if (html.charAt(i) == '<') {
                int closeIndex = html.indexOf('>', i);
                if (closeIndex == -1) {
                    return false;
                }

                String tag = html.substring(i + 1, closeIndex);

                // закрывающий тег
                if (tag.startsWith("/")) {
                    String tagName = tag.substring(1);

                    if (stack.isEmpty()) {
                        return false;
                    }

                    String lastOpenTag = stack.pop();
                    if (!lastOpenTag.equals(tagName)) {
                        return false;
                    }
                }
                // открывающий тег
                else {
                    stack.push(tag);
                }

                i = closeIndex + 1;
            } else {
                i++;
            }
        }

        return stack.isEmpty();
    }
}