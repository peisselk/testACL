import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

	public PriorityQueue<Node> queue;

	Node root;
	

	private String leftPrefix ="0";
	private String rightPrefix ="1";

	public Huffman(Node[] lesFrequences) {
		this.queue = new PriorityQueue<Node>();
		for (int i = 0; i < lesFrequences.length; i++) {
			queue.add(lesFrequences[i]);
		}
	}
	public Huffman(Character[] lesLettres, double[] lesFreq) {
		this.queue = new PriorityQueue<Node>();
		for (int i = 0; i < lesFreq.length; i++) {
			queue.add(new Node(lesFreq[i], lesLettres[i]));
		}
	}

	public void buildCode() {
		while (queue.size() > 1) {
			Node a, b;
			a = queue.poll();
			b = queue.poll();
			queue.add(new Node(a, b,a.frequence+b.frequence));
		}
		root = queue.remove();
	}

	public String decode(String s) {
		String res = "";
		int current = 0;
		String currentBit;
		Node position;
		position = root;

		while (current != s.length()) {
			position = root;
			currentBit = ""+s.charAt(current);

			do {
				currentBit = ""+s.charAt(current);
				if (currentBit.equals(leftPrefix)) {
					position = position.fg;
				}
				else {
					position = position.fd;
				}
				current++;
			} while (!position.estFeuille());
			res += position.c;
		}
		return res;
	}

	public void showCode() {
		showCode(root,"");
	}

	private void showCode(Node n, String string) {
		if (n.estFeuille()) {
			System.out.println("[" + n.c + " " + string + "]");
		} else {
			showCode(n.fg, string + leftPrefix);
			showCode(n.fd, string + rightPrefix);
		}
	}


}
