package application;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "8002-8922");

        cookies.remove("email");
        cookies.put("phone","9990290");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Número de telefone : " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("Email"));
        System.out.println("Tamanho: " + cookies.size());

        System.out.println("Todos os cookies: ");

        for (String key : cookies.keySet()){
            System.out.println(key + ": " + cookies.get(key));
        }

    }
}
