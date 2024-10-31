package KI304.Kozak.Lab5;

/**
 * Exception class for infinity, used for equations
 */
public class InfinityException extends ArithmeticException {
    public InfinityException() {
        super("Value reach infinity");
    }
}
