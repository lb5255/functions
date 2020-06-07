package functions;

/**
 * This class represents the sine function
 * @author Lea
 */

public class Sine extends Function {

    /** A function that will be used with the sine expression */
    private Function fnc;

    /** The constructor takes a function to which the sine function is to be applied */
    public Sine(Function fnc){
        this.fnc = fnc;
    }

    /**
     * The evaluation of sine is simply sin with a value passed
     * @param n a floating point value of n
     * @return evaluation of sin
     */
    @Override
    public double evaluate(double n) {
        return Math.sin(n);
    }

    /**
     * The derivative of sine is just cosine
     * @return a new cosine that takes in the function
     */
    @Override
    public Function derivative() {
        return new Cosine(fnc);
    }

    /** the string representation of sine */
    @Override
    public String toString() {
        return "sin(" + fnc.toString() + ")" ;
    }
}