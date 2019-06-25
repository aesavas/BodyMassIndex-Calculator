package Project;
/*
Author aesavas
 */

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class ModelViewControllerMain {
	
	public static void main(String[] args) {

		try{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			BMIView theview = new BMIView();
			BMIModel theModel = new BMIModel();
			BMIController theController = new BMIController(theModel, theview);
			theview.setTitle("Body Mass Index - Ideal Weight Calculator");
			theview.setResizable(false);
			theview.setSize(580, 300);
			theview.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
