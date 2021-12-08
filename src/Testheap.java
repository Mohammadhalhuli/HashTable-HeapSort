
public class Testheap {
	public static void main(String[] args) {
	MaxHeap i=new MaxHeap(5);
	i.add_heap(new Baby_frequencies(5, 2000));
	i.add_heap(new Baby_frequencies(5, 6000));;
	
	System.out.println(i.updat(new Baby_frequencies(5, 2000),10,2000));
	i.updat(new Baby_frequencies(5, 6000),10,6000);
	System.out.println(i.printSort());;
}
}
