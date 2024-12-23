package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.sql.SQLOutput;
import java.text.Format;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "ProjectV 1.0", description = "Compares two configuration files and shows a difference.")

public class App implements Runnable{

    @Parameters(description = "path to first file")
    private File filepath1;

    @Parameters(description = "path to second file")
    private File filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    Format format;

    @Option(names = {"-h", "--help"}, usageHelp = true ,description = "Show this help message and exit.")
    boolean helpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionRequested;


    public static void main(String[] args) throws Exception {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.execute(args);

        var parseResult = new HashMap<String, String>();

        String readFile1Path = "/home/razmik/java-project-71/app/file1.json";
        String readFil2Path = "/home/razmik/java-project-71/app/file2.json";

        Path pathFile1 = Paths.get(readFile1Path).toAbsolutePath().normalize();
        Path pathFile2 = Paths.get(readFil2Path).toAbsolutePath().normalize();

        String contentFile1 = Files.readString(pathFile1);
        parseResult.put(readFile1Path, contentFile1);
        String contentFile2 = Files.readString(pathFile2);
        parseResult.put(readFil2Path, contentFile2);

        System.out.println(parseResult.get(readFile1Path));
        System.out.println(parseResult.get(readFil2Path));


    }

    @Override
    public void run() {
        if (helpRequested) {
            CommandLine.usage(this, System.out);
        }
    }
}
