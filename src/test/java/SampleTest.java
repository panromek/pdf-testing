import org.testng.annotations.Test;
import parsers.Pdf2Html;
import parsers.Pdf2Text;
import testobjects.MoneyMovementObject;
import static org.testng.Assert.*;

public class SampleTest {

    @Test
    public void parseToHtmlExample() throws Exception {
        System.out.println("Printing PDF to HTML...");
        Pdf2Html.convertPdfToHtmlFile("./src/main/resources/files/SampleFile.pdf", "htmlFileSample.html");
    }

    @Test
    public void parseToTextExample() throws Exception {
        System.out.println("Printing PDF to text...");
        Pdf2Text.convertPdfToTextFile("./src/main/resources/files/SampleFile.pdf", "textFileSample.txt");
    }

    @Test
    public void sampleTest() throws Exception {
        // input values
        String pathToReport = "./src/main/resources/files/SampleFile.pdf";

        //expected data
        String expectedClient = "Client Name";
        String expectedAccNum = "00 1111 2222 3333 4444";
        String expectedPeriodStart = "9/1/2016";
        String expectedPeriodEnd = "31/10/2016";

        // PDF file retrieval
        MoneyMovementObject reportObject = new MoneyMovementObject(pathToReport);

        // PDF processing
        String actualClient = reportObject.getClientName();
        String actualAccNum = reportObject.getAccountNumber();
        String actualPeriodStart = reportObject.getPeriodStartDate();
        String actualPeriodEnd = reportObject.getPeriodEndDate();

        // validation
        assertEquals(actualClient, expectedClient, "Verify client name");
        assertEquals(actualAccNum,  expectedAccNum, "Verify account number");
        assertEquals(actualPeriodStart, expectedPeriodStart, "Verify start date for transactions");
        assertEquals(actualPeriodEnd, expectedPeriodEnd, "Verify end date for transactions");
    }

}
