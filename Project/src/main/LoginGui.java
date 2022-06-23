package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import CCS.Admin;
import GUI.MovieListGUI;
import GUI.MovieModel;
import GUI.MovieModelPointer;
import admin.AdminGui;

import javax.swing.JLabel;
import javax.swing.JList;
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

public class LoginGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static MovieModel movie_model;
	public static MovieModelPointer movie_pointer;
	public static JList movie_list;

	public static boolean guestMode = false;
	JCheckBox showPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public LoginGui() throws NumberFormatException, IOException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		movie_model = new MovieModel();
		movie_pointer = new MovieModelPointer();
		movie_list = new JList(movie_model);
		setResizable(false);
		setTitle("Log-In");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CINEMA CONTROL SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(99, 60, 469, 153);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(213, 222, 231, 59);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(213, 369, 231, 59);
		contentPane.add(lblNewLabel_1_1);

		showPassword = new JCheckBox("Show Password");
		showPassword.setBounds(270, 500, 120, 30);
		showPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showPassword) {
					if (showPassword.isSelected()) {
						passwordField.setEchoChar((char) 0);
					} else {
						passwordField.setEchoChar('*');
					}
				}
			}
		});
		contentPane.add(showPassword);

		textField = new JTextField();
		textField.setBounds(213, 298, 231, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(213, 448, 231, 45);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utils.login(textField.getText(), passwordField.getText())) {
					if (textField.getText().equalsIgnoreCase("admin")) {
						Admin.getInstance();
						close();
						dispose();
						AdminGui admingui = new AdminGui();
						admingui.setVisible(true);
					} else {
						guestMode = false;
						close();
						dispose();
						MovieListGUI mlg;
						try {
							mlg = new MovieListGUI();
							mlg.setVisible(true);
						} catch (NumberFormatException | IOException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} else {
					JOptionPane.showMessageDialog(null, "Wrong login or password");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(69, 573, 127, 59);
		contentPane.add(btnNewButton);

		JButton btnGuest = new JButton("GUEST");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestMode = true;
				close();
				dispose();
				MovieListGUI mlg;
				try {
					mlg = new MovieListGUI();
					mlg.setVisible(true);
				} catch (NumberFormatException | IOException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGuest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuest.setBounds(269, 573, 127, 59);
		contentPane.add(btnGuest);

		JButton btnRegstraton = new JButton("REGISTRATION");
		btnRegstraton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				RegistrationGui frame = new RegistrationGui();
				frame.setVisible(true);
			}
		});
		btnRegstraton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegstraton.setBounds(468, 573, 127, 59);
		contentPane.add(btnRegstraton);
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
