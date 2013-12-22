package lists;

public class Tester {

    public static void main(String[] args) {
        Polynomial polynom1 = new Polynomial();

        polynom1.addTerm(4, 9);
        polynom1.addTerm(1, 3);  //THIS
        polynom1.addTerm(9, 8);  //THIS
        polynom1.addTerm(5, 11);
        polynom1.addTerm(3, 14);

        polynom1.print();

        Polynomial polynom2 = new Polynomial();

        polynom2.addTerm(3, 6);
        polynom2.addTerm(7, 2);
        polynom2.addTerm(12, 0);
        polynom2.addTerm(8, 8);  //THIS
        polynom2.addTerm(1, 1);
        polynom2.addTerm(6, 3);  //THIS
        polynom2.addTerm(2, 7);

        polynom2.print();

        Polynomial result = polynom2.summed(polynom1);

        System.out.println("");

        result.print();
        //polynom1.print();  //Uncomment this to verify that the original polynomials have not been changed
        //polynom2.print();  //Uncomment this to verify that the original polynomials have not been changed

        result = polynom2.multiply(polynom1);

        System.out.println("");

        result.print();
    }
}
