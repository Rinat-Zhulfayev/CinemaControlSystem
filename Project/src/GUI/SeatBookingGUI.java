package GUI;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import CCS.DiscountedTicket;
import CCS.Movie;
import CCS.Seance;
import CCS.Ticket;
import main.LoginGui;

public class SeatBookingGUI extends JFrame implements ItemListener {

	private JPanel contentPane;

	private Choice choice;
	private String ticket_type = "COMMON";
	private static JLabel ticket_price;

	private static int ticket_count = 0;
	private static List<String> selected_seats = new ArrayList<String>();
	private static JLabel selected_seats_label, total_cost_label;
	private JTextField card_num;
	private JTextField card_cvc;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatBookingGUI frame = new SeatBookingGUI(MovieGUI.selected_seance, MovieListGUI.selected_movie);
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
	 * @throws IOException
	 */
	public SeatBookingGUI(Seance selected_seance, Movie selected_movie) throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 620, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Booking");
		JLabel dateLabel = new JLabel(
				"Date: " + selected_seance.timeToString() + "  " + selected_seance.dateToString());
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		dateLabel.setBounds(22, 20, 300, 21);
		contentPane.add(dateLabel);

		JPanel panelGray = new JPanel();
		panelGray.setForeground(Color.BLACK);
		panelGray.setBackground(Color.GRAY);
		panelGray.setBounds(22, 53, 32, 21);
		contentPane.add(panelGray);

		JLabel avaiLabel = new JLabel("Available");
		avaiLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		avaiLabel.setBounds(62, 54, 65, 20);
		contentPane.add(avaiLabel);

		JPanel panelYellow = new JPanel();
		panelYellow.setForeground(Color.BLACK);
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(137, 53, 32, 21);
		contentPane.add(panelYellow);

		JLabel selecLabel = new JLabel("Selected");
		selecLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		selecLabel.setBounds(177, 54, 65, 20);
		contentPane.add(selecLabel);

		JPanel panelRed = new JPanel();
		panelRed.setForeground(Color.BLACK);
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(252, 53, 32, 21);
		contentPane.add(panelRed);

		JLabel unavaiLabel = new JLabel("Unavailable");
		unavaiLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		unavaiLabel.setBounds(292, 54, 83, 20);
		contentPane.add(unavaiLabel);

		Label typeLabel = new Label("Ticket type: ");
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		typeLabel.setBounds(490, 80, 108, 26);
		contentPane.add(typeLabel);

		choice = new Choice();
		choice.setBounds(490, 108, 98, 18);
		choice.add(DiscountedTicket.COMMON.toString());
		choice.add(DiscountedTicket.STUDENT.toString());
		choice.add(DiscountedTicket.ELDERLY.toString());
		contentPane.add(choice);
		choice.addItemListener(this);

		ticket_price = new JLabel("Ticket price: 5");
		ticket_price.setBounds(21, 284, 128, 21);
		contentPane.add(ticket_price);

		selected_seats_label = new JLabel("Selected seats: ");
		selected_seats_label.setBounds(22, 306, 227, 13);
		contentPane.add(selected_seats_label);

		JLabel warningLabel = new JLabel("You can buy atmost 4 tickets per session!");
		warningLabel.setBounds(22, 268, 242, 13);
		contentPane.add(warningLabel);

		total_cost_label = new JLabel("Total cost: ");
		total_cost_label.setBounds(22, 329, 105, 13);
		contentPane.add(total_cost_label);

		card_num = new JTextField();
		card_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && card_num.getText().length() < 16) {
					card_num.setEditable(true);
				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					card_num.setEditable(true);
					card_num.setText(card_num.getText().substring(0, card_num.getText().length()));
				}

				else
					card_num.setEditable(false);
			}
		});
		card_num.setHorizontalAlignment(SwingConstants.CENTER);
		card_num.setBounds(425, 270, 130, 20);
		contentPane.add(card_num);
		card_num.setColumns(10);

		JLabel cardNumberLabel = new JLabel("Card number");
		cardNumberLabel.setBounds(330, 270, 83, 20);
		contentPane.add(cardNumberLabel);

		card_cvc = new JTextField();
		card_cvc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' && card_cvc.getText().length() < 3) {
					card_cvc.setEditable(true);
				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					card_cvc.setEditable(true);
					card_cvc.setText(card_cvc.getText().substring(0, card_cvc.getText().length()));
				}

				else
					card_cvc.setEditable(false);
			}
		});
		card_cvc.setHorizontalAlignment(SwingConstants.CENTER);
		card_cvc.setColumns(10);
		card_cvc.setBounds(425, 295, 50, 20);
		contentPane.add(card_cvc);

		JLabel cardCVCLabel = new JLabel("CVC");
		cardCVCLabel.setBounds(330, 295, 60, 20);
		contentPane.add(cardCVCLabel);

		JLabel cardDateLabel = new JLabel("Expiration date");
		cardDateLabel.setBounds(330, 320, 95, 20);
		contentPane.add(cardDateLabel);

		Choice month = new Choice();
		month.setBounds(425, 320, 78, 18);
		month.addItem("JAN");
		month.addItem("FEB");
		month.addItem("MAR");
		month.addItem("APR");
		month.addItem("MAY");
		month.addItem("JUN");
		month.addItem("JUL");
		month.addItem("AVG");
		month.addItem("SEP");
		month.addItem("OCT");
		month.addItem("NOV");
		month.addItem("DEC");
		contentPane.add(month);

		Choice year = new Choice();
		year.setBounds(493, 320, 62, 18);
		year.addItem("2022");
		year.addItem("2023");
		year.addItem("2024");
		year.addItem("2025");
		year.addItem("2026");
		year.addItem("2027");
		year.addItem("2028");
		contentPane.add(year);

		JButton[][] seats_b = new JButton[5][9];

		int x = 20, y = 100;

		readBoughtTickets();

		for (int i = 0; i < selected_seance.getSeats().size(); i++) {

			int j = i / 9;
			if (i != 0 && i - j * 9 == 0) {
				y = y + 30;
				x = 20;
			}
			seats_b[j][i - j * 9] = new JButton((char) (j + 65) + "" + (i - j * 9 + 1));
			seats_b[j][i - j * 9].setBounds(x, y, 50, 25);
			x = x + 50;
			seats_b[j][i - j * 9].setForeground(Color.BLACK);
			if (selected_seance.getSeats().get(i).isAvailable()) {
				seats_b[j][i - j * 9].setBackground(Color.GRAY);
			} else {
				seats_b[j][i - j * 9].setBackground(Color.RED);
				seats_b[j][i - j * 9].setEnabled(false);
			}
			contentPane.add(seats_b[j][i - j * 9]);
			seats_b[j][i - j * 9].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < seats_b.length; i++) {
						for (int j = 0; j < seats_b[i].length; j++) {
							if (e.getSource() == seats_b[i][j] && seats_b[i][j].getBackground() == Color.GRAY
									&& ticket_count < 4) {
								seats_b[i][j].setBackground(Color.YELLOW);
								ticket_count++;
								selected_seats.add(seats_b[i][j].getText());
							} else if (e.getSource() == seats_b[i][j]
									&& seats_b[i][j].getBackground() == Color.YELLOW) {
								seats_b[i][j].setBackground(Color.GRAY);
								ticket_count--;
								selected_seats.remove(seats_b[i][j].getText());
							}
							if (!selected_seats.isEmpty())
								selected_seats_label.setText("Selected seats: "
										+ selected_seats.toString().replace('[', ' ').replace(']', ' '));
							else
								selected_seats_label.setText("Selected seats: ");
							total_cost_label.setText("Total cost: " + getTotalCost(ticket_count, ticket_type) + " $");
						}
					}
				}
			});

		}

		JButton btnPurchase = new JButton("Purchase");
		if (LoginGui.guestMode) {
			btnPurchase.setEnabled(false);
		}
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!selected_seats.isEmpty() && card_num.getText().length() == 16
						&& card_cvc.getText().length() == 3) {
					Ticket t = new Ticket(selected_movie.getHall_number(), selected_movie, selected_seance.getDate(),
							selected_seats);
					JOptionPane.showMessageDialog(contentPane, "Purchase was successful!" + t.printTicket());
					markSelectedAsBought(seats_b, selected_seance);
					selected_movie.updateSeance(selected_seance);
					storeBoughtTickets(selected_seats);
					selected_seats.clear();
					ticket_count = 0;
					selected_seats_label.setText("");
					total_cost_label.setText("");
				} else if (selected_seats.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Select seats!", "Warning", JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(contentPane, "Enter card attributes!", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPurchase.setBounds(455, 365, 121, 27);
		contentPane.add(btnPurchase);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				MovieGUI mg = new MovieGUI(selected_movie);
				mg.setVisible(true);
				ticket_count = 0;
				selected_seats.clear();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		backButton.setBounds(10, 365, 83, 27);
		contentPane.add(backButton);

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public int getTicketPrice(String ticket_type) {
		if (ticket_type.equals(DiscountedTicket.COMMON.toString()))
			return 5;
		else if (ticket_type.equals(DiscountedTicket.STUDENT.toString()))
			return 3;
		else
			return 4;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			ticket_type = choice.getSelectedItem();
		}
		ticket_price.setText("Ticket price: " + getTicketPrice(ticket_type));
		total_cost_label.setText("Total cost: " + getTotalCost(ticket_count, ticket_type) + " $");
	}

	public int getTotalCost(int ticket_count, String ticket_type) {
		return ticket_count * getTicketPrice(ticket_type);
	}

	public void markSelectedAsBought(JButton[][] seats_b, Seance seance) {
		for (int i = 0; i < selected_seats.size(); i++) {
			for (int k = 0; k < seats_b.length; k++) {
				for (int j = 0; j < seats_b[k].length; j++) {
					if (selected_seats.get(i).equals(seats_b[k][j].getText())) {
						seats_b[k][j].setBackground(Color.RED);
						seats_b[k][j].setEnabled(false);
						seance.changeStatus(selected_seats.get(i));

					}
				}
			}
		}
	}

	public void storeBoughtTickets(List<String> seats) {
		try {
			File file = new File("seances.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			for (int j = 0; j < MovieModel.movie_list.size(); j++) {
				Movie m = MovieModel.movie_list.get(j);
				for (int i = 0; i < m.getSeances().size(); i++) {
					bWriter.write(m.getMovie_name() + "\n" + m.getSeances().get(i).getDate().toString().substring(0, 16)
							+ "\n");
					for (int k = 0; k < 45; k++) {
						if (!m.getSeances().get(i).getSeats().get(k).isAvailable()) {
							bWriter.write(m.getSeances().get(i).getSeats().get(k).seatToString() + ",");
						}
					}
					if (m.getMovie_name().equals(MovieListGUI.selected_movie)) {
						for (int k = 0; k < seats.size(); k++) {
							bWriter.write(seats.get(k));
						}
					}
					bWriter.write("\n");
				}

			}
			bWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readBoughtTickets() throws IOException {
		File file = new File("seances.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String st2;
		while ((st = br.readLine()) != null) {
			if (st.equals(MovieListGUI.selected_movie.getMovie_name())) {
				st = br.readLine();
				if (st.equals(MovieGUI.selected_seance.getDate().toString().substring(0, 16))) {
					st = br.readLine();
					if (!st.isEmpty())
						st = st.substring(0, st.length() - 1);
					String[] seats = st.split(",");
					if (!st.equals("")) {
						for (int i = 0; i < seats.length; i++) {
							MovieGUI.selected_seance.changeStatus(seats[i]);
						}
					}

				}
			}
		}
	}
}
