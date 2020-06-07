package functions;

import java.util.ArrayList;

/**
 * This class represents the sum of a function that is passed
 * @author Lea
 */

public class Sum extends Function{

    /** An argument list of function*/
    private Function[] terms;

    /**
     * The constructor takes an argument list of functions to be added together.
     * The constructor also adds constants together and clears out the function of extra
     * zeros.
     */
    public Sum(Function ... sequence){

        ArrayList<Function> result = new ArrayList();
        double if_constant = 0.0;
        for(int i= 0; i < sequence.length; i++){
            Function fun = sequence[i];
            if(fun.isConstant()){
                if_constant += fun.evaluate(0);
            }
            else {
                 result.add(fun);
            }
        }
        if(result.size() == 0 || if_constant != 0.0){
            result.add(new Constant(if_constant));
        }
        terms = result.toArray(new Function[0]);
    }

    /**
     * This function takes in the sum function
     * and evaluate each variables and then combine them
     * @param n a floating point value of n
     * @return the combination of alike variables
     */
    @Override
    public double evaluate(double n) {
        double eval = 0.0;
        for (int i = 0; i < terms.length; i++) {
            Function function = terms[i];
            eval += function.evaluate(n);
        }
        return eval;
    }

    /**
     * The derivative of a sum is the sum of the derivatives.
     * @return the total derivative
     */
    @Override
    public Function derivative() {
        Function [] ultimate = new Function[terms.length];
        for(int i= 0; i < terms.length ; i++ ){
            Function func = terms[i];
            ultimate[i] = func.derivative();
        }
        return new Sum(ultimate);
    }

    /**
     * The integral of sum is the sum of the integrals
     * @param a The lower bound
     * @param b The upper bound
     * @param c the number of trapezoid
     * @return the total integral
     */
    @Override
    public double integral(double a, double b, int c) {
        double total = 0.0;
        for(int i= 0; i < terms.length ; i++ ){
            Function fnc = terms[i];
            total += fnc.integral(a,b,c);
        }
        return total;
    }

    /**
     * Checks if the sum function is constant by going through each
     * variable in the function and checking
     * @return if its a constant or not
     */
    @Override
    public boolean isConstant() {
        if(terms.length == 0){
            return false;
        }
        for (int i= 0; i < terms.length; i++ ){
            if(!terms[i].isConstant()){
                return false;
            }
        }
        return true;
    }

    /** The string representation of sum */
    @Override
    public String toString() {
        String ultimate = " ( " + terms[0];
        for (int i = 1; i < terms.length; i++) {
            ultimate += " + " + terms[i].toString();
        }
        return ultimate + " )";
    }
}
