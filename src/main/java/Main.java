import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String imagePath = "/home/hercules/IdeaProjects/OCRJava/src/main/resources/challanImages/invoice2.jpg";
        Tesseract tesseract = new Tesseract();
        try {
            String result = tesseract.doOCR(new File(imagePath));
            StringToCsvConverter.csvBuilder(result);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println("OCR Error: " + e.getMessage());
        }
    }
}
