package com.correaj418;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator
{
    private static final String PASSWORD_PATTERN = "";

    private List<String> generatePasswords(String arPasswordPattern)
    {
        ArrayList<String> rvGeneratedPassword = new ArrayList<>();

        Pattern loPattern = Pattern.compile("\\{(.*?)\\}");

        Matcher loPatternMatcher = loPattern.matcher(arPasswordPattern);

        List<String> loMatchedPatterns = new ArrayList<>();

        int loIndex = 0;

        while (loPatternMatcher.find())
        {
//            System.out.println(loPatternMatcher.group(1));

            String lpMatchedPattern = loPatternMatcher.group(1);

            loMatchedPatterns.add(loPatternMatcher.group(1));

            String[] loPatternPossibilities = lpMatchedPattern.split("/");

            String lpSubPassword = arPasswordPattern.substring(
                    loIndex, loPatternMatcher.start());

            for (String lpPatternPossibility : loPatternPossibilities)
            {
                String lpSubConcatenatedPassword = lpSubPassword + lpPatternPossibility;

                rvGeneratedPassword.add(lpSubConcatenatedPassword);

                System.out.println(lpSubConcatenatedPassword);
            }

            System.out.println(loPatternPossibilities);
        }

        return null;
    }

    public static void main(String[] args)
    {
        List<String> loGeneratedPasswords = new PasswordGenerator().generatePasswords
                (PASSWORD_PATTERN);

//        for (String lpPassword : loGeneratedPasswords)
//        {
//            System.out.println(lpPassword);
//        }
    }
}
