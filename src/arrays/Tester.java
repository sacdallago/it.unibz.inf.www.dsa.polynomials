package arrays;

public class Tester {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(1, 1);
        p1.addTerm(2, 2);
        p1.addTerm(3, 3);
        p1.print();

        Polynomial p2 = new Polynomial();
        p2.addTerm(1, 1);
        p2.addTerm(2, 2);
        p2.addTerm(3, 3);
        p2.addTerm(4, 4);
        p2.print();

        Polynomial p3 = p1.sum(p2);
        p3.print();

        Polynomial p4 = p1.multiply(p2);
        p4.print();
    }
}
