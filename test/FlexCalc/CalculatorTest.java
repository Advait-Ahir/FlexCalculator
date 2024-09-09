package FlexCalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	// test all the basic Calculator operations
	@Test
    public void testBasicOperations() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3));
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 3, 2));
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3));
        assertEquals(2, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

	// test to check for ArithmeticException when dividing by 0
    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 4, 0);
        }, "Cannot divide by zero.");
    }

    // test chaining operations: 5+3 = 8*2 = 16-7 = 9/3 = 3
    @Test
    public void testChainingOperations() {
        Calculator calculator = new Calculator();
        Operation[] ops = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT, Operation.DIVIDE };
        Number[] values = {3, 2, 7, 3};
        assertEquals(3, calculator.chainOperations(5, ops, values)); 
    }
    
    // test for operations not supported by the calculator
    @Test
    public void testUnsupportedOperationWithEnum() {
        Calculator calculator = new Calculator();
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(Operation.UNSUPPORTED, 5, 2);
        }, "Unsupported operation requested.");
    }

    // test for null operation
    @Test
    public void testNullOperation() {
        Calculator calculator = new Calculator();
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 5, 2);
        });
    }
    
    // test new Operation MODULO
    @Test
    public void testModuloOperation() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.calculate(Operation.MODULO, 5, 2));
    }
}
