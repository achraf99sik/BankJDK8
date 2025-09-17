import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("England", "London");
        System.out.println(capitalCities.get("England"));
    }
}