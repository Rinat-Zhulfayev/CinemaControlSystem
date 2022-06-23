package admin;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GUI.MovieModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class EditSelectMovieGui extends JFrame {

	private JPanel contentPane;
	public static String selected_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSelectMovieGui frame = new EditSelectMovieGui();
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
	public EditSelectMovieGui() {
		setTitle("Edit movie");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT MOVIE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(131, 88, 377, 133);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AdminGui admingui = new AdminGui();
				admingui.setVisible(true);
			}
		});
		btnNewButton.setBounds(112, 539, 150, 61);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		
		Choice choice = new Choice();
		choice.setForeground(Color.RED);
		choice.setFont(new Font("Dialog", Font.PLAIN, 25));
		choice.setBackground(Color.WHITE);
		choice.setBounds(131, 290, 480, 89);
		for (int i=0;i<MovieModel.movie_list.size();i++) {
			choice.add(MovieModel.movie_list.get(i).getMovie_name());
		}
		contentPane.add(choice);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.getSelectedItem()!=null) {
					close();
					selected_name=choice.getSelectedItem();
					AddGui frame = new AddGui("EDIT MOVIE","Edit");
					frame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "It has to be a movie to edit.");
				
			}
		});
		btnNext.setBounds(415, 539, 150, 61);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNext);
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
