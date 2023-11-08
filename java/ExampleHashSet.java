package Assign;
import java.util.HashSet;

public class ExampleHashSet {
    public static void main(String[] args) {
        HashSet<String> setObj = new HashSet<>();
        
        setObj.add("Suresh");
        setObj.add("Sujith");
        setObj.add("Syed");
        System.out.println("HashSet elements: " + setObj);
        setObj.add("Suresh");
        System.out.println("HashSet elements after updating: " + setObj);
        String name = "Sujith";
        if (setObj.contains(name)) {
            System.out.println(name + " exists in the HashSet.");
        } else {
            System.out.println(name + " does not exist in the HashSet.");
        }
        setObj.remove("Syed");
        System.out.println("HashSet after removal: " + setObj);
    }
}
