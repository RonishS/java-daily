// Exceptions
/* 
 * Exceptions are the events that disrupt the normal flow of program during execution
 * 
 * Types of Exceptions 
 * Checked / Compile-time Exception 
 * Unchecked / Runtime Exception
 * 
 * Exception Handling Keywords
 * try
 * catch
 * finally
 * throw
 * throws
 */

// Exception Example
public class Exceptions {

    // This will cause ArithmeticException at runtime
    int a = 10 / 0;

    public static void main(String[] args) {

        // Exception Handling using try-catch
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("cannot divide by 0");
        }

        // Exception Handling for Multiple Catch Blocks
        try {
            int[] arr = new int[5];
            arr[10] = 20;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }

        // try-catch-finally example
        try {
            int x = 10 / 2;
        } catch (Exception e) {
            System.out.println("Error occurred");
        } finally {
            System.out.println("Always executed");
        }
    }
}

// Throw vs throws

// throw
/* 
 * used to explicitly throw an exception
 * used inside method
 * throws one exception
 */

// throws
/* 
 * used to declare exceptions
 * used in method signature
 * can declare multiple exceptions
 */

// custom exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}
