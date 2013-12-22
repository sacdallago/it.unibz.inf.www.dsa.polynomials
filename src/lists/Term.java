
package lists;

public class Term {
    int constant = 1;
    int exponent = 0;
    Term next = null;
    
    /**
     * A 'Term' is one part of the polynomial.
     * One term is usalli represented as a*x^b,
     * where a also contains the sign of the term!
     * 
     * @param a the constant term.
     * @param b the exponent of x.
     */
    Term(int a, int b) {
        constant = a;
        exponent = b;
    }
}
