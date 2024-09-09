package FlexCalc;

// Enum that have the basic operations for the calculator
public enum Operation {
    ADD {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public double calculate(double a, double b) {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
            return a / b;
        }
    },
    UNSUPPORTED {
        @Override
        public double calculate(double num1, double num2) {
            throw new UnsupportedOperationException("Unsupported operation.");
        }
    }, //  adding new operation MODULO to enum. 
    MODULO {
        @Override
        public double calculate(double a, double b) {
            return a % b;
        }
    };

    // Abstract method to be implemented by each enum value
    public abstract double calculate(double a, double b);
}
