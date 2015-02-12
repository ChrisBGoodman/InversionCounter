package InversionCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {

    /**
     * Load a source from its file
     * @param fileLocation File location
     * @return A filled source
     */
    public static Source getSourceFromFile(String fileLocation) {
        Source source = new Source(new ArrayList<Page>());
        File input = new File(fileLocation);
        try {
            Scanner scanner = new Scanner(input);
            int i = 0;
            while(scanner.hasNext()) {
                source.addPage(new Page(++i, scanner.nextInt()));
            }
            System.out.println("Loading complete!\n");
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + fileLocation + "\" could not be found");
            e.printStackTrace();
        }
        return source;
    }
}
