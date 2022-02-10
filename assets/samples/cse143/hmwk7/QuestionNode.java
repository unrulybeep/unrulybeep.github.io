// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 7 (20 Questions)
// QuestionNode objects store a single node of a binary tree of questions.
public class QuestionNode {
	public String data; // stores a question or name of an object
	public QuestionNode left;
	public QuestionNode right;
	
	// Constructs a QuestionNode from the given data, which is an object name.
	public QuestionNode(String data) {
		this(data, null, null);
	}

	// Constructs a QuestionNode from the given data, which is a question, and
	// its left and right branches.
	public QuestionNode(String data, QuestionNode left, QuestionNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
