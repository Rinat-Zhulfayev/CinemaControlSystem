package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegistrationGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	JCheckBox showPassword;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationGui frame = new RegistrationGui();
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
	public RegistrationGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setTitle("Registration");
		setResizable(false);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(171, 20, 322, 114);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(71, 154, 164, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(71, 218, 164, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONFIRM PASSWORD:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(71, 282, 164, 36);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("EMAIL:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(71, 338, 164, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("PHONE NUMBER:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(71, 397, 164, 36);
		contentPane.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(302, 157, 294, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(302, 221, 294, 36);
		contentPane.add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setColumns(10);
		passwordField2.setBounds(302, 282, 294, 36);
		contentPane.add(passwordField2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(302, 341, 294, 36);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(302, 397, 294, 36);
		contentPane.add(textField_4);
		
		showPassword =  new JCheckBox("Show Password");
		showPassword.setBounds(250, 450, 120, 30);
		showPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showPassword) {
					if (showPassword.isSelected()) {
						passwordField.setEchoChar((char) 0);
						passwordField2.setEchoChar((char) 0);
					} else {
						passwordField.setEchoChar('*');
						passwordField2.setEchoChar('*');
					}
				}
			}
		});
		contentPane.add(showPassword);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginGui frame;
				try {
					frame = new LoginGui();
					frame.setVisible(true);
				} catch (NumberFormatException | IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(133, 557, 130, 67);
		contentPane.add(btnNewButton);
		
		JButton btnRegster = new JButton("REGISTER");
		btnRegster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals(textField_2.getText()) && !textField.getText().equals("")
						&& !textField_3.getText().equals("") && !textField_4.getText().equals("") && !textField_1.getText().equals("")
						&& !Utils.login(textField.getText(), textField_1.getText())) {
					User user = new User( textField.getText(), textField_3.getText(), textField_4.getText(), textField_1.getText());
					Utils.saveToFile(user);
					JOptionPane.showMessageDialog(null, "Registration is successfull");
					close();
					LoginGui frame;
					try {
						frame = new LoginGui();
						frame.setVisible(true);
					} catch (NumberFormatException | IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} else {
					JOptionPane.showMessageDialog(null,
							"Wrong error! This user is already exist or password and confirm password are not equal!");
				}
			}
		});
		btnRegster.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegster.setBounds(428, 557, 130, 67);
		contentPane.add(btnRegster);
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
