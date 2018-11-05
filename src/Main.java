import com.jsontocsv.parser.JsonFlattener;
import com.jsontocsv.writer.CSVWriter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {  
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Insert input json file location: ");
        String jsonFileInput = scanner.next();
        
        System.out.print("Insert output csv file location: ");
        String csvFileOutput = scanner.next();
        
        String content = new String(Files.readAllBytes(Paths.get(jsonFileInput)));
        JsonFlattener parser = new JsonFlattener();
        CSVWriter writer = new CSVWriter();
        List<Map<String, String>> flatJson = parser.parseJson(content);
        writer.writeAsCSV(flatJson, csvFileOutput);
        
        scanner.close();
    }
}
