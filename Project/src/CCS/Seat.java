package CCS;

public class Seat {
	private char row;
	private int seat_number;
	private boolean available;

	public Seat(char row, int seat_number, boolean seat_availability) {
		if (row >= 'A' && row <= 'F' && seat_number > 0 && seat_number < 10) {
			this.row = row;
			this.seat_number = seat_number;
			this.available = seat_availability;
		}
	}

	public Seat(char row, int number) {
		this.row = row;
		this.seat_number = number;
		this.available = true;
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public String seatToString() {
		return this.row + "" + this.seat_number;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean seat_availability) {
		this.available = seat_availability;
	}

}
