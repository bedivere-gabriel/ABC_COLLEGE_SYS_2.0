import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class student_form {
	Student studentObj = new Student();
	int index2 = 0;
	String[] moduleList = studentObj.getModuleList();
	String[] selectedModules = new String[6];
	

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void JavaSwingStudentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_form window = new student_form();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setOpacity(1.0f);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("ABC College Financial Management");
		frame.setBounds(100, 100, 600, 500);
		frame.getContentPane().setLayout(null);
		
		//Model
		DefaultListModel dm = new DefaultListModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 205, 439);
		frame.getContentPane().add(scrollPane);
		
		JList listofModules = new JList(moduleList);
		scrollPane.setViewportView(listofModules);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(485, 427, 89, 23);
		frame.getContentPane().add(btnReturn);
		
		JList listofSelectedModules = new JList(selectedModules);
		listofSelectedModules.setBounds(272, 12, 189, 177);
		frame.getContentPane().add(listofSelectedModules);
		listofSelectedModules.setModel(dm);
		
		JButton addButton = new JButton(">");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int index = listofModules.getSelectedIndex();
			    if(index >= 0 && index <= studentObj.getModuleList().length && selectedModules[5] == null){
			    	dm.addElement(moduleList[index]);
			    	selectedModules[index2] = moduleList[index];
			    	index2++;
			    	for (int x = 0; x < 6; x++)
			    		System.out.println(selectedModules[x]);
			    }
			}
		});
		addButton.setBounds(221, 66, 41, 23);
		frame.getContentPane().add(addButton);
		
		JButton removeButton = new JButton("<");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listofSelectedModules.getSelectedIndex();
				if (index >= 0 && index <= selectedModules.length && listofSelectedModules != null)
				{
					dm.removeElementAt(index);
					
					selectedModules[index] = null;
					index2--;
			    	for (int x = 0; x < 6; x++)
			    		System.out.println(selectedModules[x]);
				}
			}
		});
		removeButton.setBounds(221, 100, 41, 23);
		frame.getContentPane().add(removeButton);
		
		textField = new JTextField();
		textField.setBounds(471, 43, 103, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("No. of Repeat Modules");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(471, 24, 103, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Main javaswingmain = new Main();
				javaswingmain.main(null);
				frame.dispose();
			}
		});

	}
}
