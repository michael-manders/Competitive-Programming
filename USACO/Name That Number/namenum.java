/* 
ID: mjmande1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class namenum {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
		List<String> dict = new ArrayList<>();
		String[] nums = br.readLine().split(""); 
		
		for (String word: readFile("dict.txt").split(System.lineSeparator())) {
			if (word.length() == nums.length) dict.add(word);
		}

		List<String> firsts = new ArrayList<>();
		for (String word: dict) {firsts.add(Character.toString(word.charAt(0)));}

		HashMap<Integer, String[]> dictionary;
		dictionary = new HashMap<>();
		dictionary.put(2, new String[]{"A", "B", "C"});
		dictionary.put(3, new String[]{"D", "E", "F"});
		dictionary.put(4, new String[]{"G", "H", "I"});
		dictionary.put(5, new String[]{"J", "K", "L"});
		dictionary.put(6, new String[]{"M", "N", "O"});
		dictionary.put(7, new String[]{"P", "R", "S"});
		dictionary.put(8, new String[]{"T", "U", "V"});
		dictionary.put(9, new String[]{"W", "X", "Y"});

		List<String> words = new ArrayList<>();
		
		for (String num: nums) {
			String[] letters = dictionary.get(Integer.parseInt(num));
			if (words.size() == 0) {
				for (String letter: letters) {
					if (firsts.contains(letter)) words.add(letter);
					
				}
			}
			else {
				List<String> temp = new ArrayList<>();
				for (String wordInArrList: words) {
					for (String letter: letters) {
						temp.add(wordInArrList + letter);
					}
				}
				words = temp;
			}
		}
		dict.retainAll(words);
		List<String> names = dict;

		if (names.size() == 0) out.println("NONE");
		else {
			for (String name: names) {
				out.println(name);
			}
		}

		out.close();
		
	}
	static String readFile(String path)
		throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}
}