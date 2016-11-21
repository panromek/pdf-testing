package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsFactory {

    public static List<Matcher> getMatchesList(String inputText, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputText);
        List<Matcher> matchesList = new ArrayList<Matcher>();
        while (matcher.find()) {
            MatchResult result = matcher.toMatchResult();
            Matcher transformedResult = (Matcher)result;
            matchesList.add(transformedResult);
        }

        return matchesList;
    }

}
