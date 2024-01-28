import java.util.*;
import java.util.Map.Entry;

public class forgetsIngredients {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = input.nextInt();

        HashMap<String, Double> ingredients = new HashMap<String, Double>();

        HashMap<String, Double> conversions = new HashMap<String, Double>();
        conversions.put("gallon", 768.) ;
        conversions.put("quart", 192.);
        conversions.put("pint", 96.);
        conversions.put("cup", 48.);
        conversions.put("tbsp", 3.);
        conversions.put("tsp", 1.);

        for (int e = 0; e < i; e++) {
            String name = input.next();
            String unit = input.next();
            double amount = input.nextDouble();
            amount *= conversions.get(unit);
            ingredients.put(name, amount);
        }

        ArrayList<String> toForget = new ArrayList<>();

        for (int e = 0; e < n; e++) {
            Entry<String, Double> min = Collections.min(ingredients.entrySet(), new Comparator<Entry<String, Double>>() {
                public int compare(Entry<String, Double> entry1, Entry<String, Double> entry2) {
                    return entry1.getValue().compareTo(entry2.getValue());
                }
            });

            toForget.add(min.getKey());

            ingredients.remove(min.getKey());

        }

        Collections.sort(toForget);

        for (String in: toForget) {
            System.out.println(in);
        }
        
    }
}
