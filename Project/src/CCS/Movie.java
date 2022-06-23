package CCS;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Movie {
	private String movie_name;
	private String movie_language;
	private int release_date;
	private String trailer;
	private ImageIcon poster;
	private String description;
	private String genre;
	private int duration;
	private String director;
	private int hall_number;
	private String temp_poster;
	private List<Seance> seances;
	
	public Movie(String movie_name, String movie_language, int year, String trailer, String poster,
			String description, String genre, int duration, String director, int hall_number, List<Seance> seances) {
		super();
		this.movie_name = movie_name;
		this.movie_language = movie_language;
		this.release_date = year;
		this.trailer = trailer;
		this.poster = new ImageIcon(new ImageIcon(poster).getImage().getScaledInstance(250, 350,Image.SCALE_SMOOTH));
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.director = director;
		this.hall_number = hall_number;
		this.seances = seances;
		this.temp_poster=poster;
	}
	
	public void setPoster(ImageIcon poster) {
		this.poster = poster;
	}

	public String getTemp_poster() {
		return temp_poster;
	}

	public void setTemp_poster(String temp_poster) {
		this.temp_poster = temp_poster;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public void setMovie(Movie movie) {
		this.movie_name = movie.movie_name;
		this.movie_language = movie.movie_language;
		this.release_date = movie.release_date;
		this.trailer = movie.trailer;
		this.poster = movie.poster;
		this.description = movie.description;
		this.genre = movie.genre;
		this.duration = movie.duration;
		this.director = movie.director;
		this.hall_number = movie.hall_number;
		this.seances = movie.seances;
	}
	public List<Seance> getSeances() {
		return seances;
	}
	public void setSeances(List<String> seances) {
		this.seances =  new ArrayList<>();
		for (int i = 0; i < seances.size(); i++) {
			this.seances.add(new Seance(this, seances.get(i)));
		}
	}
	public void updateSeance(Seance seance) {
		for (int i = 0; i < seances.size(); i++) {
			if(seances.get(i).getDate() == seance.getDate()) {
				seances.get(i).setSeats(seance.getSeats());
			}
		}
	}
	public void movieDetails() {
		System.out.println("...");;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_language() {
		return movie_language;
	}
	public void setMovie_language(String movie_language) {
		this.movie_language = movie_language;
	}
	public int getRelease_date() {
		return release_date;
	}
	public void setRelease_date(int year) {
		this.release_date = year;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public ImageIcon getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = new ImageIcon(new ImageIcon(poster).getImage().getScaledInstance(250, 350,Image.SCALE_SMOOTH));
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getHall_number() {
		return hall_number;
	}
	public void setHall_number(int hall_number) {
		this.hall_number = hall_number;
	}
	
	
}
