package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsHelper {

    public static List<Matcher> getMatchesList(String inputText, String regExp) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(inputText);
        List<Matcher> matchesList = new ArrayList<Matcher>();
        while (m.find()) {
            MatchResult res = m.toMatchResult();
            Matcher transformedResult = (Matcher)res;
            matchesList.add(transformedResult);
        }

        return matchesList;
    }

}
