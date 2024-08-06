package history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationHistory {
    private final List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
        cleanOldOperations();
    }

    private void cleanOldOperations() {
        operations.removeIf(Operation::isOlderThan24Hours);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return operations.stream()
                .map(Operation::toString)
                .collect(Collectors.joining("\n"));
    }
}
