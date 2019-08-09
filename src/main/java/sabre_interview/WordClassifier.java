package sabre_interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class with solution for Sabre interview.
 * @author Dariusz Kulig
 *
 */
public class WordClassifier {

	public static void main(String[] args) {
		String testPhrase = "Authentication manager needed for password grant type.";
		Map<Character, Set<String>> result = filterWords(testPhrase);
		System.out.println(result);
	}

	
	/**
     * Static method classifying letters and words containing them.
     * Letters and words are also sorted alphabetically. If input is null or empty,
     * it will return empty collection. 
     * @param testPhrase - sentence to be filtered.
     * @return Map<Character, Set<String>> containing result of filtration.
     */
	public static Map<Character, Set<String>> filterWords(String testPhrase) {
		Map<Character, Set<String>> words = new LinkedHashMap<>();
		if (testPhrase == null || testPhrase.trim().isEmpty()) {
			return words;
		}
		String filteredPhrase = testPhrase.trim().toLowerCase().replaceAll("[^\\sa-z]", "");
		List<String> tokens = Arrays.asList(filteredPhrase.split("\\s"));
		int[] chars = filteredPhrase.chars().filter(Character::isLetter).distinct().sorted().toArray();
		
		Arrays.stream(chars).forEach(ch -> {
			tokens.forEach(token -> {
				if (token.chars().anyMatch(c -> ch == c)) {
					char letter = (char) ch;
					if (words.containsKey(letter)) {
						words.get(letter).add(token);
					} else {
						Set<String> list = new TreeSet<>();
						list.add(token);
						words.put(letter, list);
					}
				}
			});
		});
		return words;
	}
}
