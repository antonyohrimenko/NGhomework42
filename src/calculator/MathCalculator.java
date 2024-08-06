package calculator;

import history.Operation;
import history.OperationHistory;
import operator.Operator;
import printer.Printer;

import java.time.LocalDateTime;

public class MathCalculator implements Calculator {

    private final Printer printer;
    private final OperationHistory operationHistory;

    public MathCalculator(Printer printer, OperationHistory operationHistory) {
        this.printer = printer;
        this.operationHistory = operationHistory;
    }

    @Override
    public void calculate(double first, double second, Operator operator) {
        double result = 0.0;

        switch (operator) {
            case SUM -> result = first + second;
            case SUBTRACTION -> result = first - second;
            case DIVIDE -> result = first / second;
            case MULTIPLY -> result = first * second;
        }

        printer.print(result);
        Operation operation = new Operation(LocalDateTime.now(), first, second, operator.name(), result);
        operationHistory.addOperation(operation);
    }
}