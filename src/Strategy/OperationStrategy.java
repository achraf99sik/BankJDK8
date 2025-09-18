package Strategy;

import Model.Operation;

import java.util.Scanner;

public interface OperationStrategy {
    Operation executeOperation(Scanner input);
}
