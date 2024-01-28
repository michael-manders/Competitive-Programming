import java.util.*;

public class CookingWConnor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();


        while (t > 0) {
            HashMap<String, Integer> targetChem = parseChemical(input.nextLine());
            ArrayList<HashMap<String, Integer>> components = new ArrayList<HashMap<String, Integer>>();

            // System.out.println(targetChem);

            int n = Integer.parseInt(input.nextLine());
            int[] best = new int[n + 1];

            while (n > 0) {
                components.add(parseChemical(input.nextLine()));
                n--;
            }

            n = components.size() + 1;

            Combinations combs = new Combinations(n, 10);

            ArrayList<String> possiblities= new ArrayList<>();

            while (true) {
                ArrayList<HashMap<String, Integer>> c = new ArrayList<HashMap<String, Integer>>();
                for (HashMap<String, Integer> h: components) {
                    c.add((HashMap<String, Integer>) h.clone());
                }
                HashMap<String, Integer> tc = new HashMap<String, Integer>(targetChem);

                // System.out.println(c);
                HashMap<String, Integer> combined = addChems(c, combs.combo());
                
                // System.out.println(Arrays.toString(combs.combo()));

                if (same(tc, combined, combs.get(0))) {
                    String s = "";
                    for (int i = 0; i < combs.combo().length; i++) {
                        s+=combs.combo()[i];
                        if (i != 0) s+= " ";
                        else s+= " : ";
                    }

                    possiblities.add(s);

                    // System.out.println(s);

                    s = s.substring(s.indexOf(":"));
                    if (s.indexOf("1") == s.lastIndexOf("1") && s.indexOf("1") != -1) {
                        break;
                    }

                    // break;
                }
                
                try {combs.iterate();}
                catch (Exception e) {
                    if (possiblities.size() == 0) System.out.println("uh oh :(");
                    break;
                }

            }
            t--;
            String b = "";
            int bestInt = Integer.MAX_VALUE;

            for (String p: possiblities) {
                int v = 0;
                String[] didgets = p.split(" ");
                for (String d: didgets) {
                    if (d.indexOf(":") == -1) {
                        v+=Integer.parseInt(d);
                    } 
                }
                if (v < bestInt) {
                    b = p;
                    bestInt = v;
                }
            }

            System.out.println(b);
        }
    }

    public static boolean same(HashMap<String, Integer> product, HashMap<String, Integer> components, int coeficient) {

        if (!components.get("Charge").equals(product.get("Charge") * coeficient)) return false;
        product.remove("Charge");
        components.remove("Charge");

        if (!components.get("Polarity").equals(product.get("Polarity"))) return false;
        product.remove("Polarity");
        components.remove("Polarity");

        try {
            for (String key: product.keySet()) {
                if (components.get(key).equals(product.get(key) * coeficient)) {
                    components.remove(key);
                }
                else return false;
            }
        }
        catch (Exception e) {return false;}

        if (components.size() == 0) return true;
        else {
            for (String key: components.keySet()) {
                if (!components.get(key).equals(0)) return false;
            }
        }
        return true;
    }

    public static HashMap<String, Integer> addChems(ArrayList<HashMap<String, Integer>> comps, int[] n) {
        HashMap<String, Integer> output = new HashMap<String, Integer>();
        output.put("Charge", 0);
        output.put("Polarity", 1);

        int i = 1;
        for (HashMap<String, Integer> component: comps) {

            int toAdd = component.get("Charge") * component.get("Polarity");
            int current = output.get("Charge") * output.get("Polarity");
            int newC = (int)Math.abs( toAdd * n[i] + current);
            int newP = toAdd* n[i] + current  >= 0 ? 1 : -1;

            output.put("Charge", newC);
            output.put("Polarity", newP);

            component.remove("Charge");
            component.remove("Polarity");

            for (String key: component.keySet()) {
                if (output.containsKey(key)) output.put(key, output.get(key) + component.get(key) * n[i]);
                else output.put(key, component.get(key) * n[i]);
                
            }
            i++;
        }
        return output;
    }

    public static HashMap<String, Integer> parseChemical(String chemicalString) {
        HashMap<String, Integer> chemical = new HashMap<String, Integer>();

        chemical.put("Charge", 0);
        chemical.put("Polarity", 1);

        int factor = 1;

        // checks if it has a charge
        if (chemicalString.indexOf("^") > -1) {
            int carret = chemicalString.indexOf("^");
            String inside;
            if (chemicalString.charAt(carret + 1) == '{') {
                int s = chemicalString.lastIndexOf("{");
                int e = chemicalString.lastIndexOf("}");
                inside = chemicalString.substring(s + 1, e);
            }
            else {
                inside = chemicalString.substring(carret + 1);
            }

            int charge; 
            int polarity = 0;
            if (inside.indexOf("-") > -1) polarity = -1;
            else if (inside.indexOf("+") > -1 ) polarity = +1;

            inside = inside.replace("+", "").replace("-", "");
            if (inside.length() == 0) charge = 1;
            else {
                charge = Integer.parseInt(inside);
            }

            chemical.put("Charge", charge);
            chemical.put("Polarity", polarity);

            chemicalString = chemicalString.substring(0, carret);
        }

        while (chemicalString.length() > 0) {

            // checks for factor
            if (chemicalString.substring(0, 1).matches("[0-9]+")) {
                String temp  = "";
                int i = 0;
                for ( ; !chemicalString.substring(i, i+1).matches("[A-Z]+"); i++) {
                    temp+=chemicalString.substring(i, i+1);
                }
                chemicalString = chemicalString.substring(i);
                factor = Integer.parseInt(temp);
            }

            String chemicalSymbol = chemicalString.substring(0, 1);
            chemicalString = chemicalString.substring(1);
            while (true) {
                if (chemicalString.length() > 0 && chemicalString.substring(0,  1).matches("[a-z]+")) {
                    chemicalSymbol+=chemicalString.substring(0, 1);
                    chemicalString = chemicalString.substring(1);
                }
                else {
                    break;
                }
            } 

            int existing = 0;
            if (chemical.containsKey(chemicalSymbol)) {
                existing  = chemical.get(chemicalSymbol);
            }
            // System.out.println(chemicalSymbol);
            if (chemicalString.length() == 0) {
                chemical.put(chemicalSymbol, 1 * factor + existing);
                break;
            }

            else if (chemicalString.substring(0, 1).matches("[a-zA-Z]+")) {
                chemical.put(chemicalSymbol, 1* factor + existing);
            }

            else if (chemicalString.charAt(0) == '_') {
                if (chemicalString.charAt(1) == '{') {
                    int s = chemicalString.indexOf("{");
                    int e = chemicalString.indexOf("}");
                    int subscript = Integer.parseInt(chemicalString.substring(s + 1, e));
                    chemicalString = chemicalString.substring(e + 1);
                    chemical.put(chemicalSymbol, subscript* factor + existing);
                }
                else {
                    int subscript = Integer.parseInt(chemicalString.substring(1, 2));
                    chemicalString = chemicalString.substring(2);
                    chemical.put(chemicalSymbol, subscript* factor + existing);
                }
            }
            else {
                int subscript = Integer.parseInt(chemicalString.substring(0, 1));
                chemicalString = chemicalString.substring(1);
                chemical.put(chemicalSymbol, subscript* factor + existing);
            }
        }
        return chemical;
    }
}       

class Combinations {
    private HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
    private int maxPP;

    public Combinations(int places, int m) {
        maxPP = m;
        places--;
        while (places >= 0) {
            state.put(places, 0);
            places--;
        }
        state.put(0, 1);
    }

    public int get(int i) {
        return state.get(i);
    }

    public int[] combo() {
        int[] result = new int[state.size()];
        int i =  0; //state.size() - 1;
        boolean skip = true;
        int n1 = 0;
        for (int key: state.keySet()) {
            // System.out.println(key);
            result[i] = state.get(key);
            i++;
        }

        return result;
    }
    
    public void iterate() {
        
        state.put(0, state.get(0) + 1);

        if (state.get(0) > maxPP) {
            state.put(0, 1);
            state.put(1, state.get(1) + 1);

            for (int i = 1; i < state.size(); i++) {
                if (state.get(i) > maxPP) {
                    state.put(i, 0);
                    state.put(i + 1, state.get(i + 1) + 1);
                }
                else {
                    break;
                }
            }
        }
    }
}