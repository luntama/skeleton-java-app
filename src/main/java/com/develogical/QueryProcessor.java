package com.develogical;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    static final String PATTERN = "what is \\d+ plus \\d+";
    static final String INT_PATTERN = "\\d+";

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        else if (query.toLowerCase().contains("what is your name")) {
            return "Luis Untama";
        }
        else if (query.toLowerCase().startsWith("which of the following numbers is the largest:")) {
            String arguments = query.split(":")[1];
            String [] numbers = arguments.split(",");
            try {
                return ""+Math.max(Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim()));
            }
            catch(Exception e) {
                return "";
            }
        }
        else if (Pattern.matches(PATTERN, query.toLowerCase())) {
            Pattern p = Pattern.compile(INT_PATTERN);
            Matcher m = p.matcher(query.toLowerCase());
            int total = 0;
            while (m.find()) {
                total += Integer.parseInt(m.group());
            }
            return "" + total;
        }
        else if (query.toLowerCase().startsWith("which of the following numbers are primes:")) {
            String arguments = query.split(":")[1];
            Pattern p = Pattern.compile(INT_PATTERN);
            Matcher m = p.matcher(arguments);
            ArrayList primes = new ArrayList<String>();
            while (m.find()) {
                int value = Integer.parseInt(m.group());
                if (isPrime(value)) {
                    primes.add(""+value);
                }
            }
            return String.join(", ", primes);
        }
        return "";
    }

    static boolean isPrime(int value) {
        if (value <= 1) 
            return false; 
        for (int i = 2; i < value; i++) 
            if (value % i == 0) 
                return false; 
        return true; 
    }
}
