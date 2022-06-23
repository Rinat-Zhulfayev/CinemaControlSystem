package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.LoginGui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class AdminGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGui admingui = new AdminGui();
					admingui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Admin");
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMIN PRIVILEGES");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 10, 306, 156);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("ADD MOVIE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AddGui frame = new AddGui("NEW MOVIE", "ADD");
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(231, 173, 182, 72);
		contentPane.add(btnNewButton);

		JButton btnEdtMove = new JButton("EDIT MOVIE");
		btnEdtMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				EditSelectMovieGui frame = new EditSelectMovieGui();
				frame.setVisible(true);
			}
		});
		btnEdtMove.setBackground(Color.DARK_GRAY);
		btnEdtMove.setForeground(Color.RED);
		btnEdtMove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdtMove.setBounds(231, 291, 182, 72);
		contentPane.add(btnEdtMove);

		JButton btnDeleteMove = new JButton("DELETE MOVIE");
		btnDeleteMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				DeleteGui frame = new DeleteGui();
				frame.setVisible(true);
			}
		});
		btnDeleteMove.setBackground(Color.DARK_GRAY);
		btnDeleteMove.setForeground(Color.RED);
		btnDeleteMove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteMove.setBounds(231, 408, 182, 72);
		contentPane.add(btnDeleteMove);

		JButton btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
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
		btnExt.setForeground(Color.RED);
		btnExt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExt.setBackground(Color.DARK_GRAY);
		btnExt.setBounds(231, 525, 182, 72);
		contentPane.add(btnExt);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
