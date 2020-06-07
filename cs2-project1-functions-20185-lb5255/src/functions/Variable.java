package functions;

/**
 * This class represents variable
 * @author Lea
 */
public class Variable extends Function{

    /** variable will always be represented by x */
    public final static Variable X = new Variable();

    /** The constructor takes no argument, since the only variable allowed is x. */
    private Variable(){ }

    /**
     * @param n a floating point value of n
     * @return the value passed
     */
    @Override
    public double evaluate(double n) {
        return n;
    }

    /**
     * @return a new constant that passes one because the derivative of a variable is just one
     */
    @Override
    public Function derivative() {
        Constant one = new Constant(1.0);
        return one;
    }

    /**
     * The integral of x is x^2/2. Within the context of trapezoidal rule
     * the bounds a and b will be substituted thus the bounds are raised
     * to the second power and then multiplied by 0.5
     * @param a the lower bound
     * @param b the upper bound
     * @param c the number of trapezoid
     * @return the integral of x
     */
    @Override
    public double integral(double a, double b, int c) {
        double double_b = Math.pow(b,2);
        double double_a =  Math.pow(a,2);
        return 0.5 * (double_b - double_a);
    }

    /** The string representation of variable */
    @Override
    public String toString() {
        return "x";
    }
}
