package SaveFile;

import java.util.HashMap;
import java.util.Map;

public class mainApp {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("XYZ",10);
        map.put("ABC",0);
        System.out.println(map.containsValue(10));
        System.out.println(map.getOrDefault("PQR",80));
    }
}
