// Elle Boyechko
// CSE 143 BQ
// Yuma Tou
// Homework 3 (Assassin)
// Tracks assassins and who they want to kill.

import java.util.*;

public class AssassinManager {
	private AssassinNode killRing;
	private AssassinNode graveyard;

	//throws IllegalArgumentException if null
	public AssassinManager(ArrayList<String> names){
		if (names == null || names.size() == 0) {
			throw new IllegalArgumentException();
		}
		killRing = null;
		AssassinNode current;
		for (int i = names.size() - 1; i >= 0; i--) {
			current = new AssassinNode(names.get(i));
			if (killRing != null) {
				current.next = killRing;
			}
			killRing = current;
		}
		graveyard = null;
	}

	// Prints which assassin is stalking which.
	public void printKillRing() {
		AssassinNode current = killRing;
		String target;
		while (current != null) {
			if (current.next == null) {
				target = killRing.name;
			} else {
				target = current.next.name;
			}
			System.out.println( "  " + current.name + " is stalking " + target);
			current = current.next;
		}
	}

	// Prints who is currently in the graveyard.
	public void printGraveyard() {
		AssassinNode current = graveyard;
		while(current != null) {
			System.out.println("  " + current.name + " was killed by " + current.killer);
			current = current.next;
		}	
	}

	// Returns true if the given name is alive. Returns false if they've been killed.
	public boolean killRingContains(String name) {
		return listContains(name, killRing);
	}

	// Returns true if the given name has been killed. False if they're alive.
	public boolean graveyardContains(String name) {
		return listContains(name, graveyard);
	}

	// Returns true if there is only one assassin left alive. False if there is
	// more than one assassin alive.
	public boolean isGameOver() {
		return (killRing != null && killRing.next == null);
	}

	// Returns the name of the last assassin alive, or null if the game isn't over.
	public String winner() {
		if (isGameOver()) { 
			return killRing.name;
		} else {
			return null;
		}
	}

	// If the given name is alive then they are killed. If the game is over, an
	// IllegalStateException is thrown, or if the given name isn't alive an
	// IllegalArgumentException is thrown.
	public void kill(String name) {
		AssassinNode purgatory;
		if (isGameOver()) {
			throw new IllegalStateException();
		}
		if (!killRingContains(name)) {
			throw new IllegalArgumentException();
		}
		AssassinNode current = killRing;
		while(current.next != null) {
			if (current.next.name.equalsIgnoreCase(name)) {
				current.next.killer = current.name;
				purgatory = current.next;
				current.next = purgatory.next;
				graveyardShift(purgatory);
			} else {
				current = current.next;
			}			
		}
		String lastAssassin = current.name;
		current = killRing;
		if (current.name.equalsIgnoreCase(name)) {
			current.killer = lastAssassin;
			purgatory = killRing;
			killRing = current.next;
			graveyardShift(purgatory);
		}
	}

	// helper method; parameters are a string and a node. Node determines whether
	//  to look in the graveyard or the kill ring. Returns true if name is found,
	// and false if it is not.
	private boolean listContains(String name, AssassinNode node) {
		AssassinNode current = node;
		while(current != null) {
			if (current.name.equalsIgnoreCase(name)) {
				return true;
			} else {
				current = current.next;
			}
		}	
		return false;
	}

	// helper method: accepts an AssassinNode as a parameter
	// Adds a person to the graveyard, will be set to null if graveyard is empty,
	// and then arranges assassins to preserve the assination order.
	private void graveyardShift(AssassinNode purgatory) {
		purgatory.next = graveyard;
		graveyard = purgatory;
		purgatory = null;	
	}
}