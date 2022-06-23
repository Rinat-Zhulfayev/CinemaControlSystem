package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import CCS.Movie;

@SuppressWarnings({ "serial", "rawtypes" })
public class MovieModel extends DefaultListModel {

	public static List<Movie> movie_list = new ArrayList<Movie>();

	@SuppressWarnings("unchecked")
	public MovieModel() throws NumberFormatException, IOException, ParseException {
		FileReader fr = new FileReader("movie_list.txt");
		BufferedReader br = new BufferedReader(fr);

		int i;
		int count = 0;
		Movie m = new Movie();
		String st;
		while ((st = br.readLine()) != null) {
			if (count == 0)
				count++;
			else if (st.startsWith("-")) {
				movie_list.add(m);
				addElement(m);
				m = new Movie();
				count = 1;
			} else {
				if (count == 1) {
					m.setMovie_name(st);
				}

				else if (count == 2)
					m.setMovie_language(st);
				else if (count == 3)
					m.setRelease_date(Integer.parseInt(st));
				else if (count == 4)
					m.setTrailer(st);
				else if (count == 5) {
					m.setPoster(st);
					m.setTemp_poster(st);
				}

				else if (count == 6)
					m.setDescription(st);
				else if (count == 7)
					m.setGenre(st);
				else if (count == 8)
					m.setDuration(Integer.parseInt(st));
				else if (count == 9)
					m.setDirector(st);
				else if (count == 10)
					m.setHall_number(Integer.parseInt(st));
				else if (count == 11)
					m.setSeances(Arrays.asList(st.split(";")));
				count++;
			}

		}
		br.close();
		fr.close();
	}
}
