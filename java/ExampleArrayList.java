package Assign;
import java.util.ArrayList;

public class ExampleArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println("ArrayList elements: " + numbers);
        System.out.println("Element at index 1: " + numbers.get(1));
        for(int i=1 ;i<4 ;i++) {
        	System.out.println("Element at index "+ i+": " + numbers.get(i));
        }
        numbers.set(1, 25);
        System.out.println("Updated ArrayList: " + numbers);
        numbers.remove(0);
        System.out.println("ArrayList after removal: " + numbers);
    }
}
