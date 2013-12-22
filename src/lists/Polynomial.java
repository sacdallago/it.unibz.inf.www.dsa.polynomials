package lists;

public class Polynomial {

    Term current = null;
    Term root = null;
    int counter = 0;

    public Polynomial() {
        // Sets current, root to null and counter to 0
    }

    /**
     * A 'Term' is one part of the polynomial. One term is usalli represented as
     * a*x^b, where a also contains the sign of the term!
     *
     * @param a the constant term.
     * @param b the exponent of x.
     */
    public void addTerm(int a, int b) {

        Term temp = new Term(a, b);

        if (current == null) {
            root = temp;
            current = root;
        } else {
            current.next = temp;
            current = current.next;
        }

        counter++;
    }

    /**
     * A 'Term' is one part of the polynomial. One term is usalli represented as
     * a*x^b, where a also contains the sign of the term!
     *
     * @param term A term
     */
    public void addTerm(Term term) {

        if (current == null) {
            root = term;
            current = root;
        } else {
            current.next = term;
            current = current.next;
        }

        counter++;
    }

    /**
     * Prints the Polynomial.
     */
    public void print() {
        Term temp = root;
        while (temp != null) {
            System.out.print(((temp.constant > 0) ? "+" : "") + temp.constant + "x^" + temp.exponent + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    /**
     * Performs a quickSort on a Polynomial based on the exponent. The term with
     * the highest exponent is put at first position, the one with lowest at
     * last.
     */
    public Polynomial quickSort() {
        Polynomial p = this;
        Polynomial majors = new Polynomial();
        Polynomial minors = new Polynomial();
        Polynomial equals = new Polynomial();

        if (counter <= 1) {
            return p;
        } else {

            Term pivot = p.root;
            equals.addTerm(pivot.constant, pivot.exponent);
            Term searchItem = p.root.next;

            while (searchItem != null) {
                if (searchItem.exponent > pivot.exponent) {
                    majors.addTerm(searchItem.constant, searchItem.exponent);
                } else if (searchItem.exponent == pivot.exponent) {
                    equals.addTerm(searchItem.constant, searchItem.exponent);
                } else {
                    minors.addTerm(searchItem.constant, searchItem.exponent);
                }
                searchItem = searchItem.next;
            }
            return concatenate(minors.quickSort(), equals, majors.quickSort());
        }
    }

    /**
     * Internal method used to concatenate three polynomials.
     */
    private Polynomial concatenate(Polynomial minors, Polynomial equals, Polynomial majors) {
        Polynomial result = new Polynomial();
        Term temp = majors.root;
        while (temp != null) {
            result.addTerm(temp.constant, temp.exponent);
            temp = temp.next;
        }
        temp = equals.root;
        while (temp != null) {
            result.addTerm(temp.constant, temp.exponent);
            temp = temp.next;
        }
        temp = minors.root;
        while (temp != null) {
            result.addTerm(temp.constant, temp.exponent);
            temp = temp.next;
        }
        return result;
    }

    /**
     * Method that performs the sum of two polynomials. The real sum and the
     * ordering is performed by a particular implementation of quickSort.
     *
     * @param p2 Polynomial to be added to the Polynomial on which the method
     * has been called.
     */
    public Polynomial summed(Polynomial p2) {
        Polynomial p1 = this;  //This is just to clearify computations!
        Polynomial result = new Polynomial();

        //copy all the elements of the two LinkedLists inside a new LinkedList
        Term temp = p1.root;
        while (temp != null) {
            result.addTerm(temp.constant, temp.exponent);
            temp = temp.next;
        }
        temp = p2.root;
        while (temp != null) {
            result.addTerm(temp.constant, temp.exponent);
            temp = temp.next;
        }

        //Modification of original QuickSort - see sort method
        return result.summingQuickSort();
    }

    /**
     * Internal auxiliary method. This is a particular variant of the quickSort
     * method in this class, which also adds the terms with same exponent.
     */
    private Polynomial summingQuickSort() {
        
        Polynomial result = this;
        Polynomial majors = new Polynomial();
        Polynomial minors = new Polynomial();
        Polynomial equals = new Polynomial();

        if (result.counter <= 1) {

            return result;

        } else {

            Term pivot = result.root;
            equals.addTerm(pivot.constant, pivot.exponent);
            Term searchItem = result.root.next;

            while (searchItem != null) {
                if (searchItem.exponent > pivot.exponent) {
                    majors.addTerm(searchItem.constant, searchItem.exponent);
                } else if (searchItem.exponent == pivot.exponent) {
                    equals.current.constant += searchItem.constant;
                } else {
                    minors.addTerm(searchItem.constant, searchItem.exponent);
                }
                searchItem = searchItem.next;
            }
            return concatenate(minors.summingQuickSort(), equals, majors.summingQuickSort());
        }
    }
    
    public Polynomial multiply(Polynomial p2) {
        Polynomial p1 = this;  // This is just done in order to clearify computations!
        Polynomial result = new Polynomial();  //in order not to modify the original Polynomials

        Term iterator1 = p1.root;
        Term iterator2 = p2.root;

        if (p1.counter > p2.counter) {
            while (iterator2 != null) {
                iterator1 = p1.root;
                while (iterator1 != null) {
                    int constantFactor = iterator1.constant * iterator2.constant;
                    int exponent = iterator1.exponent + iterator2.exponent;
                    result.addTerm(constantFactor, exponent);
                    iterator1 = iterator1.next;
                }
                iterator2 = iterator2.next;
            }
        } else {
            while (iterator1 != null) {
                iterator2 = p2.root;
                while (iterator2 != null) {
                    int constantFactor = iterator1.constant * iterator2.constant;
                    int exponent = iterator1.exponent + iterator2.exponent;
                    result.addTerm(constantFactor, exponent);
                    iterator2 = iterator2.next;
                }
                iterator1 = iterator1.next;
            }
        }
        return result.summingQuickSort();

    }
}
