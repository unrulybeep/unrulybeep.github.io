// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 7 (20 Questions)
// A 20 Question game manager. The manager starts a new game knowing only a
// single object. It also allows loading a previously saved game data. It
// tracks how many games the manager has won against the user, and how many
// total games were played during the session. The resulting game knowledge
// tree can be saved once the session is complete. 

import java.util.*;
import java.io.*;

public class QuestionTree {
	private QuestionNode overallRoot;
	private UserInterface ui;
	private int totalGames;
	private int gamesWon;
	
	// Pre: ui parameter must not be null (throws an IllegalArgumentException
	// otherwise).
	//
	// Post: Initalizes a game with one starting object, "computer," and sets
	// up communication with the client through the given user interface.
	public QuestionTree(UserInterface ui) {
		if (ui == null) {
			throw new IllegalArgumentException();
		}
		this.ui = ui;
		overallRoot = new QuestionNode("computer");
		totalGames = 0;
		gamesWon = 0;
	}
			
	// Pre: output must not be null (throws an IllegalArgumentException otherwise).
	//
	// Post: Saves the learned game data to the given output stream.
	public void save(PrintStream output) {
		if (output == null) {
			throw new IllegalArgumentException(); 
		}
		saveNode(overallRoot, output);
	}

    // Pre: node must not be null (throws an IllegalArgumentException otherwise).
	//
	// Post: Starting from the given node, prints the learned game data to the
	// output stream.
    private void saveNode(QuestionNode node, PrintStream out) {
		if (node == null) {
			throw new IllegalArgumentException(); 
		}

		if (isLeafNode(node)) {
			out.println("A:" + node.data);
		} else {
			out.println("Q:" + node.data);
			saveNode(node.left, out);
			saveNode(node.right, out);
		}
    }
	
	// Pre: input cannot be null (throws an IllegalArgumentException otherwise)
    //
    // Post: Loads the saved game data from the given input stream. Assumes
    // the data is correctly formatted.
	public void load(Scanner input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		overallRoot = loadNode(input);
	}
	
	// Pre: <none>
	//
	// Post: Reads the next node of the saved game data from the given input
	// stream, and returns it. 
	private QuestionNode loadNode(Scanner input) {
		String line = input.nextLine();
		QuestionNode node = new QuestionNode(line.substring(2));
			
		if (line.startsWith("Q")) {
			node.left = loadNode(input);
			node.right = loadNode(input);
		}
		return node;		
	}
	
	// Pre: <none>
	//
	// Post: Returns the number of total games played during the session.
	public int totalGames() {
		return totalGames;
	}
	
	// Pre: <none>
	//
	// Post: Returns the number of games won during the play session.
	public int gamesWon() {
		return gamesWon;
	}
	
	// Pre: <none>
	//
	// Post: Begins the game of 20 Questions from the overall root of the question tree.
	public void play() {	
		overallRoot = play(overallRoot);
		totalGames++;
	}
	
	// Pre: <none>
	//
	// Post: Begins the game from the given root node. Returns either the
	// same node in case we won the game, or if we lost, a different node
	// that incorporates the new information provided by the player.
	private QuestionNode play(QuestionNode root) {
		if (isLeafNode(root)) {
			ui.print("Would your object happen to be " + root.data + "?");
			if (!ui.nextBoolean()) {
				ui.print("I lose. What is your object?");
				QuestionNode object = new QuestionNode(ui.nextLine());
				ui.print("Type a yes/no question to distinguish your item from " + root.data + ":");
				QuestionNode question = new QuestionNode(ui.nextLine());
				ui.print("And what is the answer for your object?");
				if (ui.nextBoolean()) {
					question.left = object;
					question.right = root;
				} else {
					question.left = root;
					question.right = object;
				}
				return question;
			} else {
				ui.println("I win!");
				gamesWon++;
			}
		} else {
			ui.print(root.data);
			if (!ui.nextBoolean()) {
				root.right = play(root.right);
			} else {
				root.left = play(root.left);
			}
		}
		return root;
	}
	
	// Pre: <none>
	//
	// Post: Returns true if the given node is a leaf node and false if it is a
	// branch node.
	private boolean isLeafNode(QuestionNode node) {
		// Only need to check if one of the node's children is null, since
		// branch nodes will always be symmetrical.
		return node.left == null;
	}
}