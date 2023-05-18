import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StringToCsvConverter {
    public static void csvBuilder(String result) {
        String inputString =result;
        String filename = "output.csv";
        saveToCsv(inputString, filename);
        System.out.println("CSV file saved successfully.");
    }

    private static void saveToCsv(String inputString, String filename) {
        try (Writer writer = new FileWriter(filename);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

            String[] values = inputString.split(",");
            csvPrinter.printRecord((Object[]) values);

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
