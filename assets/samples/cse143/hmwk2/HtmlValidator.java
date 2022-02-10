// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 2 (HTML Validator)
// Checks whether the given HTML code has matching opening and closing tags.
// Prints errors if a tag isn't closed, or there is a tag in the wrong place.

import java.util.*;

public class HtmlValidator {
	private Queue<HtmlTag> tagsQueue;

	// Creates a new validator object.
	public HtmlValidator() {
		this.tagsQueue = new LinkedList<HtmlTag>();
	}

	// Creates a new validator object containing the given tags from the parameter.
	// Throws an exception if the parameter is null.
	public HtmlValidator(Queue<HtmlTag> tags) {
		this.tagsQueue = new LinkedList<HtmlTag>();
		if (tags ==  null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = tags.size(); i > 0; i--) {
				this.tagsQueue.add(tags.remove());
			}
		}
	}

	// Adds the specified parameter to the queue. Throws an exception if the tag
	// is null.	
	public void addTag(HtmlTag tag) {
		if (tag == null) {
			throw new IllegalArgumentException();
		} else {
			this.tagsQueue.add(tag);
		}
	}

	// Prints to the console the list of HTML tags.
	public Queue<HtmlTag> getTags() {
		return this.tagsQueue;
	}

	// Removes all of the specified tag from the queue. Throws an exception if
	// the parameter is null.
	public void removeAll(String element) {
		for (int i = this.tagsQueue.size(); i >= 1; i--) {
			String tagString = this.tagsQueue.peek().getElement();
			if (element.equals(null)) {
				throw new IllegalArgumentException();
			} else if (element.equals(tagString)){
				this.tagsQueue.remove();
			} else {
				reQueue();
			}
		}
	}

	// Goes through the list of tags and checks whether each open tag has a matching
	// closing tag. If not, error messages are printed to the console. Each tag is
	// also printed to the console, with matching indentation.
	public void validate() {
		Stack<HtmlTag> openTags = new Stack<HtmlTag>();
		for (int i = this.tagsQueue.size(); i >= 1; i--) {
			HtmlTag tempTag = this.tagsQueue.peek();
			if (tempTag.isOpenTag() && tempTag.isSelfClosing()) {
				printTagAndRequeue(openTags, tempTag);
			} else if (tempTag.isOpenTag()) {
				printTagAndRequeue(openTags, tempTag); //moved atop next line
				openTags.push(tempTag);
			} else if (!openTags.isEmpty() && tempTag.matches(openTags.peek())) {
				openTags.pop();
				printTagAndRequeue(openTags, tempTag);
			} else {
				System.out.println("ERROR unexpected tag: " + tempTag.toString());
				reQueue();
			}
		}
		if (!openTags.isEmpty()) {
			for (int j = openTags.size(); j >= 1; j--) {
				System.out.println("ERROR unclosed tag: " + openTags.pop());
			}
		}
	}

	// Takes an integer as a parameter, which is used to determine how big of
	// an indentation is needed; 4 spaces per tag. Returns a string of spaces.
	private String indentAmount(int stackSize) {
		String spaces = "";
		for(int i = 0; i < stackSize; i++) {
			spaces += "    ";
		}
		return spaces;
	}

	// Prints to console HTML tags with proper indentation, then puts the tag at
	// the end of the queue. Accepts two parameters, one is a list of open tags
	// so the right amount indentation can be printed, and the specific tag being
	// printed. pre: validator queue exists, stack exists
	private void printTagAndRequeue(Stack<HtmlTag> openTags, HtmlTag tempTag) {
		int stackSize = openTags.size();
		System.out.print(indentAmount(stackSize));
		System.out.println(tempTag.toString());
		reQueue();
	}

	// Moves the first element in the queue to the end. Added for code clarity.
	private void reQueue() {
		this.tagsQueue.add(this.tagsQueue.remove());
	}
}