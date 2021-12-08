//Mohammad hlhwly -1191413
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.jar.JarOutputStream;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Mainfx extends Application{
	Stage start;
	Stage textfild;
	static TextField aaa;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//fx in project
		try {
			//button start
		Button butStar=new Button("Start");
		butStar.setTranslateX(50);
		butStar.setTranslateY(50);
			//button exit
		Button exit=new Button("Exit");
		butStar.setTranslateX(200);
		butStar.setTranslateY(250);
		exit.setOnAction(e -> primaryStage.close());
		Group root = new Group(exit,butStar);
		
		Pane gp =new Pane();
		aaa=new TextField();
		
		Menu Sellshares=new Menu("Sell shares");
		MenuItem item1 = new MenuItem("A name-gender does not exist in the AVL tree");
			//selected Menuitem 
			item1.setOnAction(e ->{
			//	fxproject.display1("javafx","Queue");
			});
		MenuItem item2 = new MenuItem("A name-gender exists as a node in the tree ");
		TextField f=new TextField();
		Text si=new Text("Size Array hash");
		
		f.setTranslateX(50);
		si.setTranslateX(50);
		f.setTranslateY(50);
		item2.setOnAction(e ->{
			String x=f.getText();
			try {
				fxproject.display2("javafx",Integer.parseInt(x));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Sellshares.getItems().addAll(item1,item2);
		MenuBar menuBar = new MenuBar(Sellshares);
		Button shwoData=new Button("Show data  ");
		shwoData.setTranslateX(10);
		shwoData.setTranslateY(100);
		start=new Stage();
		start.setTitle("m");
		gp.getChildren().addAll(menuBar,f,si);
		Scene scenest=new Scene(gp, 400, 400,Color.RED);
		start.setScene(scenest);
		butStar.setOnAction(e ->{
			start.show();
			primaryStage.close();
		});		
		Scene scene=new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	

}
