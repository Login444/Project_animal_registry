package org.example.view;

import org.example.animals.Comand;
import org.example.animals.abstractAnimals.Animal;
import org.example.animals.abstractAnimals.AnimalType;
import org.example.controller.Controller;
import org.example.counter.Counter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements View {
    public static final int SIZE_LINE = 80;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ROW_FORMAT = "%-6d%-16s%-20s%-20d%-20s";
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-16s%-20s%-20s%-20s";
    public static final String RED_COLOR = "\u001B[31m";
    public static final String GREEN_COLOR = "\u001B[32m";
    private final Controller controller;
    private Scanner scanner;

    public ConsoleView(Controller controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    record AnimalData(String name, LocalDate date_of_birth, AnimalType animalType){}

    @Override
    public void showStorage() {
        clearConsole();
        printLineWithSymbol("=", SIZE_LINE);
        printCaption("Питомник животных (Демо версия)", " ");
        printLineWithSymbol("=", SIZE_LINE);
        printRegistryHeader();
        printLineWithSymbol("-", SIZE_LINE);

        ArrayList<Animal> animals = controller.getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            var item = animals.get(i);
            String row = String.format(ROW_FORMAT, i + 1, item.getName(), item.getBirthDateAsString(), item.getAge(),
                    item.getAnimalType().getTitle());
            printLine(row);
        }
        printLineWithSymbol("-", SIZE_LINE);
    }


    @Override
    public MainMenu showMainMenuWithResult() {
        String menu = String.format(
                "%d-[%s]\t%d-[%s]\t%d-[%s]\t%d-[%s]\n",
                MainMenu.ADD_ANIMAL.ordinal(),
                MainMenu.ADD_ANIMAL.getTag(),
                MainMenu.SHOW_COMANDS.ordinal(),
                MainMenu.SHOW_COMANDS.getTag(),
                MainMenu.EXIT.ordinal(),
                MainMenu.EXIT.getTag());
        printLineWithSymbol("=", SIZE_LINE);
        printColorLine("Доступные действия:", GREEN_COLOR);
        printColorLine(menu, GREEN_COLOR);
        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Выберите действие: ", MainMenu.ADD_ANIMAL.ordinal(),
                        MainMenu.EXIT.ordinal());
                scanner = new Scanner(System.in);
                return MainMenu.values()[scanner.nextInt()];
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                printColorLine("Некоректное действие!", RED_COLOR);
            }
        }
    }

    @Override
    public boolean showAddAnimalDiaog() {
        String infoMessage = "Введите параметры животного в виде строки: \"имя день_рождения род_животного\"\n" +
                "день_рождения имеет вид: dd-mm-yyyy (12-03-2022): \n" +
                "род_животного может принимать значения: " + Arrays.asList(AnimalType.values());
        System.out.println(infoMessage);
        while (true) {
            Counter counter = new Counter();
            try (counter){
                System.out.print("Ввод: ");
                scanner = new Scanner(System.in);
                String inputData = scanner.nextLine();
                AnimalData parsedData = parceAnimalData(inputData);
                counter.add();
                return controller.createAnimal(parsedData.name, parsedData.date_of_birth, parsedData.animalType);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты рождения");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private AnimalData parceAnimalData(String inputData) {
        String[] input = inputData.split(" ");

        if (input.length < 3) {
            throw new IllegalArgumentException("Недостаточное количество данных");
        }
        if (input.length > 3) {
            throw new IllegalArgumentException("Слишком много данных");
        }
        String animalName = input[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDay = LocalDate.parse(input[1], formatter);
        AnimalType genius = AnimalType.valueOf(input[2].toUpperCase());
        return new AnimalData(animalName, birthDay, genius);
    }

    @Override
    public void showDetailInfoAnimalDialog() {
        String infoMessage = String.format("Введите номер животного (1 - %d)", controller.getAnimals().size());
        System.out.println(infoMessage);
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int animalNumber = scanner.nextInt();
                Animal animal = controller.getAnimals().get(animalNumber - 1);
                showAnimalInfo(animal);

                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Запись с таким номером отсутствует");
            }
        }
    }

    @Override
    public void showAnimalInfo(Animal animal) {
        while (true) {
            printAnimalInfo(animal);
            AddComandMenu code = showAddComandMenu(animal);
            switch (code) {
                case ADD_COMAND -> {
                    boolean result = showAddComandDialog(animal);
                    String resMessage = result ? "Команда добавлена" : "Ошибка при добавлении команды";
                    System.out.println(resMessage);
                    if (!result) return;
                }
                case EXIT -> {
                    return;
                }
            }
        }
    }

    private void printAnimalInfo(Animal animal) {
        clearConsole();
        printCaption("Detail info", "~");
        System.out.printf("Род животного: %s\n", animal.getAnimalType().getTitle());
        System.out.printf("Имя: %s\n", animal.getName());
        System.out.printf("Дата рождения: %s\n", animal.getBirthDateAsString());
        System.out.printf("Возраст (в месяцах): %d\n", animal.getAge());
        System.out.printf("Умения: %s\n", animal.getComands());
        printLineWithSymbol("~", SIZE_LINE);
    }

    @Override
    public AddComandMenu showAddComandMenu(Animal animal) {
        String menu = String.format(
                "%d-[%s]\t%d-[%s]\n",
                AddComandMenu.ADD_COMAND.ordinal(), AddComandMenu.ADD_COMAND.getTag(),
                AddComandMenu.EXIT.ordinal(), AddComandMenu.EXIT.getTag()) ;
        printLineWithSymbol("=", SIZE_LINE);
        printColorLine("Доступные действия:", GREEN_COLOR);
        printColorLine(menu, GREEN_COLOR);
        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Выберите действие: ", AddComandMenu.ADD_COMAND.ordinal(),
                        AddComandMenu.EXIT.ordinal());
                scanner = new Scanner(System.in);
                return AddComandMenu.values()[scanner.nextInt()];
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                printColorLine("Некоректное действие!", RED_COLOR);
            }
        }
    }

    @Override
    public boolean showAddComandDialog(Animal animal) {
        System.out.println("Введите данные в виде \"команда <:описание>\"");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isBlank()) return false;
        String[] comandData = input.split(":");
        if (comandData.length == 1) {
            animal.learnComand(new Comand(comandData[0]));
        } else if (comandData.length == 2) {
            animal.learnComand(new Comand(comandData[0], comandData[1]));
        } else {
            System.out.println("Слишком много параметров");
            return false;
        }
        return true;
    }

    private void clearConsole() {
        System.out.print("\033[H\033[J");
    }

    private void printLineWithSymbol(String symbol, int sizeLine) {
        System.out.println(symbol.repeat(sizeLine));
    }

    private void printCaption(String caption, String padSymb) {
        int spaceSize = (SIZE_LINE - caption.length()) / 2;
        String captionLine = padSymb.repeat(spaceSize) + caption + padSymb.repeat(spaceSize);
        System.out.println(captionLine);
    }

    private void printRegistryHeader() {
        String header = String.format(COLUMN_HEADER_FORMAT, "№", "Имя", "Дата рождения", "Возраст(в месяцах)",
                "Род животного");
        System.out.println(header);
    }

    private void printLine(String row) {
        System.out.printf("%s\n", row);
    }

    private void printColorLine(String row, String displayColor) {
        System.out.printf("%s%s%s\n", displayColor, row, ANSI_RESET);
    }
}
