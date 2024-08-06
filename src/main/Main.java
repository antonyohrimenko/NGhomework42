package main;

import calculator.MathCalculator;
import parser.StringParser;
import printer.ConsolePrinter;
import printer.FilePrinter;
import history.OperationHistory;
import printer.Printer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип вывода (1 - консоль, 2 - файл):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        Printer printer;
        if (choice == 1) {
            printer = new ConsolePrinter();
        } else {
            System.out.println("Введите имя файла для записи:");
            String filename = scanner.nextLine();
            printer = new FilePrinter(filename);
        }

        OperationHistory operationHistory = new OperationHistory();
        MathCalculator mathCalculator = new MathCalculator(printer, operationHistory);
        StringParser stringParser = new StringParser(mathCalculator, scanner);

        stringParser.parse();

        System.out.println("История операций:");
        System.out.println(operationHistory);

        scanner.close();
    }
}
