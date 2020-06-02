package org.dmkyr20.cli.table;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {
        Options commandLineOptions = new Options();
        Option input = new Option("i", "input", true, "input file path");
        Option output = new Option ("o", "output", true, "output file");
        Option print = new Option ("p", "print", false, "print output to console");
        input.setRequired(true);
        commandLineOptions.addOption(input);
        commandLineOptions.addOption(output);
        commandLineOptions.addOption(print);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(commandLineOptions, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", commandLineOptions);

            System.exit(1);
        }

        String inputFilePath = cmd.getOptionValue("input");
        String outputFilePath = cmd.getOptionValue("output");

        System.out.println(inputFilePath);
        System.out.println(outputFilePath);
    }
}
