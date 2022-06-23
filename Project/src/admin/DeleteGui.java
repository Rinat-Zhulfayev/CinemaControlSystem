package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CCS.Admin;
import GUI.MovieModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DeleteGui extends JFrame {

	private JPanel contentPane;
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGui frame = new DeleteGui();
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
	public DeleteGui() {
		setTitle("Delete movie");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DELETE MOVIE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(146, 46, 377, 186);
		contentPane.add(lblNewLabel);

		choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.setFont(new Font("Dialog", Font.PLAIN, 25));
		choice.setBackground(Color.WHITE);
		choice.setBounds(178, 255, 384, 38);
		contentPane.add(choice);

		fillingchoice_select();
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MovieModel.movie_list.size() != 0) {
					Admin.deleteMovie(choice.getSelectedItem());
					choice.remove(choice.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Selected movie deleted.");
				} else
					JOptionPane.showMessageDialog(null, "It has to be a movie to delete.");

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(392, 498, 150, 61);
		contentPane.add(btnDelete);

		JButton btnDelete_1 = new JButton("BACK");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AdminGui admingui = new AdminGui();
				admingui.setVisible(true);
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete_1.setBounds(128, 498, 150, 61);
		contentPane.add(btnDelete_1);
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public void fillingchoice_select() {
		for (int i = 0; i < MovieModel.movie_list.size(); i++) {
			choice.add(MovieModel.movie_list.get(i).getMovie_name());
		}
	}
}
