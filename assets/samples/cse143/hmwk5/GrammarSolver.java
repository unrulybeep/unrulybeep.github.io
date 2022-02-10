// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 5 (Grammar Solver)
// Parses an input file for BNF language grammar, then requests input to
// determine what sort of non-terminal phrases to generate.
import java.util.*;

public class GrammarSolver {
	private Map<String, String[]> grammar;
	private Random rand = new Random();

	// Throws IllegalArgumentException if the given list is null or empty, and if
	// there is more than one entry for a non-terminal symbol. Creates associations
	// between non-terminals and their rules.
	public GrammarSolver(List<String> rules) {
		if (rules == null || rules.size() == 0) {
			throw new IllegalArgumentException();
		}
		grammar = new HashMap<String, String[]>();
		for (int i = 0; i < rules.size(); i++) {
			String string = rules.get(i);
			String[] parts = string.split("::=");
			parts[0] = parts[0].trim();
			parts[1] = parts[1].trim();
			
			// Check if double entry for non-terminal symbol.
			if (grammar.containsKey(parts[0])) {
				throw new IllegalArgumentException();
			}
			
			// Separate the various rules for the symbol and remove extra spaces
			// and tabs in rules and clauses.
			String[] newRules = parts[1].split("[ \t]*[|][ \t]*");
			for (int j = 0; j < newRules.length; j++) {
				String[] clauseSplit = newRules[j].split("[ \t]+");
				
				// Reconstuct the clauses with only one space.
				newRules[j] = "";
				for (int k = 0; k < clauseSplit.length; k++) {
					newRules[j] += clauseSplit[k] + " ";
				}
				
				// Trim is needed because loop ends with a space after the clause.
				newRules[j] = newRules[j].trim();
			}
			grammar.put(parts[0], newRules);
		}
	}

	// Throws IllegalArgumentException if given string is null or empty. Returns true
	// if the symbol is found in the grammar, and false if it isn't.
	public boolean contains(String symbol) {
		if (symbol == null || symbol.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return grammar.containsKey(symbol);
	}

	// Returns a sorted list of all the non-terminal symbols in the grammar.
	public Set<String> getSymbols() {
		return grammar.keySet();
	}

	// Throws IllegalArgumentException if symbol is null. Takes the given symbol(s)
	// and returns a randomly generated outcome based on the symbol's rules.
	public String generate(String symbol) {
		if (symbol == null) {
			throw new IllegalArgumentException();
		}

		if (symbol.contains(" ")) {						// symbol actually contains multiple symbols 
			int spaceIndex = symbol.indexOf(" ");
			return generate(symbol.substring(0, spaceIndex)) + " " +
				   generate(symbol.substring(spaceIndex + 1));
		} else if (contains(symbol)) {                  // symbol is non-terminal
			int rulesIndex = rand.nextInt(grammar.get(symbol).length);
			String[] rules = grammar.get(symbol);
			return generate(rules[rulesIndex]);
		} else {                                        // symbol is terminal
			return symbol;
		}
	}
}