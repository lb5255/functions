package functions;

/**
 * This is an abstract class that represents any calculation and is extended
 * by constant, cosine, product, sine, variable and sum
 *
 * @author Lea Boyadjian :)
 */

public abstract class Function {


    /**
     * @param n a floating point value of n
     * @return the value of a function
     */
    public abstract double evaluate(double n);

    /**
     * @return the Function that is the (first) derivative of the function with respect to x.
     */
    public abstract Function derivative();

    /**
     * This is used by Product, Cosine and Sine and finds the integral with a
     * for loop. Inside the loop is an if else statement that takes the first and
     * last value and multiply by 0.5 and for the rest it multiples by delta plus a
     * @param a The lower bound
     * @param b The upper bound
     * @param c the number of trapezoid
     * @return The integral (estimated)
     */
    public double integral(double a, double b, int c){
        double delta = (b-a)/c;
        double result = 0.0;
        for(double i=0; i < c; i++){
            if(i == 0){
                result += (.5 * this.evaluate(a));
            } else if (i == c-1){
                result += (.5 * this.evaluate(b));
            } else {
                result += this.evaluate(a + ((i) * delta));
            }
        }
        return result * delta;
    }

    /** if its a constant or not */
    public boolean isConstant(){
        return false;
    }

    /** The string representation */
    public abstract String toString();
}
