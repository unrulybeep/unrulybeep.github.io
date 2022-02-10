// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 6 (Anagram)
// Lists all possible anagrams that can be created from the given phrase; list
// can be filtered by number of words in the anagram.
import java.util.*;

public class Anagrams {
	private Set<String> dictionary;
	private SortedSet<String> choices;
	
	// Creates a dictionary from the given list. Throws IllegalArgumentException
	// if given list is null.
	public Anagrams(Set<String> dictionary) {
		this.dictionary = new HashSet<String>(dictionary);
	}
	
	// Throws an IllegalArgumentException if phrase is null. Narrows down the
	// dictionary to a list of words that will be used to construct the anagrams.
	public SortedSet<String> getWords(String phrase) {
		if (phrase == null) {
			throw new IllegalArgumentException();
		}
		LetterInventory letters = new LetterInventory(phrase);
		SortedSet<String> choices = new TreeSet<String>();
		for (String word: dictionary) {
			if (letters.contains(word)) {
				choices.add(word);
			}
		}
		return choices;
	}
	
	// Throws an IllegalArgumentException if the phrase is null. Prints out a
	// list of all the anagrams that could be made from the given phrase.
	public void print(String phrase) {
		if (phrase == null) {
			throw new IllegalArgumentException();
		}
		print(phrase, 0);
	}
	
	// Throws an IllegalArgumentException if the phrase is null or if max is
	// less than 0. Prints out the anagrams that have less than or equal to
	// the given max number of words.
	public void print(String phrase, int max) {
		if (phrase == null || max < 0) {
			throw new IllegalArgumentException();
		}
		choices = getWords(phrase);
		LetterInventory letters = new LetterInventory(phrase);
		Stack<String> anagram = new Stack<String>();	
		makeAnagram(max, anagram, letters);
	}
	
	// Helper recursive methods that takes the given max, and the letters in the
	// given phrase as parameters, then creates a list of anagrams which is then
	// printed to the console. Anagram is also taken as a parameter, so that the
	// stack is retained on recursion.
	private boolean makeAnagram(int max, Stack<String> anagram, LetterInventory letters) {
		if(letters.isEmpty() && (max == 0 || anagram.size() <= max)) {
			System.out.println(anagram);
			return true;
		}		
		for (String word: choices) {
			if (letters.contains(word)) {
				anagram.push(word);
				letters.subtract(word);
				makeAnagram(max, anagram, letters);
				anagram.pop();
				letters.add(word);
			}
		}	
		return false;
	}
}
