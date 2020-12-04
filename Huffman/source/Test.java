import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		// testNode();
		double freq[] = { 45, 13, 12, 16, 9, 5 };// { 45, 12, 24, 8, 5, 6 };
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
		Node[] t = buildTab(freq, chars);
		System.out.println(t);
		huffTEST(t);
	}

	

	private static void huffTEST(Node[] t) {
		Huffman h = new Huffman(t);
		h.buildCode();
		h.showCode();
		System.out.println(h.decode("0101100"));
//		String code1;
//		System.out.println(code1 = h.encode("abe"));
//		System.out.println(h.decode(code1));

	}

	private static Node[] buildTab(double[] freq, char[] chars) {
		int nb = freq.length;
		Node[] res = new Node[nb];
		for (int i = 0; i < nb; i++) {
			res[i] = new Node(freq[i], chars[i]);
		}
		return res;
	}

}
