import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap i=new HashMap(100+40);
		//ًRead in folder 
		//Creating a File object for directory
//	      File directoryPath = new File(namefile);
//	      //List of all files and directories
//	      File filesList[] = directoryPath.listFiles();
	//	
		
		File infiledata = new File("files");//dif file --> FOLDER 
		File[] fodata = infiledata.listFiles();//All File in folde
		// Fetching all the files
		for (File filedata : fodata) {
			if (filedata.isFile()) {

				///////
//				List<String> results = new ArrayList<String>();
//				results.add(file.getName());
//				String y ;//.substring(7, 10);
//				results=JSON.stringify(y);
//				year= Integer.parseInt(y);
//				System.out.println(y);
//				System.out.println(results);
				////
				BufferedReader indatafile = null;
				String Data = "";
				try {
					indatafile = new BufferedReader(new FileReader(filedata));

					while ((Data = indatafile.readLine()) != null) {
						// System.out.println(Data);
						// data=in.next();
						//split in Array
//						values = Data.split(",");
//						Name = values[0];
//						gender = (values[1]);
//						year = Integer.parseInt(values[2]);
//						String stry = Name + "," + gender + "," + year;//string in trecord
//						String y = Data.substring(7, 10).trim();
//						year= Integer.parseInt(y);
//						System.out.println(y);
						//TRecord n = new TRecord(Data);
						String[] values = Data.split(",");
						String name = values[0];
						String ge = values[1];
						int grade = Integer.parseInt(values[2]);
						String srt =name+","+ge;
						//node.setKey(name +","+ ge);
						//TRecord n=new TRecord(srt);
						String x = filedata.getName();//name file exist in folder 
						String years = x.substring(7, 11);//remove chrachter in name file on 7 at 11
				        //casteng year
				        int yearinfile=Integer.parseInt(years);
				        //System.out.println(yearinfile);
						Baby_frequencies b=new Baby_frequencies(grade, yearinfile);
						//i.insert2(String.valueOf(n),b);
						i.insert2(name,ge,b);
					}
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					if (indatafile != null) {
						try {
							indatafile.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		//i.find("Quran "," M");
		i.inserta_name_and_gender_record("mohamm", "M");
		i.insert_year_and_freq("mohamm", "M", new Baby_frequencies(5, 2000));
		i.insert_year_and_freq("mohamm", "M", new Baby_frequencies(5, 2200));
//		i.Delete_name_record("mohamm", "M");
		//i.printtableArray();
		//i.Add_Year_freq("Orion", "M", new Baby_frequencies(50,2016));
		//System.out.println(i.maxFrequency());
		
		//System.out.println(i.updateRecord("Orion", "M",871,2015));
		//i.printtableArray();
		//i.printtableArray();
		System.out.println(i.Search_record("Orion", "M"));
		//System.out.println(i.Name_with_max_frequency_record("Abbygayle", "F"));
	}

}
