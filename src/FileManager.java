import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void ReadProccessesFile(String filePath, ArrayList<Process> processesList)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                String[] processInfo = line.split(",");
                processesList.add(new Process(processInfo[0], Integer.parseInt(processInfo[1]), Integer.parseInt(processInfo[2])));
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
