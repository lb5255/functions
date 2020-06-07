import functions.Constant;
import functions.Function;
import functions.Sum;
import functions.Variable;

/**
 * Test cases that test out part 1 or just constant/variable/sum
 * @author Lea
 */
public class FunctionTest1 {
    public static void main(String[] args) {
        if ( args.length != 0 ) {
            System.err.println( "test_case_1 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;
        Function f = new
                Sum( new Constant( 7 ), var );
        System.out.println( "Function " + f );
        System.out.println( "Value at 0: " + f.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f.evaluate( 10.0 ) );
        System.out.println( "Value at 15: " + f.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + f.derivative() );
        double iResult = 0.0;
        iResult = f.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10: " + iResult );

        System.out.println("\n");

        Function f2 = new Sum( var );
        System.out.println( "Function " + f2 );
        System.out.println( "Value at 0: " + f2.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f2.evaluate( 10.0 ) );
        System.out.println( "Value at 15: " + f2.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + f2.derivative() );
        double iResult2 = 0.0;
        iResult2 = f2.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10: " + iResult2 );

        System.out.println("\n");

        Function f3 = new Sum( new Constant( 6 ), new Constant(42) );
        System.out.println( "Function " + f3 );
        System.out.println( "Value at 0: " + f3.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f3.evaluate( 10.0 ) );
        System.out.println( "Value at 15: " + f3.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + f3.derivative() );
        double iResult3 = 0.0;
        iResult3 = f3.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10: " + iResult3 );

        System.out.println("\n");

        Function f4 = new Sum( var, var, var );
        System.out.println( "Function " + f4 );
        System.out.println( "Value at 0: " + f4.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f4.evaluate( 10.0 ) );
        System.out.println( "Value at 15: " + f4.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + f4.derivative() );
        double iResult4 = 0.0;
        iResult4 = f4.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10: " + iResult4 );

        System.out.println("\n");

        Function f5 = new Sum( var, var, new Constant(34), new Constant( 12));
        System.out.println( "Function " + f5 );
        System.out.println( "Value at 0: " + f5.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f5.evaluate( 10.0 ) );
        System.out.println( "Value at 15: " + f5.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + f5.derivative() );
        double iResult5 = 0.0;
        iResult5 = f5.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10: " + iResult5 );
    }

}
