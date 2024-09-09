package FlexCalc;

public class Calculator {

    public double calculate(Operation op, Number num1, Number num2) {
    	if (op == null) {
            throw new UnsupportedOperationException("Operation not supported.");
        }
        return op.calculate(num1.doubleValue(), num2.doubleValue());
    }

    public double chainOperations(double initialValue, Operation[] operations, Number[] values) {
        double result = initialValue;
        for (int i = 0; i < operations.length; i++) {
            result = calculate(operations[i], result, values[i]);
        }
        return result;
    }
}

