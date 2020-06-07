import functions.*;

/**
 * Test cases that test out everything
 * @author Lea
 */
public class FunctionTest2 {
    public static void main( String[] args ){

    int argLen = args.length;
    Variable var = Variable.X;
    Function f = new
            Product( new Sine(var));
        System.out.println( "Function " + f );
        System.out.println( "Value at 0: " + f.evaluate( 0.0 ) );
        for ( int i = 0; i < argLen; ++i ) {
        double value = Double.parseDouble( args[ i ] );
        System.out.println( "Value at " + value + ": " +
                f.evaluate( value ) );
    }
        System.out.println( "Derivative: " + f.derivative() );
        System.out.println( "Integral from 0 to 10: " +
                f.integral( 0.0, 10.0, 1000000 ) );

        System.out.println("\n");

        Function f2 = new
                Product( new Cosine(var));
        System.out.println( "Function " + f2 );
        System.out.println( "Value at 0: " + f2.evaluate( 0.0 ) );
        for ( int i = 0; i < argLen; ++i ) {
            double value = Double.parseDouble( args[ i ] );
            System.out.println( "Value at " + value + ": " +
                    f2.evaluate( value ) );
        }
        System.out.println( "Derivative: " + f2.derivative() );
        System.out.println( "Integral from 0 to 10: " +
                f2.integral( 0.0, 10.0, 1000000 ) );

        System.out.println("\n");

        Function f3 = new
                Product( new Product( Variable.X, Variable.X ),
                new Cosine( new Product( new Constant(2), Variable.X ) ),
                new Constant( 7 ));
        System.out.println( "Function " + f3 );
        System.out.println( "Value at 0: " + f3.evaluate( 0.0 ) );
        for ( int i = 0; i < argLen; ++i ) {
            double value = Double.parseDouble( args[ i ] );
            System.out.println( "Value at " + value + ": " +
                    f3.evaluate( value ) );
        }
        System.out.println( "Derivative: " + f3.derivative() );
        System.out.println( "Integral from 0 to 10: " +
                f3.integral( 0.0, 10.0, 1000000 ) );

        System.out.println("\n");

        Function f4 = new Product(new Sine(new Cosine(var)));
        System.out.println( "Function " + f4 );
        System.out.println( "Value at 0: " + f4.evaluate( 0.0 ) );
        for ( int i = 0; i < argLen; ++i ) {
            double value = Double.parseDouble( args[ i ] );
            System.out.println( "Value at " + value + ": " +
                    f4.evaluate( value ) );
        }
        System.out.println( "Derivative: " + f4.derivative() );
        System.out.println( "Integral from 0 to 10: " +
                f4.integral( 0.0, 10.0, 1000000 ) );

        System.out.println("\n");

        Function f5 = new Product(new Cosine(var), new Constant(0), new Sine(new Product(var, new Constant(2))));
        System.out.println( "Function " + f5 );
        System.out.println( "Value at 0: " + f5.evaluate( 0.0 ) );
        for ( int i = 0; i < argLen; ++i ) {
            double value = Double.parseDouble( args[ i ] );
            System.out.println( "Value at " + value + ": " +
                    f5.evaluate( value ) );
        }
        System.out.println( "Derivative: " + f5.derivative() );
        System.out.println( "Integral from 0 to 10: " +
                f5.integral( 0.0, 10.0, 1000000 ) );
    }

}
