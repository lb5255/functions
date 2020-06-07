package functions;

/** This class represents constants
 * @author Lea
 */

public class Constant extends Function {

    /** The number that is a constant */
    private double number;

    /** The constructor takes the value as its argument */
    public Constant(double number){
        this.number = number;
    }

    /**
     * This will "evaluate" the constant by just returning it
     */
    @Override
    public double evaluate(double n) {
        return this.number;
    }

    /**
     * The derivative of a constant is zero
     * @return A new constant that passes zero
     */
    @Override
    public Function derivative() {
        Constant zero = new Constant(0.0);
        return zero;
    }

    /**
     * Finds the integral using the trapezoid rule
     * @param a the lower bound
     * @param b the higher bound
     * @param c the number of trapezoids
     * @return the integral
     */
    @Override
    public double integral(double a, double b, int c){
        return (b-a) * this.number;
    }

    /**
     * @return check if its a constant
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /** the string representation of a constant */
    @Override
    public String toString() {
        return this.number + "";
    }
}
