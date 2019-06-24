package Project;

public class ModelViewControllerMain {
	
	public static void main(String[] args) {
		try{
			BMIView theview = new BMIView();
			BMIModel theModel = new BMIModel();
			BMIController theController = new BMIController(theModel, theview);
			theview.setTitle("Body Mass Index - Ideal Weight Calculator");
			theview.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
