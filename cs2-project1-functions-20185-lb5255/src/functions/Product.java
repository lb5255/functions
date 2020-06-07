package functions;
import java.util.ArrayList;

/**
 * This class represents the product which is in charge of multiplying
 * whatever that is passed
 * @author Lea
 */

public class Product extends Function{

    /** An argument list of function*/
    private Function[] terms;

    /**
     * This constructor is similar to Sum's constructor but if they all multiply to 0,
     * then it will be changed into a single Constant factor 0.
     */
    public Product(Function ... sequence){

        ArrayList<Function> result = new ArrayList();
        double if_constant = 1.0;
        for(int i= 0; i < sequence.length; i++) {
            Function fun = sequence[i];
            if (fun.isConstant()) {
                if_constant *= fun.evaluate(1);
            } else {
                result.add(fun);
            }
        }
        if (if_constant == 0.0){
            Constant zero = new Constant(0.0);
            result.clear();
            result.add(zero);
        } else if(if_constant != 1.0){
            result.add(new Constant(if_constant));
        } else if(result.size() == 0){
            Constant zero = new Constant(0.0);
            result.add(zero);
        }
        terms = result.toArray(new Function[0]);
    }

    /**
     * This function takes in the product function
     * and evaluate each variables and then combine them
     * @param n a floating point value of n
     * @return the combination of alike variables
     */
    @Override
    public double evaluate(double n) {
        double eval = 1.0;
        for (int i= 0; i < terms.length; i++ ){
            double check = terms[i].evaluate(n);
            if(check == 0){
                return 0;
            } else{
                eval *= terms[i].evaluate(n);
            }
        }
        return eval;
    }

    /**
     * The derivative of a function that has a product requires the use of
     * product rule. The rule consist of taking the derivative of f and multiplying
     * it with g and then add it with the derivative of g and multiplying with f.
     * This is done recursively.
     * @return The derivative of a product function
     */
    @Override
    public Function derivative() {
        if(terms.length == 1){
            return terms[0].derivative();
        } else{
            Function[] newarray = new Function[terms.length-1];
            for (int i= 1; i < terms.length; i++ ){
                newarray[i-1] = terms[i];
            }
            Function newfunction = new Product(newarray);
            Product product1 = new Product(terms[0], newfunction.derivative());
            Product product2 = new Product(newfunction, terms[0].derivative());
            return new Sum(product1,product2);
        }
    }

    /**
     * Checks if the product function is constant by going through each
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

    /** The string representation of product */
    @Override
    public String toString(){
        String ultimate = "( " + terms[0];
        for(int i= 1; i < terms.length; i++){
            ultimate += " * " + terms[i].toString();
        }
        return ultimate + " )";
    }
}