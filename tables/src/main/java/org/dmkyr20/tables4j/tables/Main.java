package org.dmkyr20.tables4j.tables;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.dmkyr20.tables4j.tables.exceptions.CellContentException;
import org.dmkyr20.tables4j.tables.templates.borders.CellBorderTemplate;
import org.dmkyr20.tables4j.tables.types.CellPosition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * The main class provided for using the library from cli as jar
 *
 * @author dmkyr20
 */
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

        TableBuilder tableBuilder = readTableFromFile(cmd.getOptionValue("input"));
        String tableAsString = null;
        try {
            tableAsString = tableBuilder.build();
        } catch (CellContentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        String outputFilePath = cmd.getOptionValue("output");

        if (outputFilePath != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
                writer.write(tableAsString);
                writer.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        if (cmd.hasOption("p")) {
            System.out.println(tableAsString);
        }
    }

    private static TableBuilder readTableFromFile(String pathStr) {
        Path input = Paths.get(pathStr);

        TableBuilder tableBuilder = new TableBuilder();

        try (Stream<String> stream = Files.lines(input)) {
            stream.forEach(value -> {
                try {
                    tableBuilder.addCell(parseCell(value));
                } catch (CellContentException e) {
                    System.out.println("Exception during parsing from file: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Exception during reading from file: " + e.getMessage());
        }

        return tableBuilder;
    }

    /**
     * lefTopX leftTopY RightBottomX RightBottomY Content CellBorderTemplate
     * @param cellStr
     */
    private static Cell parseCell(String cellStr) throws CellContentException {
        String[] values = cellStr.split(StringUtils.SPACE);
        CellPosition position = new CellPosition(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1]),
                Integer.parseInt(values[2]),
                Integer.parseInt(values[3]));
        Cell cell = new Cell(position, values[4]);
        cell.setCellBorderStyle(CellBorderTemplate.getBorders(values[5]).getBorderStyle());
        return cell;
    }
}
