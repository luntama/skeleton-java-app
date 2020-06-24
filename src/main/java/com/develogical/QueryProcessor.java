package com.develogical;


public class QueryProcessor {

// which of the following numbers is the largest: 67, 299
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
        return "";
    }
}
