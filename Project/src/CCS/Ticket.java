package CCS;

import java.util.Date;
import java.util.List;

public class Ticket {
	private int hall;
	private Movie movie;
	private Date date;
	private List<String> seat;

	public Ticket(int hall, Movie movie, Date date, List<String> seat) {
		this.hall = hall;
		this.movie = movie;
		this.date = date;
		this.seat = seat;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getSeat() {
		return seat;
	}

	public void setSeat(List<String> seat) {
		this.seat = seat;
	}

	public String printTicket() {
		String newline = System.getProperty("line.separator");
		return newline + "Movie: " + movie.getMovie_name() + newline + "Date: " + date.getHours() + ":"
				+ date.getMinutes() + "  " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear() + newline
				+ "Hall: " + this.hall + newline + "Seat(s): " + seat.toString().replace('[', ' ').replace(']', ' ');
	}
}
