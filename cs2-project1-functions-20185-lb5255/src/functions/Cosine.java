package functions;

/**
 * This class represents the cosine function
 * @author Lea
 */
public class Cosine extends Function {

    /** A function that will be used with the sine expression */
    private Function fnc;

    /** The constructor takes a function to which the cosine function is to be applied */
    public Cosine(Function fnc){
        this.fnc = fnc;
    }

    /**
     * The evaluation of cosine is simply cosine with a value passed
     * @param n a floating point value of n
     * @return evaluation of cosine
     */
    @Override
    public double evaluate(double n) {
        return Math.cos(n);
    }

    /**
     * The derivative of cosine is -sin so I made a new product that combines
     * a new sine that takes in the function with a new constant -1
     * @return the derivative of cosine: -sinx
     */
    @Override
    public Function derivative() {
        return new Product(new Sine(fnc), new Constant(-1.0));
    }

    /** the string representation of cosine */
    @Override
    public String toString() {
        return "cos(" + fnc.toString() + ")";
    }
}
