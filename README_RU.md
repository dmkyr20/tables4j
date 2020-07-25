# Java-Cli-Table-Builder
Благодарим за выбор **Java-Cli-Table-Builder** – **удобная и простая** система для оформления **консольного вывода**.

[![GitHub license](https://img.shields.io/github/license/dmkyr20/Java-Cli-Table-Builder)](https://github.com/dmkyr20/Java-Cli-Table-Builder/blob/master/LICENSE)
[![GitHub release](https://img.shields.io/github/v/release/dmkyr20/Java-Cli-Table-Builder)]()

Java-Cli-Table-builder позволяет легко и быстро создавать гибкие консольные интерфейсы. Вам больше не нужно писать 
собственные классы и методы для оформления консольного вывода. Просто используйте гибкий инструмент позиционирования
контента на доске.
### Примеры использования
#### Пример 1
**Создание простого игрового интерфейса.**<br>
Больше вам не нужно самим реализовывать декоративный вывод на консоль. Просто используйте уже готовые методы для 
создания независимых блоков на экране.
##### Код
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
##### Вывод
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
#### Пример 2
**Быстрая и легкая модификация полученного результата.**<br>
Вы можете добавить блок в любом месте на экране. Модифицируя уже полученную таблицу. Больше вам не нужно переписывать
и пересчитывать весь контент с учетом нового. Просто добавьте новый независимый блок.
##### Код
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
##### Вывод
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
## Требования
* Java 8 JDK или выше.

## Начало работы
Для начала работы вы можете использовать библиотеку в формате ```.jar``` или запустить файл через консоль передав 
необходимые параметры.<br>
Для начала работы скопируйте проект. После чего перейдите в папку с проектом и соберите пакет с помощью ```maven```.
Запустите команду: ```mvn clean compile assembly:single```. Готовый к использованию ```.jar``` файл находиться в папке
```target```.

Или включите его, используя  ```maven```:
```
<dependency>
  <groupId>org.dmkyr20.Java-Cli-Table-Builder</groupId>
  <artifactId>java-cli-table-builder</artifactId>
  <version>1.0.2</version>
</dependency> 
```
Затем:
```mvn install```
> См. [Package](https://github.com/dmkyr20/Java-Cli-Table-Builder/packages/328302). 

## Документация
Полная документация находиться в JavaDoc самого проекта.
Или в [Documentation](https://github.com/dmkyr20/Java-Cli-Table-Builder/wiki). (Not Allowed yet)

## Лицензия
Этот проект лицензирован по лицензии MIT - подробности см. В файле LICENSE.md
