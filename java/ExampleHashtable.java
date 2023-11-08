package Assign;
import java.util.Hashtable;

public class ExampleHashtable {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashObj = new Hashtable<>();

        hashObj.put("Sujith", 21);
        hashObj.put("Syed", 22);
        hashObj.put("Suresh", 22);
        hashObj.put("Guru_Garu", 21);
        System.out.println("Hashtable: " + hashObj);
        System.out.println("Age of Alice: " + hashObj.get("Sujith"));
        hashObj.put("Syed", 21);
        System.out.println("Updated Hashtable: " + hashObj);
        hashObj.remove("Suresh");
        System.out.println("Hashtable after removal: " + hashObj);
        String name = "Guru_Garu";
        if (hashObj.containsKey(name)) {
            System.out.println(name + " exists in the Hashtable.");
        } else {
            System.out.println(name + " does not exist in the Hashtable.");
        }
        
    }
}
