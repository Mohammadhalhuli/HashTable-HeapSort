

public class MaxHeap/*<T extends Comparable<T>> */{
	
	private Baby_frequencies[] getHeap_max_Table;
	private int size;
	
	private static final int ROOT = 1;

	
	public Baby_frequencies[] getgetHeap_max_Table() {
		return getHeap_max_Table;
	}
	public void setgetHeap_max_Table(Baby_frequencies[] getHeap_max_Table) {
		getHeap_max_Table = getHeap_max_Table;
	}
	
	public MaxHeap(int MaxSize) {
		this.size = 0;
		getHeap_max_Table = (Baby_frequencies[]) new Baby_frequencies[MaxSize + 1];
	}
    // insert into heap
	public boolean add_heap(Baby_frequencies element) {
		// add the new item to the array
//		Heap_max_Table[++Array_in_Size] = indata;//Inseart data in Array
//		// when heap order is violated, this will fix it
//		swim();//call Methods
		getHeap_max_Table[++size] = element;//Inseart data in Array
//		// when heap order is violated, this will fix it
		swim();
		return true;
	}

	public boolean updat(Baby_frequencies f,int f2,int y) {
		for(int i=1;i<=size;i++){
			if(getHeap_max_Table!=null) {
			if ( ((int)getHeap_max_Table[i].getYear())==(f.getYear())&& ((int)getHeap_max_Table[i].getFreq())==(f.getFreq())){
				getHeap_max_Table[i].setFreq(f2);
				getHeap_max_Table[i].setYear(y);
//			
				return true;
			}
		}}
		return false;
	}
	

	private void swim() {
		int curr = size;
		while (curr > 1 && less(curr / 2, curr)) {
			swap(curr, curr / 2);
			curr = curr / 2;
		}
	}

	private void swap(int curr, int parent) {
		Baby_frequencies temp;
		temp = getHeap_max_Table[curr];
		getHeap_max_Table[curr] = getHeap_max_Table[parent];
		getHeap_max_Table[parent] = temp;
	}

	private boolean less(int i, int j) {
		// (-) <0 the parent is smaller
		// (+) >0 or =0 the parent is larger
		return getHeap_max_Table[i].compareTo(getHeap_max_Table[j]) < 0;
	}

	public Baby_frequencies remove() {
		Baby_frequencies removedElement = getHeap_max_Table[ROOT];
		getHeap_max_Table[ROOT] = getHeap_max_Table[size--];
		sink(ROOT, size);
		getHeap_max_Table[size + 1] = null;
		return removedElement;
	}
    // th esort method 
	public void sort() {

		int n = size;
		while (n > 1) { 
			swap(ROOT, n);// call the swap method
			n--;
			sink(ROOT, n); // call the sink method

		}
	}
	
	// left pos*2 =j
	// right pos*2+1 =j+1

		
	private void sink(int Rightpos,int lastPos) {
	// while k is smaller than either (or both) of the existing children, 
    // exchange with the greater child (so heap order is preserved)

	// left pos*2 =j
	// right pos*2+1 =j+1
	if (Rightpos * 2 <= lastPos && (Rightpos * 2) + 1 <= lastPos) // is_not_Lest
		// terminate when doubling to find the next child
        // fails due to being outside the array
        // (i.e., results in an index bigger than size)
		if (less(Rightpos, Rightpos * 2) || less(Rightpos, (Rightpos * 2) + 1)) {
			 // if right child exists and is larger, we will update this choice
            // remember, if an exchange happens, then one of the children
            // becomes the parent of the other.  to preserve heap order
            // we need the greater child promoted to parent.
			if (less(Rightpos * 2, (Rightpos * 2) + 1)) {// k is greater than its children - stop sinking
				swap(Rightpos, (Rightpos * 2) + 1);
				sink((Rightpos * 2) + 1,lastPos);
			} else {
				swap(Rightpos, Rightpos * 2);// swap child and parent k
				sink(Rightpos * 2,lastPos);  // update position of this sinking parent, 
			}
		}

	}

	public int getSize() {
		return size;
	}


	// print the first node  in heap
	public String printSort1() {
		String str = "";
		for (int i = 1; i <= 1; i++) {
			str += getHeap_max_Table[i] + "---->";
		}
		return str;
	}
	// print the data in heap
	public String printSort() {
		String str = "";
		for (int i = 1; i <= size; i++) {
			str += getHeap_max_Table[i] + "---->";
		}
		return str;
	}
}




//import java.util.Arrays;
//public  class MaxHeap<T extends Comparable<T>> {
//	/*privet in class is varuable**/
//	private T[] Heap_max_Table;
//	private int Array_in_Size;
//	
//	
//	/** Return_*/
//	public T[] getHeap_max_Table() {
//		return Heap_max_Table;
//	}
//	/** Set a new */
//	public void setHeap_max_Table(T[] heap_max_Table) {
//		Heap_max_Table = heap_max_Table;
//	}
//	/** Return_*/
//	public int getArray_in_Size() {
//		return Array_in_Size;
//	}
//	/** Set a new */
//	public void setArray_in_Size(int array_in_Size) {
//		Array_in_Size = array_in_Size;
//	}
//	/** Default constructor ** parameterized constructor*/
//	public MaxHeap(int MaxArray_in_Size) {
//		this.Array_in_Size = 0;
//		Heap_max_Table = (T[]) new Comparable[MaxArray_in_Size + 1];
//	}
//	/*
//	Method insert_data in Array_Heap
//	*/
//	public void add_heap(T indata) {
//		// add the new item to the array
//		Heap_max_Table[++Array_in_Size] = indata;//Inseart data in Array
//		// when heap order is violated, this will fix it
//		swim();//call Methods
//	}
////	public int Find(T Data) {
////		T maximumElement =  Heap_max_Table[0];
////		for (int i = 0; i < Heap_max_Table.length; i++) {
////			maximumElement = Math.max((int) maximumElement,
////					(int) Heap_max_Table[i]);
////			}
////		return maximumElement;
////	
////	}
//	private void swim() {
//		int currant_node = Array_in_Size;
//		while (currant_node > 1 && less(currant_node / 2, currant_node)) {// while k is not root and greater than parent,
//			swap(currant_node, currant_node / 2); // swap exchange it with its parent
//			currant_node = currant_node / 2;
//		}
//	}
//
//	private void swap(int currrant1, int currrant2) {// helper method to exchange items at indices i and j
//		T temp;
//		/***
//		 * Swep in two var for in Array
//		 * **/
//		temp = Heap_max_Table[currrant1];
//		Heap_max_Table[currrant1] = Heap_max_Table[currrant2];
//		Heap_max_Table[currrant2] = temp;
//	}
//
//	private boolean less(int i, int j) {
//		// - < 0 the Parentt is smoal
//		// +>0 || =0 the Parentt is peag
//		return Heap_max_Table[i].compareTo(Heap_max_Table[j]) < 0;
//	}
//	public boolean update(T element) {
//		for(int i=1;i<=Array_in_Size;i++){
//			if ( Heap_max_Table[i].equals(element)){
//				Heap_max_Table[i]=element;
//				for (int j=i/2;j>0;j=j/2) {
//					sink(j, Array_in_Size);
//				}
//				return true;
//			}
//		}
//		return false;
//	}
//	public T remove() {
//		T removedElement = Heap_max_Table[1];
//		Heap_max_Table[1] = Heap_max_Table[Array_in_Size--];
//		sink(1,Array_in_Size);
//		Heap_max_Table[Array_in_Size + 1] = null;
//		return removedElement;
//	}
//
//	public void sort() {
////		 for (int i = Array_in_Size ; i >= 1; i--) {
////		 sinkSort(1, i);
////		 }
//		int n = Array_in_Size;
//		// while k is smaller than either (or both) of the existing children, 
//        // exchange with the greater child (so heap order is preserved)
//		while (n > 1) {
//			swap(1, n);// swap child and parent k
//			n--;
//			// if right child exists and is larger, we will update this choice
//            // remember, if an exchange happens, then one of the children
//            // becomes the parent of the other.  to preserve heap order
//            // we need the greater child promoted to parent.
//			sink(1,n);
//
//		}
//	}
//
//private void sink(int pos, int lastPos) {
//		
//		if (pos * 2 <= lastPos && (pos * 2) + 1 <= lastPos) // is not Leaf
//			if (less(pos, pos * 2) || less(pos, (pos * 2) + 1)) {
//				if (less(pos * 2, (pos * 2) + 1)) {
//					swap(pos, (pos * 2) + 1); // call the swap method
//					sink((pos * 2) + 1, lastPos); // call the sink method
//				} else {
//					swap(pos, pos * 2);  // call the swap method
//					sink(pos * 2, lastPos);  // call the sink method
//				}
//			}
//	}
//	
//	
////	private void sink(int Rightpos,int lastPos) {
////		// while k is smaller than either (or both) of the existing children, 
////        // exchange with the greater child (so heap order is preserved)
////
////		// left pos*2 =j
////		// right pos*2+1 =j+1
////		if (Rightpos * 2 <= lastPos && (Rightpos * 2) + 1 <= lastPos) // is_not_Lest
////			// terminate when doubling to find the next child
////            // fails due to being outside the array
////            // (i.e., results in an index bigger than size)
////			if (less(Rightpos, Rightpos * 2) || less(Rightpos, (Rightpos * 2) + 1)) {
////				 // if right child exists and is larger, we will update this choice
////	            // remember, if an exchange happens, then one of the children
////	            // becomes the parent of the other.  to preserve heap order
////	            // we need the greater child promoted to parent.
////				if (less(Rightpos * 2, (Rightpos * 2) + 1)) {// k is greater than its children - stop sinking
////					swap(Rightpos, (Rightpos * 2) + 1);
////					sink((Rightpos * 2) + 1,lastPos);
////				} else {
////					swap(Rightpos, Rightpos * 2);// swap child and parent k
////					sink(Rightpos * 2,lastPos);  // update position of this sinking parent, 
////				}
////			}
////	}
//	public Double avreginarray() {
//		double total = 0;
//
//        for (int i = 0; i < Heap_max_Table.length; i++) {
//            total += ((Double) Heap_max_Table[i]).doubleValue();
//        }
//        return total/Heap_max_Table.length; 
//	}
//	
//	public void print() {
//		/**
//		 * Print in Array_Heap_Max
//		 * */
//		for (int i_index = 1; i_index<= Array_in_Size / 2; i_index++) {
//			if(Heap_max_Table[i_index]!=null)
//				System.out.print(" the Root is  " + Heap_max_Table[i_index] + "\t lest : " + Heap_max_Table[2 * i_index] + "\t right :"
//						+ Heap_max_Table[2 * i_index + 1]);//indexs in Array
//		}
//	}
//	
//	public String printSort() {
//		
//			/**
//			 * Print in Array_Heap_Max put in soort
//			 * */
//		String printHeap="";
//		for (int i_index = 1; i_index <= Array_in_Size ; i_index++) {
//			printHeap+=(Heap_max_Table[i_index] + "---->");
//		}
//		return printHeap;
//	}
//	public String printSortMax() {
//		/**
//		 * Print in Array_Heap_Max put in soort and print in max in elemant 
//		 * */
//		String printHeap="";
//		for (int i_index = 1; i_index <= 1 ; i_index++) {
//			printHeap+=(Heap_max_Table[1] );
//		}
//		return printHeap;
//	}
//}
