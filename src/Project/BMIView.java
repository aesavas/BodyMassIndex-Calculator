package Project;
/**
Author aesavas
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import Project.BMIController.RadioButtonListener;

// View class includes graphical user interface's elements.
public class BMIView extends JFrame {

	private JPanel contentPane;
	private JComboBox<Integer> comboBoxHeight;
	private JSlider slider;
	private JLabel label1, label2, label3, labelwomen, labelmen;
	private JRadioButton radioButtonMen, radioButtonWomen;
	private ButtonGroup grup;
	private JLabel lblCm;
	private JButton btnCalculate;
	private String heightValue;
	private String select;



	/**
	 * Create the frame.
	 */
	public BMIView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Eat healthy, become healthy!"));

		/**
		 * Height comboBox and height label part.
		 */
		label1 = new JLabel("Please, choose height  :");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label1.setBounds(34, 25, 150, 30);
		contentPane.add(label1);

		comboBoxHeight = new JComboBox<Integer>();
		comboBoxHeight.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBoxHeight.setBounds(190, 25, 150, 30);
		contentPane.add(comboBoxHeight);
		for (int i = 135; i <= 220; i++) {
			comboBoxHeight.addItem(i);
		}

		lblCm = new JLabel("cm.");
		lblCm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCm.setBounds(345, 30, 46, 14);
		contentPane.add(lblCm);

		/**
		 * Weight slider and weight label part
		 */
		label2 = new JLabel("Please, choose weight :");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label2.setBounds(34, 70, 150, 30);
		contentPane.add(label2);

		slider = new JSlider(40, 160);
		slider.setBounds(190, 75, 350, 40);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
		contentPane.add(slider);
		event e = new event();
		slider.addChangeListener(e);

		label3 = new JLabel("Weight : " + slider.getValue());
		label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label3.setBounds(300, 100, 123, 65);
		contentPane.add(label3);

		grup = new ButtonGroup();

		/**
		 * Radiobutton and icon section for Male.
		 */
		radioButtonMen = new JRadioButton("Male");
		grup.add(radioButtonMen);
		radioButtonMen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		radioButtonMen.setBounds(120, 150, 74, 46);
		contentPane.add(radioButtonMen);
		radioButtonMen.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				select = "Male";

			}
		});

		labelmen = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("../images/men.png"))
				.getImage();
		labelmen.setIcon(new ImageIcon(img));
		labelmen.setBounds(160, 150, 40, 40);
		contentPane.add(labelmen);

		/**
		 * Radiobutton and icon section for Female.
		 */
		radioButtonWomen = new JRadioButton("Female");
		grup.add(radioButtonWomen);
		radioButtonWomen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		radioButtonWomen.setBounds(350, 150, 82, 36);
		contentPane.add(radioButtonWomen);
		radioButtonWomen.addItemListener(new ItemListener() {
			@Override
			// Bu kýsýmlarý burada yapmam MVC stiline uyar mý bilmiyorum.
			public void itemStateChanged(ItemEvent e) {
				select = "Female";

			}
		});

		labelwomen = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("../images/women.png"))
				.getImage();
		labelwomen.setIcon(new ImageIcon(img2));
		labelwomen.setBounds(410, 150, 40, 40);
		contentPane.add(labelwomen);


		/**
		 * Calculate button section
		 */
		btnCalculate = new JButton("Calculate !");
		Image img3 = new ImageIcon(this.getClass().getResource("../images/tarti.png"))
				.getImage();
		btnCalculate.setIcon(new ImageIcon(img3));

		btnCalculate.setBounds(215, 200, 130, 40);
		contentPane.add(btnCalculate);
	}

	/**
	 * Used to dynamically show the value selected from the slider.
	 */
	public class event implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int value = slider.getValue();
			label3.setText("Weight : " + value);

		}
	}

	/**
	 * It enables other classes to reach the weight value.
	 */
	public double getHeightValue() {
		heightValue = String.valueOf(comboBoxHeight.getSelectedItem());
		return Double.parseDouble(heightValue);
	}

	/**
	 * It enables other classes to reach the weight value.
	 */
	public double getWeightValue() {
		double weightValue = slider.getValue();
		return weightValue;
	}

	/**
	 *
	 * @param bmi -> Show BMI result
	 * @param idealkg -> Indicates the required weight.
	 */
	public void setResult(double bmi, double idealkg) {
		NumberFormat numberFormat = NumberFormat.getInstance();

		if (bmi < 20) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 20 && bmi < 25) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 25 && bmi < 30) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 30 && bmi < 35) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 35 && bmi < 45) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 45 && bmi < 50) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		} else if (bmi >= 50) {
			JOptionPane.showMessageDialog(null, "Body Mass Index : "
					+ numberFormat.format(bmi) + "\n" + "You must be : "
					+ numberFormat.format(idealkg) + " kg.");
		}
	}

	public String radioButtonActionListener(ActionEvent ae) {
		return ae.getActionCommand();
	}

	public String getRadioButton() {
		return select;
	}

	void addCalculateListener(ActionListener al) {
		btnCalculate.addActionListener(al);
	}

}
