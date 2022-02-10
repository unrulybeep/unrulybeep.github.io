// Elle Boyechko
// CSE 142 BQ
// Yuma Tou
// Homework 8 (Huffman Coding)
// Based on the Huffman compression algorithm, decodes compressed binary files,
// encodes text files, and creates a code file containing the key to do both.
import java.util.*;
import java.io.*;

public class HuffmanTree {	
	private int eof;
	private HuffmanNode root;

	// Pre: <none>
	//
	// Post: Constructs a HuffmanTree based on the given array of character
	// frequency.
	public HuffmanTree(int[] counts) {
		Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
		HuffmanNode node;

		// add the EOF character
		eof = counts.length;
		node = new HuffmanNode(eof, 1);
		pq.add(node); // manually add EOF to queue

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0 && counts[i] != eof) {
				node = new HuffmanNode(i, counts[i]);
				pq.add(node);
			}
		}
		root = constructTree(pq);
	}

	// Pre: <none>
	//
	// Post: Assembles a Huffman tree by combining the nodes in the given queue.
	private HuffmanNode constructTree(Queue<HuffmanNode> pq) {
		HuffmanNode node, firstNode, secondNode;

		do {
			firstNode = pq.remove();
			secondNode = pq.remove();
			node = new HuffmanNode(firstNode.count + secondNode.count, firstNode, secondNode);
			pq.add(node);
		} while (pq.size() > 1);

		return pq.remove();
	}

	// Pre: <none>
	//
	// Post: Writes the HuffmanTree instance to the given output stream.
	public void write(PrintStream output) {
		writeNode(root, output, "");
	}

	// Pre: Path parameter starts with empty string.
	//
	// Post: Writes the given node to the given output stream. 
	private void writeNode(HuffmanNode node, PrintStream out, String path) {
		if (isLeafNode(node)) {
			out.println(node.ascii);
			out.println(path);
		} else {
			writeNode(node.left, out, path + "0");
			writeNode(node.right, out, path + "1");
		}
	}

	// Pre: <none>
	//
	// Post: Constructs a HuffmanTree from the given input stream, containing
	// the written representation of the tree as created by the write() method.
	public HuffmanTree(Scanner input) {		
		String code;

		while (input.hasNextLine()) {
			int ascii = Integer.parseInt(input.nextLine());
			if (input.hasNextLine()) {
				code = input.nextLine();
				root = constructPath(root, ascii, code);
			} else {
				eof = ascii;
			}
		}     
	}

	// Pre: <none>
	//
	// Post: Constructs a path to a node with the given ASCII value based on
	// the provided code string.
	private HuffmanNode constructPath(HuffmanNode node, int ascii, String code) {
		if (node != null) {
			if (!code.isEmpty()) {
				if (code.startsWith("0")) {
					node.left = constructPath(node.left, ascii, code.substring(1));
				} else {
					node.right = constructPath(node.right, ascii, code.substring(1));
				}
				return node;
			} else {
				return node = new HuffmanNode(ascii, -1);
			}
		} else {
			node = constructPath(new HuffmanNode(-1, -1), ascii, code);
			return node;
		}
	}

	// Pre: <none>
	//
	// Post: Decodes the binary input stream of compressed data, which ends
	// with the provided EOF character, and writes the result to the given
	// output stream.
	public void decode(BitInputStream input, PrintStream output, int eof) {
		this.eof = eof;

		boolean notEnd = true;
		while (notEnd) {
			notEnd = decodeCharacter(this.root, output, input);
		}
	}

	// Pre: <none>
	//
	// Post: Decodes the next character by processing the binary input stream
	// of compressed data bit by bit, and outputs the character found to the
	// given output stream. Returns false when reaches the end of binary data.
	private boolean decodeCharacter(HuffmanNode node, PrintStream output, BitInputStream input) {
		if (!isLeafNode(node)) {
			int bit = input.readBit();
			if (bit == 0) {
				return decodeCharacter(node.left, output, input);
			} else {
				return decodeCharacter(node.right, output, input);
			}
		} else if (node.ascii != this.eof){
			output.print((char)node.ascii);
			return true;
		} else { // EOF character, nothing more to do
			return false;
		}
	}

	// Pre: <none>
	//
	// Post: Returns true if the given node is a leaf node and false if it is a
	// branch node.
	private boolean isLeafNode(HuffmanNode node) {
		// Only need to check if one of the node's children is null, since
		// branch nodes will always be symmetrical.
		return node.left == null;
	}

	// Inner class that constructs node objects. Creates a heirarchy for the
	// nodes based on the frequency (count field).
	private class HuffmanNode implements Comparable<HuffmanNode> {
		private int ascii;
		private int count;			// the character's frequency
		private HuffmanNode left;
		private HuffmanNode right;

		// Pre: <none>
		//
		// Post: Constructs a leaf node with the given ASCII value and its
		// frequency.
		public HuffmanNode(int ascii, int count) {
			this(count, null, null);
			this.ascii = ascii; // set manually as branch nodes don't contain ascii
		}

		// Pre: <none>
		//
		// Post: Constructs a node with the given branches and their combined
		// frequency.
		public HuffmanNode(int countTotal, HuffmanNode left, HuffmanNode right) {
			this.count = countTotal; // the sum of the count fields of the two child nodes
			this.left = left;
			this.right = right;
			this.ascii = -1; // branch nodes don't have ascii
		}

		// Pre: <none>
		//
		// Post: Returns 1 if the other node has greater count, -1 if it's
		// less than, and 0 if they're equal.
		public int compareTo(HuffmanNode other) {
			if (this.count > other.count) {
				return 1;
			} else if (this.count < other.count) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}