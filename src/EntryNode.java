//1191413-Mohammad hlhwly
public class EntryNode <T extends Comparable<T>>{
	
	
	
	/**Varuable in class*/
	/**var in Hash_Table*/
	private String KeyName;
	private String valueGender;
	/**var in NodeHash*/
	//private Object node;
	private byte statusNode;
	/**var in insert in max heap*/
	private MaxHeap heap=new MaxHeap(100);
	/** Default constructor ** parameterized constructor*/
	public EntryNode() {
		// TODO Auto-generated constructor stub
	}
	/** Default constructor ** parameterized constructor*/
	public EntryNode(String namenode,String gendernode) {
		this.KeyName=namenode;
		this.valueGender=gendernode;
	}
	/** Default constructor ** parameterized constructor*/
	EntryNode(String KeyName, String valueGender, byte statusNode) {
		this.KeyName = KeyName;
		this.valueGender = valueGender;
		this.statusNode = statusNode;
	}
	/** Return_*/
	public String getKeyName() {
		return KeyName;
	}
	/** Return_*/
	public String getvalueGender() {
		return valueGender;
	}
	/** Return_*/
//	public Object getNode() {
//		return node;
//	}
//	/** Set a new */
//	public void setNode(Object node) {
//		this.node = node;
//	}
	/** Set a new */
	public byte getStatusNode() {
		return statusNode;
	}
	/** Set a new */
	public void isEmpty() {
		statusNode = 0;
	}
	/** Set a new */
	public void setDeleteStatusNode() {
		statusNode = 2;
	}
	/** Return_*/
	public MaxHeap getHeap() {
		return heap;
	}
	/** Set a new */
	public void setHeap(MaxHeap heap) {
		this.heap = heap;
	}

    
	/***
	 * Print_in_var_on_class
	 * **/
	@Override
	public String toString() {
	////to String in_Node
		return "\t" + KeyName + " , " + valueGender + " , " + heap.printSort() +"Status_Node equal--> "+statusNode+ "\n\n";
	}
	
}

