package parsers;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;

import java.io.File;
import java.io.FileWriter;

public class Pdf2Text {

    public static String parsePdfToText(String pdfFilePath) throws Exception {
        Document pdf = PDF.open(pdfFilePath);
        StringBuilder text = new StringBuilder(1024);
        pdf.pipe(new OutputTarget(text));
        pdf.close();
        return text.toString().replaceAll("\\s{2,}", " ").replaceAll("\\u00AD", "-");
    }

    public static void convertPdfToTextFile(String pathToPdtFile, String textFileName) throws Exception {
        File file = new File("./src/main/resources/results/" + textFileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(parsePdfToText(pathToPdtFile));
        fileWriter.flush();
        fileWriter.close();
    }

}