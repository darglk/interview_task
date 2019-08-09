package sabre_interview;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordClassifierTest {

	@Test
	public void testPhrase1() {
		String phrase = "ala ma kota, kot koduje w Javie kota";
		String expectedResult = "{a=[ala, javie, kota, ma], d=[koduje], e=[javie, koduje], i=[javie], j=[javie, koduje], k=[koduje, kot, kota], l=[ala], m=[ma], o=[koduje, kot, kota], t=[kot, kota], u=[koduje], v=[javie], w=[w]}";
		
		Map<Character, Set<String>> result = WordClassifier.filterWords(phrase);
		assertTrue(result.toString().equals(expectedResult));
	}
	
	@Test
	public void testPhrase2() {
		String phrase = "Authentication manager needed for password grant type.";
		String expectedResult = "{a=[authentication, grant, manager, password], c=[authentication], d=[needed, password], e=[authentication, manager, needed, type], f=[for], g=[grant, manager], h=[authentication], i=[authentication], m=[manager], n=[authentication, grant, manager, needed], o=[authentication, for, password], p=[password, type], r=[for, grant, manager, password], s=[password], t=[authentication, grant, type], u=[authentication], w=[password], y=[type]}";
		
		Map<Character, Set<String>> result = WordClassifier.filterWords(phrase);
		assertTrue(result.toString().equals(expectedResult));
	}
	
	@Test
	public void testIfFilterWordsReturnsEmptyCollectionForEmptyInputString() {
		String phrase = "";
		String expectedResult = "{}";
		
		Map<Character, Set<String>> result = WordClassifier.filterWords(phrase);
		assertTrue(result.toString().equals(expectedResult));
	}
	
	@Test
	public void testIfFilterWordsReturnsEmptyCollectionForNullInputString() {
		String phrase = null;
		String expectedResult = "{}";
		
		Map<Character, Set<String>> result = WordClassifier.filterWords(phrase);
		assertTrue(result.toString().equals(expectedResult));
	}
}
