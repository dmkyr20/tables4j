# Java-Cli-Table-Builder
Thank you for choosing Java-Cli-Table-Builder - an **easy** to use **command-line interface** tool.

## Overview
Java-Cli-Table-Builder makes it easy to create flexible command-line tables. 
You haven't need to write your classes and methods to decorate console output anymore.
Just use this flexible tool for positioning.

### Examples
#### Example 1
**Creating simple CLI game interface.**<br>
You haven't need make formatting output by yourself anymore. Use already created methods for creating independent 
blocks on screen.
##### Code
```
public void simpleOutput() throws CellContentException {
    TableBuilder tableBuilder = new TableBuilder();
    tableBuilder.setDefaultCellBorderStyle(CellBorderTemplate.SOLID.getBorderStyle());

    tableBuilder.addCell(HEADER, new CellPosition(0, 0, 100, 12));
    tableBuilder.addCell("1 - Start", new CellPosition(0, 12, 25, 15));
    tableBuilder.addCell("2 - Load", new CellPosition(25, 12, 50, 15));
    tableBuilder.addCell("5 - Settings", new CellPosition(50, 12, 75, 15));
    tableBuilder.addCell("6 - Exit", new CellPosition(75, 12, 100, 15));

    tableBuilder.print();
}
```
##### Output
```
┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                                                                                  │
│                                                                                                  │
│                                                                                                  │
│                             █▀▀ █░░ ░▀░         █▀▀▀ █▀▀█ █▀▄▀█ █▀▀                              │
│                             █░░ █░░ ▀█▀         █░▀█ █▄▄█ █░▀░█ █▀▀                              │
│                             ▀▀▀ ▀▀▀ ▀▀▀         ▀▀▀▀ ▀░░▀ ▀░░░▀ ▀▀▀                              │
│                                                                                                  │
│                                                                                                  │
│                                                                                                  │
│                                                                                                  │
└──────────────────────────────────────────────────────────────────────────────────────────────────┘
┌───────────────────────┐┌───────────────────────┐┌───────────────────────┐┌───────────────────────┐
│       1 - Start       ││       2 - Load        ││     5 - Settings      ││       6 - Exit        │
└───────────────────────┘└───────────────────────┘└───────────────────────┘└───────────────────────┘
```
#### Example 2
**Easy and fast changes in any completed output.**<br>
You can add a block of content in any place on screen. You shouldn't care about previously created content anymore.
##### Code
```
public void simpleOutputWithNote() throws CellContentException {
    TableBuilder tableBuilder = new TableBuilder();
    tableBuilder.setDefaultCellBorderStyle(CellBorderTemplate.SOLID.getBorderStyle());

    tableBuilder.addCell(HEADER, new CellPosition(0, 0, 100, 12));
    tableBuilder.addCell("1 - Start", new CellPosition(0, 12, 25, 15));
    tableBuilder.addCell("2 - Load", new CellPosition(25, 12, 50, 15));
    tableBuilder.addCell("5 - Settings", new CellPosition(50, 12, 75, 15));
    tableBuilder.addCell("6 - Exit", new CellPosition(75, 12, 100, 15));

    Cell note = new Cell(new CellPosition(1, 8, 90, 11), NOTE);
    note.setCellBorderStyle(CellBorderTemplate.NO_BORDERS.getBorderStyle());
    note.setHorizontalAlignment(CellHorizontalAlignment.LEFT);
    tableBuilder.addCell(note);

    tableBuilder.print();
}
```
##### Output
```   
┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                                                                                  │
│                                                                                                  │
│                                                                                                  │
│                             █▀▀ █░░ ░▀░         █▀▀▀ █▀▀█ █▀▄▀█ █▀▀                              │
│                             █░░ █░░ ▀█▀         █░▀█ █▄▄█ █░▀░█ █▀▀                              │
│                             ▀▀▀ ▀▀▀ ▀▀▀         ▀▀▀▀ ▀░░▀ ▀░░░▀ ▀▀▀                              │
│                                                                                                  │
│                                                                                                  │
│ Note: Pres number key to choose.                                                                 │
│                                                                                                  │
└──────────────────────────────────────────────────────────────────────────────────────────────────┘
┌───────────────────────┐┌───────────────────────┐┌───────────────────────┐┌───────────────────────┐
│       1 - Start       ││       2 - Load        ││     5 - Settings      ││       6 - Exit        │
└───────────────────────┘└───────────────────────┘└───────────────────────┘└───────────────────────┘
```

### Requirements
* Java 11 JDK or later.
> You can use Java 8, but you must change the version of project in project configuration and rebuild it. 

## How to start?
You can use the library as ```.jar``` file. Or run it using the CLI as executable ```.jar``` file.<br>
Copy the project. Then go to a folder with project and run ```maven``` ```mvn clean compile assembly:single``` command.
Ready to use ```.jar``` file located in ```target``` folder.

## Documentation
You could find all documentation for project in JavaDoc.<br>
Or in [Documentation](https://github.com/dmkyr20/Java-Cli-Table-Builder/wiki). (Not Allowed yet)

## License
Distributed under the MIT License. See LICENSE for more information.