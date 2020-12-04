public class Node implements Comparable<Node> {
	// better implementation would be to distinct node and leaf (by two classes)
	double frequence;
	Character c;
	Node fg,fd;

	public Node(Node fg, Node fd) {
		this(fg,fd,fg.frequence+fd.frequence);
	}

	public Node(Node fg, Node fd, double frequence) {
		this.frequence = frequence;
		this.fg = fg;
		this.fd = fd;
		c=null;
	}
	
	public Node(double frequence, char c) {
		this.frequence = frequence;
		this.c = c;
		fg=fd=null;
	}
	

	public boolean estFeuille(){
		return fg==null && fd==null;
	}
	
	@Override
	public int compareTo(Node other) {
		if (this.frequence< other.frequence) return -1;
		if (this.frequence> other.frequence) return 1;
		return 0;
	}	
}
