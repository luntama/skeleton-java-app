package com.develogical;

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
        return "";
    }
}
