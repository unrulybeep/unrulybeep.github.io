// Elle Boyechko
// Yuma Tou
// Homework 4 (Evil Hangman)
// Creates a manager for a game of evil hangman in which the game will refrain
// from picking a word until it has no other choice; the word list is being
// narrowed down after each guess until one word is left.

import java.util.*;

public class HangmanManager {
	private int gameLength;
	private Set<String> gameDictionary;
	private int gameMax;
	private int numberOfGuesses;
	private SortedSet<Character> lettersGuessed;
	private Map<String, Set<String>> wordFamilies;
	private String wordPattern = "";

	// Throws IllegalArgumentException if target word length is less than 1 or
	// if the amount of guesses permitted is less than 0. A dictionary is passed
	// to the class during HangmanManager creation. It uses this list to create
	// a game dictionary containing only the words that are the given length.
	// The max parameter is used to set how many guesses are allowed. The word
	// pattern is created with length number of dashes.
	public HangmanManager(List<String> dictionary, int length, int max) {
		if (length < 1 || max < 0) {
			throw new IllegalArgumentException();
		}
		gameDictionary = new TreeSet<String>();
		gameMax = max;
		gameLength = length;
		for (String word : dictionary) {
			if (word.length() == length) {
				gameDictionary.add(word);
			}
		}
		for (int i = 0; i < length; i++) {
			wordPattern += "-";
		}
		numberOfGuesses = 0;
		lettersGuessed = new TreeSet<Character>();
		wordFamilies = new TreeMap<String, Set<String>>();
	}

	// Returns a sorted set of words that are listed in the game dictionary.
	public Set<String> words() {
		return gameDictionary;
	}

	// Returns the number of guesses left in the game.
	public int guessesLeft() {
		return gameMax - numberOfGuesses;
	}

	// Returns the letters which have already been guessed in sorted order.
	public SortedSet<Character> guesses() {
		return lettersGuessed;
	}

	// Throws IllegalStateException if dictionary is empty. Returns the pattern
	// with correctly guessed letters displayed, if any, separated by spaces.
	public String pattern() {
		if (gameDictionary == null) {
			throw new IllegalStateException();
		}
		String paddedPattern = "";
		paddedPattern += wordPattern.charAt(0);
		for (int i = 1; i < gameLength; i++) {
			paddedPattern += " " + wordPattern.charAt(i);
		}
		return paddedPattern;
	}

	// The letter entered as a guess is added to the sorted list being kept,
	// then the character is used to search the game dictionary and find all
	// the words which have that letter. How many of the letter are present in
	// the remaining words is returned. If there are no letter matching, the
	// number of guesses made is increased.
	public int record(char guess) {
		lettersGuessed.add(guess);
		patternMapping(guess);
		int matchesLetterCount = largestSet();
		if (matchesLetterCount == 0) {
			numberOfGuesses++;
		}
		return matchesLetterCount;
	}

	// Searches the game dictionary for words that contain the given character
	// and creates a pattern with underscores surrounding the character. All
	// words that match the same pattern are grouped together.
	private void patternMapping(char guess) {
		Iterator<String> itr = gameDictionary.iterator();
		String current = "";
		String pattern = "";
		while (itr.hasNext()) {
			current = itr.next();
			for (int i = 0; i < current.length(); i++) {
				if (current.charAt(i) == guess) {
					pattern += guess;
				} else {
					pattern += "_";
				}
			}
			if (!wordFamilies.containsKey(pattern)){
				wordFamilies.put(pattern, new TreeSet<String>());
			}
			wordFamilies.get(pattern).add(current);
			pattern = "";
		}
	}

	// helper method that returns how many times a guessed letter shows up in
	// the word family, and determines the largest word family that will refresh
	// the game dictionary. Since no letter is given to the method, it has to be
	// called after the words have been mapped to a pattern. 
	private int largestSet() {
		int wordFamilySize = 0;
		String maxFamily = "";
		for (String pattern : wordFamilies.keySet()) {
			if(wordFamilySize < wordFamilies.get(pattern).size()) {
				wordFamilySize = wordFamilies.get(pattern).size();
				maxFamily = pattern;
			}
		}
		gameDictionary = wordFamilies.get(maxFamily);
		wordFamilies.clear();
		return renderNewPattern(maxFamily);
	}

	// helper method that refreshes the pattern displayed every time a letter
	// is guessed. Accepts a string as a parameter, that is the pattern matching
	// the word family with the largest available words. Returns a number that
	// is the times the guessed letter is in the pattern. Needs to be called
	// after the word family is chosen.
	private int renderNewPattern(String maxFamily) {
		int matchesLetterCount = 0;
		String pattern = "";
		for (int i = 0; i < gameLength; i++) {
			if (wordPattern.charAt(i) == '-') {
				if (maxFamily.charAt(i) != '_') {
					matchesLetterCount++;
					pattern += maxFamily.charAt(i);
				} else {
					pattern += "-";
				}
			} else {
				pattern += wordPattern.charAt(i);
			}
		}
		wordPattern = pattern;
		return matchesLetterCount;
	}
}