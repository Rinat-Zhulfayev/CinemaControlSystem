package GUI;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import CCS.Movie;
import CCS.Seance;
import javax.swing.JLabel;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class MovieGUI extends JFrame {

	private JPanel contentPane;
	public static Seance selected_seance;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieGUI frame = new MovieGUI(MovieListGUI.selected_movie);
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

	public MovieGUI(Movie movie) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setTitle("Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 730, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame f = new JFrame();

		JLabel picLabel = new JLabel(movie.getPoster());
		picLabel.setBackground(Color.LIGHT_GRAY);
		picLabel.setBounds(10, 10, 250, 350);
		contentPane.add(picLabel);

		JLabel nameLabel = new JLabel("Movie         : " + movie.getMovie_name());
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		nameLabel.setBounds(281, 20, 350, 20);
		contentPane.add(nameLabel);

		JLabel yearLabel = new JLabel("Year           : " + movie.getRelease_date());
		yearLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		yearLabel.setBounds(281, 40, 350, 20);
		contentPane.add(yearLabel);

		JLabel langLable = new JLabel("Language  : " + movie.getMovie_language());
		langLable.setFont(new Font("Verdana", Font.BOLD, 17));
		langLable.setBounds(281, 60, 350, 20);
		contentPane.add(langLable);

		JLabel genreLabel = new JLabel("Genre         : " + movie.getGenre());
		genreLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		genreLabel.setBounds(281, 80, 350, 20);
		contentPane.add(genreLabel);

		JLabel durationLabel = new JLabel("Duration    : " + movie.getDuration() + " min");
		durationLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		durationLabel.setBounds(281, 100, 350, 20);
		contentPane.add(durationLabel);

		JLabel dirLabel = new JLabel("Director     : " + movie.getDirector());
		dirLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		dirLabel.setBounds(281, 120, 350, 20);
		contentPane.add(dirLabel);

		JLabel hallLabel = new JLabel("Hall            : " + movie.getHall_number());
		hallLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		hallLabel.setBounds(281, 140, 350, 20);
		contentPane.add(hallLabel);

		JLabel dateLabel = new JLabel("Date            : " + movie.getSeances().get(0).dateToString());
		dateLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		dateLabel.setBounds(281, 160, 350, 20);
		contentPane.add(dateLabel);

		JButton trailerButton = new JButton("Trailer");
		trailerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(movie.getTrailer()).toURI());
				} catch (Exception e2) {
				}
			}
		});
		trailerButton.setFont(new Font("Verdana", Font.BOLD, 15));
		trailerButton.setBounds(81, 370, 94, 21);
		contentPane.add(trailerButton);

		JLabel descr_label = new JLabel("Description:");
		descr_label.setFont(new Font("Verdana", Font.BOLD, 17));
		descr_label.setBounds(281, 189, 350, 20);
		contentPane.add(descr_label);

		JTextArea description = new JTextArea(movie.getDescription());
		description.setBackground(Color.LIGHT_GRAY);
		description.setFont(new Font("Verdana", Font.PLAIN, 12));
		description.setEditable(false);
		description.setBounds(230, 219, 45, 20);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(description);
		scrollPane.setBounds(281, 220, 291, 60);
		contentPane.add(scrollPane);

		JLabel seancesLabel = new JLabel("Seanses: ");
		seancesLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		seancesLabel.setBounds(281, 290, 89, 22);
		contentPane.add(seancesLabel);

		int x = 281, y = 315;
		JButton[] button_seance = new JButton[movie.getSeances().size()];
		ButtonGroup btn_group = new ButtonGroup();

		for (int i = 0; i < button_seance.length; i++) {
			if (i != 0 && i % 5 == 0) {
				y += 30;
				x = 281;
			}

			button_seance[i] = new JButton(movie.getSeances().get(i).timeToString());
			button_seance[i].setBounds(x, y, 85, 25);
			contentPane.add(button_seance[i]);
			x = x + 90;
			btn_group.add(button_seance[i]);
			button_seance[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < button_seance.length; j++) {
						if (e.getSource() == button_seance[j]) {
							selected_seance = movie.getSeances().get(j);
						}
					}
					close();
					SeatBookingGUI sbg;
					try {
						sbg = new SeatBookingGUI(selected_seance, MovieListGUI.selected_movie);
						sbg.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
