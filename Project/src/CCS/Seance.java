package CCS;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seance {
	private Movie movie;
	private Date date;
	private List<Seat> seats = new ArrayList<Seat>();
	public Seance(Movie movie, Date date) {		
		this.movie = movie;
		this.date = date;
		for (int i = 0; i < 45; i++) {
			int j = i/9;
			this.seats.add(new Seat((char) (j + 65), (i-j*9 + 1)));
		}
	}

	public Seance(Movie movie, String sDate){	
		this.movie = movie;
		String[] arr = sDate.split(",");
		Date d = new Date();
		d.setYear(Integer.parseInt(arr[0]));
		d.setMonth(Integer.parseInt(arr[1]));
		d.setDate(Integer.parseInt(arr[2]));
		d.setHours(Integer.parseInt(arr[3]));
		d.setMinutes(Integer.parseInt(arr[4]));
		this.date = d;
		for (int i = 0; i < 45; i++) {
			int j = i/9;
			this.seats.add(new Seat((char) (j + 65), (i-j*9 + 1)));
		}
	}
	public String dateToString() {
		return date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
	}
	public String timeToString() {
		return date.getHours() + ":" + date.getMinutes();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void changeStatus(String seat) {

		for (int i = 0; i < this.seats.size(); i++) {
			if(this.seats.get(i).seatToString().equals(seat)) {
				this.seats.get(i).setAvailable(false);
			}
		}
	}
	
}
