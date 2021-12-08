import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class fxproject {
	static String[] values;
	static String data;
	static String Name;
	static String gender;
	static int year;
	static String content ; 
	static FileWriter fileName;
	//static HashMap tr ;
//	static AVLTree<TRecord> tr2 = new AVLTree<>();
//	static Linkedlist<Integer> myListo = new Linkedlist<Integer>();
	static File file;
	private static Desktop desktop = Desktop.getDesktop();
	static  File selfold;
	static String f;

	public static void display2(String title, int size) throws Exception{
		HashMap	tr = new HashMap(size);
		Stage windos =new Stage();
		Stage windos1 =new Stage();
		  windos1.setTitle("JavaFX App");
		 
	        DirectoryChooser c = new DirectoryChooser();
	        c.setInitialDirectory(new File("src"));
	         
	        Button buttonc = new Button("Select in folder");
	        TextField link=new TextField();
	        
	        link.setTranslateX(120);
	        buttonc.setOnAction(e -> {
	        	try {
	        	selfold = c.showDialog(windos1);

	            System.out.println(selfold.getAbsolutePath());
	            link.setText(selfold.getAbsolutePath());
	            
	            //f=selectedDirectory.getAbsolutePath();
	        	}catch (Exception e5) {
					// TODO: handle exception
				}
	        });
	        Button log=new Button("Log in the Method");
	        log.setOnAction(e -> {
	        	
	        windos.show();
	        String outlink=(link.getText());
	      


	        	
	        	
	        	
	        	
	        	
	        	File infiledata = new File(outlink);//dif file --> FOLDER 
	    		File[] fodata = infiledata.listFiles();//All File in folde
	    		// Fetching all the files
	    		for (File filedata : fodata) {
	    			if (filedata.isFile()) {

	    				///////
//	    				List<String> results = new ArrayList<String>();
//	    				results.add(file.getName());
//	    				String y ;//.substring(7, 10);
//	    				results=JSON.stringify(y);
//	    				year= Integer.parseInt(y);
//	    				System.out.println(y);
//	    				System.out.println(results);
	    				////
	    				BufferedReader indatafile = null;
	    				String Data = "";
	    				try {
	    					indatafile = new BufferedReader(new FileReader(filedata));

	    					while ((Data = indatafile.readLine()) != null) {
	    						// System.out.println(Data);
	    						// data=in.next();
	    						//split in Array
	    						values = Data.split(",");
	    						Name = values[0];
	    						gender = (values[1]);
	    						year = Integer.parseInt(values[2]);
	    						String stry = Name + "," + gender + "," + year;//string in trecord
//	    						String y = Data.substring(7, 10).trim();
//	    						year= Integer.parseInt(y);
//	    						System.out.println(y);
	    						TRecord n = new TRecord(Data);
	    						String years;//dif string
	    						String x = filedata.getName();//name file exist in folder 
	    						years = x.substring(7, 11);//remove chrachter in name file on 7 at 11
	    				        //casteng year
	    				        int yearinfile=Integer.parseInt(years);
	    						Baby_frequencies m = new Baby_frequencies(n.getFreq(), yearinfile);//object baby(freq,year)
	    						try {
	    						tr.insert2(Name,gender, m);//tr in object avlTree 
	    						}catch (Exception e9) {
									// TODO: handle exception
	    							
								}
	    						//tr.insert2(n, m);
	    						//tr.inser(n,n.getFreq());
	    					}
	    				} catch (IOException e5) {
	    					System.out.println(e5);
	    				} finally {
	    					if (indatafile != null) {
	    						try {
									indatafile.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
	    					}
	    				}
	    			}
	    		}
	    	
	        });

	       log.setTranslateY(30);

	        
	////////////////////////////////	
	    
	
		
		
		
		
		
	    // Create the Labels and TextField
	       //////////////////////////////////
        Label Name_T = new Label("Name :");
        TextField tfnamecompany =new TextField();
        Label gender_T = new Label("Gender:");
        TextField tfgenderOfShares =new TextField();
        //////////////////////////////////////
        Label freq_T = new Label("Freq :");
        TextField tffreqcompany =new TextField();
        Label year_T = new Label("Year:");
        TextField tfyearOfShares =new TextField();
        //////////////////////////////////////
        Button linked =new Button("Show Avl and Linked list");
        Button find_Name_Avl=new Button("Find Name");
        Stage stage=new Stage();
        TextArea n=new TextArea();
        Button ok =new Button("ok");
        ok.setTranslateX(260);
        ok.setTranslateY(260);
        Group gr=new Group();
        ok.setOnAction(e->stage.close());
        gr.getChildren().addAll(n,ok);
        Scene ss=new Scene(gr, 300, 300);
        stage.setScene(ss);
        find_Name_Avl.setOnAction(e->{
        	System.out.println("000000000");
        	
        	String name=(tfnamecompany.getText());
        	String ge=(tfgenderOfShares.getText());
        	System.out.println(name+" "+ge);
        	System.out.println(tr.Search_record(name, ge));
        	String Find=tr.Search_record(name, ge);
        	System.out.println(Find);
        	content=Find;
        	n.setText(Find);
        	stage.show();
        	
        });
        Button addNameandgender =new Button("add Name");
        addNameandgender.setOnAction(e ->{
        
        	String name=(tfnamecompany.getText());
        	String ge=(tfgenderOfShares.getText());
        	tr.inserta_name_and_gender_record(name, ge);
        	//System.out.println(avg);
        	n.setText("Done");
        	stage.show();
//        	}catch (Exception e5) {
//				// TODO: handle exception
//        		e5.printStackTrace();
//			}
        });
        Button removeRecord =new Button("Delete");
        removeRecord.setOnAction(e ->{
        	try {
        		
        	String name=(tfnamecompany.getText());
        	String ge=(tfgenderOfShares.getText());
        	String del=tr.Delete_name_record(name, ge);
        	System.out.println(del);
        	n.setText(del);
        	stage.show();
        	}catch (Exception e5) {
				// TODO: handle exception
			}
        });
        Button addfreq_and_year =new Button("add freq");
        addfreq_and_year.setOnAction(e ->{
        	try {
        	String name=(tfnamecompany.getText());
            String ge=(tfgenderOfShares.getText());
        	String frqString=(tffreqcompany.getText());
        	String yeString=(tfyearOfShares.getText());
        	tr.insert_year_and_freq(name, ge,new Baby_frequencies(Integer.parseInt(frqString),Integer.parseInt(yeString)));
        	System.out.println("Done");
        	n.setText("Done");
        	stage.show();
        	}catch (Exception e5) {
				// TODO: handle exception
			}
        });
        Button Namewithmaxfrequency=new Button("Max freq");
        Namewithmaxfrequency.setOnAction(e -> {
        	try {
        		String x="";
				x=String.valueOf(tr.maxFrequency());
				n.setText(x);
				content=x;
	        	stage.show();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        });
        Button Totalnumberofbabiesin_a_selectedyear=new Button("Update");
        TextField m=new TextField();
        TextField nm=new TextField();
        Totalnumberofbabiesin_a_selectedyear.setOnAction(e -> {
        	try {
        		String x="";
        		String name=(tfnamecompany.getText());
                String ge=(tfgenderOfShares.getText());
                String frqString=(tffreqcompany.getText());
            	String yeString=(tfyearOfShares.getText());
        		String sss="";
        		String sssy="";
        		sss=m.getText();
				sssy=nm.getText();
				tr.updateRecord(name, ge,Integer.parseInt(frqString),Integer.parseInt(yeString), Integer.parseInt(sssy),  Integer.parseInt(sss));
//			
//				System.out.println(sum);
//				n.setText(String.valueOf(sum));
	        	stage.show();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        });
        Button ExporttheAVLtreedatato_a_file =new Button("Read in file");
        ExporttheAVLtreedatato_a_file.setOnAction(e -> {
        	try {
				fileName = new FileWriter("output1.txt",true);
				fileName.write(content);
				fileName.close();
				//Files.writeString(fileName,content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error");
				e1.printStackTrace();
			}
        });
		GridPane root5 = new GridPane();
		 // Set the horizontal spacing to 30px
        root5.setHgap(30);
        // Set the vertical spacing to 15px
        root5.setVgap(15);

        root5.add(Name_T,1,3);
        root5.add(tfnamecompany,2,3);
        root5.add(gender_T,1,4);
        root5.add(tfgenderOfShares,2,4);
        ////////////////////////////////
        root5.add(freq_T,3,3);
        root5.add(tffreqcompany,4,3);
        root5.add(year_T,3,4);
        root5.add(tfyearOfShares,4,4);
        /////////////////////////////////
        root5.add(find_Name_Avl, 1, 7);
        root5.add(removeRecord, 2, 7);
        root5.add(addNameandgender, 1, 9);
        root5.add(addfreq_and_year, 2, 9);
        root5.add(Namewithmaxfrequency, 1, 11);
        root5.add(Totalnumberofbabiesin_a_selectedyear, 1, 13);
        root5.add(ExporttheAVLtreedatato_a_file, 1, 15);
        root5.add(m,4,13);
        root5.add(nm,2,13);
        //root5.add(button, 0, 0);
		// Set the title of the Stage
		windos.setTitle(title);
	
		Scene scene = new Scene(root5,960, 600,Color.RED);
		// Add the scene to the Stage
		windos.setScene(scene);
//		// Display the Stage
		Pane pane=new Pane();
		pane.getChildren().addAll(buttonc,link,log);
		Scene scene1 = new Scene(pane,300,300,Color.RED);
		windos1.setScene(scene1);
		windos1.show();
}
}
	
//	public static void readfile(String namefile) throws IOException {
//		//ًRead in folder 
//		//Creating a File object for directory
////	      File directoryPath = new File(namefile);
////	      //List of all files and directories
////	      File filesList[] = directoryPath.listFiles();
////		
//		
//		File infiledata = new File(namefile);//dif file --> FOLDER 
//		File[] fodata = infiledata.listFiles();//All File in folde
//		// Fetching all the files
//		for (File filedata : fodata) {
//			if (filedata.isFile()) {
//
//				///////
////				List<String> results = new ArrayList<String>();
////				results.add(file.getName());
////				String y ;//.substring(7, 10);
////				results=JSON.stringify(y);
////				year= Integer.parseInt(y);
////				System.out.println(y);
////				System.out.println(results);
//				////
//				BufferedReader indatafile = null;
//				String Data = "";
//				try {
//					indatafile = new BufferedReader(new FileReader(filedata));
//
//					while ((Data = indatafile.readLine()) != null) {
//						// System.out.println(Data);
//						// data=in.next();
//						//split in Array
//						values = Data.split(",");
//						Name = values[0];
//						gender = (values[1]);
//						year = Integer.parseInt(values[2]);
//						String stry = Name + "," + gender + "," + year;//string in trecord
////						String y = Data.substring(7, 10).trim();
////						year= Integer.parseInt(y);
////						System.out.println(y);
//						TRecord n = new TRecord(Data);
//						String years;//dif string
//						String x = filedata.getName();//name file exist in folder 
//						years = x.substring(7, 11);//remove chrachter in name file on 7 at 11
//				        //casteng year
//				        int yearinfile=Integer.parseInt(years);
//						Baby_frequencies m = new Baby_frequencies(n.getFreq(), yearinfile);//object baby(freq,year)
//						tr.insert2(Name,gender, m);//tr in object avlTree 
//						//tr.insert2(n, m);
//						//tr.inser(n,n.getFreq());
//					}
//				} catch (IOException e) {
//					System.out.println(e);
//				} finally {
//					if (indatafile != null) {
//						indatafile.close();
//					}
//				}
//			}
//		}
//	}
//	
