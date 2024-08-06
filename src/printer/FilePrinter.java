package printer;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private final String filename;

    public FilePrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(double result) {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write(String.format("Ваш результат равен: %.2f%n", result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
