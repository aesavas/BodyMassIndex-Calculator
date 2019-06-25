package Project;
/*
Author aesavas
 */

// Controller class controls the functioning of the program.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class BMIController {
	private BMIModel theModel;
	private BMIView theview;
	private String select;
	
	public BMIController(BMIModel theModel, BMIView theview){
		
		this.theModel = theModel;
		this.theview = theview;
		this.theview.addCalculateListener(new BMIListener());
	}
	
	class BMIListener implements ActionListener{
		double weight,height,bmi,idealkg;
		@Override
		public void actionPerformed(ActionEvent ae) {
			try{
				select = theview.getRadioButton();
				weight = theview.getWeightValue();
				height = theview.getHeightValue();
				theModel.calculateBMI(weight, height);
				theModel.calculateIdealWeight(height,select);
				theview.setResult(theModel.getbMIResult(), theModel.getidealKg());
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theview.radioButtonActionListener(e);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
