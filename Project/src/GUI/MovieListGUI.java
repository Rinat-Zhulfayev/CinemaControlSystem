package GUI;

import CCS.*;
import main.LoginGui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieListGUI extends JFrame {

	private JPanel contentPane;
	public static Movie selected_movie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieListGUI frame = new MovieListGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public MovieListGUI() throws NumberFormatException, IOException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rzhul\\eclipse-workspace\\CinemaControlSystem\\icon.jpg"));
		setResizable(false);
		setTitle("Movie list");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		
		contentPane =new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);		
		JLabel header = new JLabel("All Movies");
		header.setFont(new Font("Tahoma", Font.BOLD, 35));
		header.setForeground(new Color(0, 0, 0));
		header.setBounds(250, 8, 193, 32);
		contentPane.add(header);

		LoginGui.movie_list.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LoginGui.movie_list.setForeground(Color.RED);
		LoginGui.movie_list.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 50, 665, 569);
		scrollPane.setViewportView(LoginGui.movie_list);
		contentPane.add(scrollPane);
		
		LoginGui.movie_list.setCellRenderer(LoginGui.movie_pointer);
		LoginGui.movie_list.setVisibleRowCount(5);
		LoginGui.movie_list.setModel(LoginGui.movie_model);
		LoginGui.movie_list.setCellRenderer(LoginGui.movie_pointer);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginGui lg;
				try {
					lg = new LoginGui();
					lg.setVisible(true);
				} catch (NumberFormatException | IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 625, 97, 34);
		contentPane.add(btnNewButton);
			
		MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		        JList<Movie> theList = (JList) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            selected_movie = theList.getModel().getElementAt(index);
		            MovieGUI mg = new MovieGUI(selected_movie);		            
		            mg.setVisible(true);
		          }
		        }
		      }
		 };
		 
		 LoginGui.movie_list.addMouseListener(mouseListener);
				
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
