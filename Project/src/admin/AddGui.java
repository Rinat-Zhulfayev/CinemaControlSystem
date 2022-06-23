package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CCS.Admin;
import CCS.Movie;
import GUI.MovieModel;

public class AddGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGui frame = new AddGui("NEW MOVIE", "ADD");
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
	public AddGui(String name, String gui) {
		setTitle("Add movie");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(180, 10, 299, 117);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NAME:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(105, 125, 149, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("LANGUAGE:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(105, 166, 149, 32);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("RELEASE DATE");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(105, 207, 149, 32);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("TRAILER:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(105, 248, 149, 32);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("POSTER:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(105, 289, 149, 32);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("DESCRIPTION:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_5.setBounds(105, 330, 149, 32);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("GENRE:");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6.setBackground(Color.WHITE);
		lblNewLabel_1_6.setBounds(105, 371, 149, 32);
		contentPane.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_6_1 = new JLabel("DURATION:");
		lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_1.setForeground(Color.BLACK);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1.setBackground(Color.WHITE);
		lblNewLabel_1_6_1.setBounds(105, 412, 149, 32);
		contentPane.add(lblNewLabel_1_6_1);

		JLabel lblNewLabel_1_6_2 = new JLabel("DIRECTOR:");
		lblNewLabel_1_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_2.setForeground(Color.BLACK);
		lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_2.setBackground(Color.WHITE);
		lblNewLabel_1_6_2.setBounds(105, 453, 149, 32);
		contentPane.add(lblNewLabel_1_6_2);

		JLabel lblNewLabel_1_6_3 = new JLabel("HALL NUMBER:");
		lblNewLabel_1_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_3.setForeground(Color.BLACK);
		lblNewLabel_1_6_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_3.setBackground(Color.WHITE);
		lblNewLabel_1_6_3.setBounds(105, 494, 149, 32);
		contentPane.add(lblNewLabel_1_6_3);

		JLabel lblNewLabel_1_6_3_1 = new JLabel("SEANCES:");
		lblNewLabel_1_6_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_6_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_6_3_1.setBounds(105, 535, 149, 32);
		contentPane.add(lblNewLabel_1_6_3_1);

		textField = new JTextField();
		textField.setBounds(298, 125, 229, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(298, 166, 229, 32);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && textField_2.getText().length() < 4) {
					textField_2.setEditable(true);
				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textField_2.setEditable(true);
					textField_2.setText(textField_2.getText().substring(0, textField_2.getText().length()));
				}

				else
					textField_2.setEditable(false);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(298, 207, 229, 32);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(298, 248, 229, 32);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(298, 289, 229, 32);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(298, 330, 229, 32);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(298, 371, 229, 32);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && textField_7.getText().length() < 3) {
					textField_7.setEditable(true);
				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textField_7.setEditable(true);
					textField_7.setText(textField_7.getText().substring(0, textField_7.getText().length()));
				}

				else
					textField_7.setEditable(false);
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(298, 412, 229, 32);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(298, 453, 229, 32);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && textField_9.getText().length() < 3) {
					textField_9.setEditable(true);
				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textField_9.setEditable(true);
					textField_9.setText(textField_9.getText().substring(0, textField_9.getText().length()));
				}

				else
					textField_9.setEditable(false);
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(298, 494, 229, 32);
		contentPane.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(298, 535, 229, 32);
		contentPane.add(textField_10);

		if (gui.equalsIgnoreCase("edit"))
			fill_about_moviedetail(EditSelectMovieGui.selected_name);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()
						|| textField_5.getText().isEmpty() || textField_6.getText().isEmpty()
						|| textField_7.getText().isEmpty() || textField_8.getText().isEmpty()
						|| textField_9.getText().isEmpty() || textField_10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all blanks.");

				} else {

					if (gui.equalsIgnoreCase("add")) {
						Movie movie = new Movie();
						movie.setMovie_name(textField.getText());
						movie.setMovie_language(textField_1.getText());
						movie.setRelease_date(Integer.parseInt(textField_2.getText()));
						movie.setTrailer(textField_3.getText());
						movie.setPoster(textField_4.getText());
						movie.setTemp_poster(textField_4.getText());
						movie.setDescription(textField_5.getText());
						movie.setGenre(textField_6.getText());
						movie.setDuration(Integer.parseInt(textField_7.getText()));
						movie.setDirector(textField_8.getText());
						movie.setHall_number(Integer.parseInt(textField_9.getText()));
						movie.setSeances(Arrays.asList(textField_10.getText().split(";")));
						Admin.addMovie(movie);
						JOptionPane.showMessageDialog(null, "The Movie is added.");
						close();
						AdminGui admingui = new AdminGui();
						admingui.setVisible(true);
					} else {
						Admin.editMovie(EditSelectMovieGui.selected_name, values());
						JOptionPane.showMessageDialog(null, "Movie information has been updated.");
						close();
						EditSelectMovieGui frame = new EditSelectMovieGui();
						frame.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(401, 600, 111, 53);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gui.equalsIgnoreCase("add")) {
					close();
					AdminGui admingui = new AdminGui();
					admingui.setVisible(true);
				} else {
					close();
					EditSelectMovieGui frame = new EditSelectMovieGui();
					frame.setVisible(true);
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(161, 600, 111, 53);
		contentPane.add(btnNewButton_1);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public void fill_about_moviedetail(String name) {
		for (int i = 0; i < MovieModel.movie_list.size(); i++) {
			if (name.equalsIgnoreCase(MovieModel.movie_list.get(i).getMovie_name())) {
				textField.setText(MovieModel.movie_list.get(i).getMovie_name());
				textField_1.setText(MovieModel.movie_list.get(i).getMovie_language());
				textField_2.setText(String.valueOf(MovieModel.movie_list.get(i).getRelease_date()));
				textField_3.setText(MovieModel.movie_list.get(i).getTrailer());
				textField_4.setText(MovieModel.movie_list.get(i).getTemp_poster());
				// ///
				textField_5.setText(MovieModel.movie_list.get(i).getDescription());
				textField_6.setText(MovieModel.movie_list.get(i).getGenre());
				textField_7.setText(String.valueOf(MovieModel.movie_list.get(i).getDuration()));
				textField_8.setText(MovieModel.movie_list.get(i).getDirector());
				textField_9.setText(String.valueOf(MovieModel.movie_list.get(i).getHall_number()));
				String temp = "";
				for (int j = 0; j < MovieModel.movie_list.get(i).getSeances().size(); j++) {
					temp += MovieModel.movie_list.get(i).getSeances().get(j).getDate().getYear() + ","
							+ MovieModel.movie_list.get(i).getSeances().get(j).getDate().getMonth() + ","
							+ MovieModel.movie_list.get(i).getSeances().get(j).getDate().getDate() + ","
							+ MovieModel.movie_list.get(i).getSeances().get(j).getDate().getHours() + ","
							+ MovieModel.movie_list.get(i).getSeances().get(j).getDate().getMinutes() + ";";
				}
				temp = temp.substring(0, temp.length() - 1);
				System.out.println(temp);
				textField_10.setText(temp);
				break;
			}
		}
	}

	public String values() {
		return textField.getText() + "," + textField_1.getText() + "," + String.valueOf(textField_2.getText()) + ","
				+ textField_3.getText() + "," + textField_4.getText() + "," + textField_5.getText() + ","
				+ textField_6.getText() + "," + String.valueOf(textField_7.getText()) + "," + textField_8.getText()
				+ "," + String.valueOf(textField_9.getText() + "," + textField_10.getText());
	}
}
