package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.text.Format;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "ProjectV 1.0", description = "Compares two configuration files and shows a difference.")

public class App implements Runnable{

    @Parameters(description = "path to first file")
    private File filepath1;

    @Parameters(description = "path to second file")
    private File filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    Format format;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean helpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionRequested;


    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new App());
        cmd.execute(args);
    }

    @Override
    public void run() {
        if (helpRequested) {
            System.out.println("Help message");
            return;
        }
    }
}
