import java.io.File;

public class TRecord implements Comparable<TRecord>{
	
	private String Name;
	private String gender;
	private int freq;
	String getyear;
	//private Linkedlist<Baby_frequencies> Baby = new Linkedlist<Baby_frequencies>();
	
	public TRecord(String line/*,File file*/) {
		int firstQ = line.indexOf(',');
		int secondQ = line.lastIndexOf(',');
		Name = (line.substring(0,firstQ).trim());
		freq= Integer.parseInt(line.substring(secondQ+1).trim());
		gender = (line.substring(firstQ+1, secondQ).trim());
//		String x = file.getName();
//        getyear = x.substring(7, 11);
//        int year = Integer.parseInt(getyear);
	}
	
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

   
	public String getGetyear() {
		return getyear;
	}

	public void setGetyear(String getyear) {
		this.getyear = getyear;
	}

//	public Linkedlist<Baby_frequencies> getBaby() {
//		return Baby;
//	}
//
//	public void setBaby(Linkedlist<Baby_frequencies> baby) {
//		Baby = baby;
//	}

	@Override
	public int compareTo(TRecord o) {
		// TODO Auto-generated method stub
		// the old way to implement CompareTo method to compare 
		// object by multiple fields, you'll learn new way as well
		
		int i = this.getName().compareTo(o.Name);
		if (i > 0) return 1; 
		else if (i < 0) return -1; 
		else {
			
		i = this.getGender().compareTo(o.gender); 
		if (i > 0) return 1;  
		else if (i < 0) return -1; 
		else return 0 ;
		
		}
	}
	public boolean equals(Object o){
		
		if(o instanceof TRecord){
			TRecord record =(TRecord)o;
			if(this.Name == record.Name && this.gender == record.gender ){
				return true ;
			}
		}
			return false;
	}


	@Override
	public String toString() {
		return "" + Name + " , " + gender +" , ";
	}
}

