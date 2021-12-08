

public class Baby_frequencies  implements Comparable<Baby_frequencies>{
	private int freq;
	private int year;
	
	
	public Baby_frequencies(int freq, int year) {
		this.freq = freq;
		this.year = year;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "[freq=" + freq + ", year=" + year + "]";
	}
	
	@Override
	public int compareTo(Baby_frequencies o) {
		return (freq - o.freq );
	}
	//////8 Day
}
