package history;

import java.time.LocalDateTime;
import java.time.Duration;

public class Operation {
    private final LocalDateTime timestamp;
    private final double firstOperand;
    private final double secondOperand;
    private final String operator;
    private final double result;

    public Operation(LocalDateTime timestamp, double firstOperand, double secondOperand, String operator, double result) {
        this.timestamp = timestamp;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

    public boolean isOlderThan24Hours() {
        return Duration.between(timestamp, LocalDateTime.now()).toHours() > 24;
    }

    @Override
    public String toString() {
        return String.format("%s: %f %s %f = %f", timestamp, firstOperand, operator, secondOperand, result);
    }
}
