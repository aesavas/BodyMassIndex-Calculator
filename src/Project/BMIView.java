package Project;

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

public class BMIView extends JFrame {

	private JPanel contentPane;
	private JComboBox<Integer> comboBoxHeight;
	private JLabel label1;
	private JSlider slider;
	private JLabel label2, label3, labelwomen, labelmen;
	private JRadioButton radioButtonMen, radioButtonWomen;
	private ButtonGroup grup;
	private JLabel lblCm;
	private JButton btnCalculate;
	// private String radioButton2;
	private String heightValue;
	private String select;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIView frame = new BMIView();
					frame.setTitle("Body Mass Index");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		contentPane.setBorder(BorderFactory
				.createTitledBorder("Eat healthy, become healthy!"));

		label1 = new JLabel("Please, choose height  :");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label1.setBounds(34, 25, 269, 54);
		contentPane.add(label1);

		comboBoxHeight = new JComboBox<Integer>();
		comboBoxHeight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxHeight.setBounds(286, 25, 176, 54);
		contentPane.add(comboBoxHeight);
		for (int i = 145; i <= 210; i++) {
			comboBoxHeight.addItem(i);
		}

		slider = new JSlider(40, 130);
		slider.setBounds(286, 126, 477, 79);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
		contentPane.add(slider);
		event e = new event();// MVC stiline uyuyor mu bilmiyorum. Ama bu o an
								// slider deðiþilik yapýldýðýnda ekranda
								// gözükmesi için
		slider.addChangeListener(e);

		label2 = new JLabel("Please, choose weight :");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label2.setBounds(34, 126, 231, 72);
		contentPane.add(label2);

		label3 = new JLabel("Weight : " + slider.getValue());// Bu ilk
																// açýldýðýnda
																// weight
																// yazýsýnýn boþ
																// kalmamasý
																// için
		label3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label3.setBounds(440, 216, 123, 65);
		contentPane.add(label3);

		grup = new ButtonGroup();

		radioButtonMen = new JRadioButton("Male");

		grup.add(radioButtonMen);
		radioButtonMen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		radioButtonMen.setBounds(101, 337, 74, 46);
		contentPane.add(radioButtonMen);

		radioButtonWomen = new JRadioButton("Female");
		grup.add(radioButtonWomen);
		radioButtonWomen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		radioButtonWomen.setBounds(99, 440, 82, 36);
		contentPane.add(radioButtonWomen);

		radioButtonMen.addItemListener(new ItemListener() {
			// Bu kýsýmlarý burada yapmam MVC stiline uyar mý bilmiyorum.
			@Override
			public void itemStateChanged(ItemEvent e) {
				select = "Male";

			}
		});

		radioButtonWomen.addItemListener(new ItemListener() {

			@Override
			// Bu kýsýmlarý burada yapmam MVC stiline uyar mý bilmiyorum.
			public void itemStateChanged(ItemEvent e) {
				select = "Female";

			}
		});

		labelmen = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("../images/men.png"))
				.getImage();
		labelmen.setIcon(new ImageIcon(img));
		labelmen.setBounds(187, 337, 48, 54);
		contentPane.add(labelmen);

		labelwomen = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("../images/women.png"))
				.getImage();
		labelwomen.setIcon(new ImageIcon(img2));
		labelwomen.setBounds(187, 435, 48, 54);
		contentPane.add(labelwomen);

		lblCm = new JLabel("cm.");
		lblCm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCm.setBounds(472, 48, 46, 14);
		contentPane.add(lblCm);

		btnCalculate = new JButton("");
		Image img3 = new ImageIcon(this.getClass().getResource("../images/scale.png"))
				.getImage();
		btnCalculate.setIcon(new ImageIcon(img3));

		btnCalculate.setBounds(369, 350, 257, 139);
		contentPane.add(btnCalculate);
		

	}

	public class event implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int value = slider.getValue();
			label3.setText("Weight : " + value);

		}
	}

	public double getHeightValue() {
		heightValue = String.valueOf(comboBoxHeight.getSelectedItem());
		return Double.parseDouble(heightValue);
	}

	public double getWeightValue() {
		double weightValue = slider.getValue();
		// double weightValue2 = (double)(weightValue);
		double weightvalue = (double) weightValue;
		return weightvalue;
	}

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

		// radioButton2 = ae.getActionCommand();
		// return radioButton;
	}

	public String getRadioButton() {

		return select;
	}

	void addCalculateListener(ActionListener al) {
		btnCalculate.addActionListener(al);
	}

}
