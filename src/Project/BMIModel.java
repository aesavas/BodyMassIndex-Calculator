package Project;
/*
Author aesavas
 */

// Model class has functions for calculations.
public class BMIModel {
	private BMIView theview;
	private double bMIResult = 0.0;
	private double idealKg = 0.0;

	public void calculateBMI(double weight, double height) {
		height = height / 100;
		bMIResult = weight / (height * height);
	}

	public void calculateIdealWeight(double height, String select) {

		if (select.equalsIgnoreCase("Male")) {

			idealKg = 50 + 2.3 * ((height * 0.393700787) - 60);

		}
		if (select.equalsIgnoreCase("Female")) {

			idealKg = 45.5 + 2.3 * ((height * 0.393700787) - 60);

		}
	}

	public double getbMIResult() {
		return bMIResult;
	}

	public double getidealKg() {
		return idealKg;
	}

}
