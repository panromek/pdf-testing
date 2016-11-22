package testobjects;

import parsers.Pdf2Text;
import utils.RegularExpressionsFactory;

import java.util.List;
import java.util.regex.Matcher;

public class MoneyMovementObject {
    private static final String CLIENT_NAME_PATTERN = "Client: (?<clientName>.*)";
    private static final String ACCOUNT_NUMBER_PATTERN = "Account number: (?<accountNumber>\\d{2}( \\d{4}){4})";
    private static final String TIME_PERIOD_PATTERN = "Period: (?<fromDate>\\d{1,2}\\/\\d{1,2}\\/\\d{4}) - (" +
            "?<toDate>\\d{1,2}\\/\\d{1,2}\\/\\d{4})";

    private String fileText;

    public MoneyMovementObject(String pathToFile) throws Exception {
        fileText = Pdf2Text.parsePdfToText(pathToFile);
    }

    public String getClientName() {
        List<Matcher> clientNameMatches = RegularExpressionsFactory.getMatchesCollection(fileText, CLIENT_NAME_PATTERN);
        return clientNameMatches.get(0).group("clientName");
    }

    public String getAccountNumber() {
        List<Matcher> accNumMatches = RegularExpressionsFactory.getMatchesCollection(fileText, ACCOUNT_NUMBER_PATTERN);
        return accNumMatches.get(0).group("accountNumber");
    }

    private Matcher getPeriodMatch() {
        List<Matcher> periodMatches = RegularExpressionsFactory.getMatchesCollection(fileText, TIME_PERIOD_PATTERN);
        return periodMatches.get(0);
    }

    public String getPeriodStartDate() {
        return getPeriodMatch().group("fromDate");
    }

    public String getPeriodEndDate() {
        return getPeriodMatch().group("toDate");
    }
}
