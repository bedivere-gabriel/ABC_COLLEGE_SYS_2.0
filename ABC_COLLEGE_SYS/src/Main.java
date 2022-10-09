import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Main {

	private JFrame frmAbcCollegeFinancial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAbcCollegeFinancial.setVisible(true);
					window.frmAbcCollegeFinancial.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbcCollegeFinancial = new JFrame();
		frmAbcCollegeFinancial.setOpacity(1.0f);
		frmAbcCollegeFinancial.setResizable(false);
		frmAbcCollegeFinancial.setTitle("ABC College Financial Management");
		frmAbcCollegeFinancial.setBounds(100, 100, 600, 500);
		frmAbcCollegeFinancial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbcCollegeFinancial.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC COLLEGE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 24));
		lblNewLabel.setBounds(217, 64, 145, 32);
		frmAbcCollegeFinancial.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FINANCIAL MANAGEMENT SYSTEM");
		lblNewLabel_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(151, 107, 294, 32);
		frmAbcCollegeFinancial.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("TEACHER");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(151, 285, 105, 23);
		frmAbcCollegeFinancial.getContentPane().add(btnNewButton);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnStudent.setBackground(SystemColor.menu);
		btnStudent.setBounds(340, 285, 105, 23);
		frmAbcCollegeFinancial.getContentPane().add(btnStudent);
		
		btnStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				student_form javaswingstudent = new student_form();
				javaswingstudent.JavaSwingStudentScreen();
				frmAbcCollegeFinancial.dispose();
			}
		});
	}
}
