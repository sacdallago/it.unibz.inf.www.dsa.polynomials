
import java.util.Random;


public class Tester {
    public static void main(String[] args) {
        lists.Polynomial p1 = new lists.Polynomial();
        lists.Polynomial p2 = new lists.Polynomial();
        
        arrays.Polynomial p3;
        arrays.Polynomial p4;
        
        
        //SET THE ORDER HERE--------------------------------------
        int order = 10;
        //SET THE ORDER HERE--------------------------------------
        
        
        long listMemory = Runtime.getRuntime().freeMemory();
        p1.addTerm(0,order);
        p2.addTerm(0,order);
        listMemory -= Runtime.getRuntime().freeMemory();
        
        long arrayMemory = Runtime.getRuntime().freeMemory();
        p3 = new arrays.Polynomial(order+1);
        p4 = new arrays.Polynomial(order+1);
        arrayMemory -= Runtime.getRuntime().freeMemory();
        
        Random ran = new Random();
        
        
        //SET THE POPULATION HERE--------------------------------------
        int population = 10;
        //SET THE POPULATION HERE--------------------------------------
        
        
        listMemory += Runtime.getRuntime().freeMemory();
        for (int i = 0; i < population; i++){
            p1.addTerm(ran.nextInt(order), ran.nextInt(order+1));
            p2.addTerm(ran.nextInt(order), ran.nextInt(order+1));
        }
        listMemory -= Runtime.getRuntime().freeMemory();
        
        arrayMemory += Runtime.getRuntime().freeMemory();
        for (int i = 0; i < population; i++){
            p3.addTerm(ran.nextInt(order), ran.nextInt(order+1));
            p4.addTerm(ran.nextInt(order), ran.nextInt(order+1));
        }
        arrayMemory -= Runtime.getRuntime().freeMemory();
        
        long sumList = -System.nanoTime();
        p1.summed(p2);
        sumList += System.nanoTime();
        long multiplyList = -System.nanoTime();
        p1.multiply(p2);
        multiplyList += System.nanoTime();
        
        long sumArray = -System.nanoTime();
        p3.sum(p4);
        sumArray += System.nanoTime();
        long multiplyArray = -System.nanoTime();
        p3.multiply(p4);
        multiplyArray += System.nanoTime();
        
        System.out.println("Order: " + order);
        System.out.println("Population: " + population);
        System.out.println("Sum (lists) in ms: " + (sumList/1000000));
        System.out.println("Sum (arrays) in ms: " + (sumArray/1000000));
        System.out.println("Multiply (lists) in ms: " + (multiplyList/1000000));
        System.out.println("Multiply (arrays) in ms: " + (multiplyArray/1000000));
        System.out.println("List memory (kb): " + (int)(listMemory*0.0078125));
        System.out.println("Array memory (kb): " + (int)(arrayMemory*0.0078125));
    }
}