package arrays;

public class Polynomial {

    public int[] array;
    public int length;

    /**
     * Constructor sets up a polynomial of order n;
     *
     * @param n The size of the polynomial
     */
    public Polynomial(int n) {
        array = new int[n];
        length = n;
    }

    public Polynomial(int[] array) {
        this.array = array;
        length = array.length;
    }

    public Polynomial() {
        array = new int[0];
        length = 0;
    }

    public void addTerm(int a, int b) {
        int position = 0;
        if (b > array.length - 1) {
            int[] newArray = new int[b + 1];
            for (int temp = 0; temp < array.length; temp++) {
                position = temp + (newArray.length - array.length);
                newArray[position] = array[temp];
            }
            array = newArray;
        }

        position = (array.length) - (b + 1);

        array[position] += a;
        length = array.length;
    }

    public void print() {
        String print = "";
        for (int temp = 0; temp < array.length; temp++) {
            int position = (array.length - 1) - temp;
            print += ((array[temp] >= 0) ? "+" : "") + array[temp] + "x^" + position + " ";
        }
        System.out.println(print);
    }

    public Polynomial sum(Polynomial p2) {
        Polynomial p1 = this;
        int position = 0;
        int size = (p1.length > p2.length ? p1.length : p2.length);


        int[] newArray = new int[size];
        for (int temp = 0; temp < p1.array.length; temp++) {
            position = temp + (newArray.length - p1.array.length);
            newArray[position] += p1.array[temp];
        }
        for (int temp = 0; temp < p2.array.length; temp++) {
            position = temp + (newArray.length - p2.array.length);
            newArray[position] += p2.array[temp];
        }

        return new Polynomial(newArray);
    }

    public Polynomial multiply(Polynomial p2) {
        Polynomial p1 = this;
        int size = (p1.array.length + p2.array.length) - 2;
        Polynomial result = new Polynomial(size);
        int position = 0;
        for (int temp = 0; temp < p1.array.length; temp++) {
            for (int temp2 = 0; temp2 < p2.array.length; temp2++) {
                position = size - (temp + temp2);
                result.addTerm(p1.array[temp] * p2.array[temp2], position);
            }
        }

        return result;
    }
}
