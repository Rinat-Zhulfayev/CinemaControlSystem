package CCS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import GUI.MovieModel;

public class Admin {
	private static Admin admin;
	Scanner scan = new Scanner(System.in);
	static int a = 0;
	private Admin() {
	}

	public static Admin getInstance() {
		if (admin == null) {

			admin = new Admin();
		}
		return admin;
	}

	public static void addMovie(Movie movie) {
		boolean flag = false;
		if (MovieModel.movie_list.size() != 0) {
			for (int i = 0; i < MovieModel.movie_list.size(); i++) {
				if (MovieModel.movie_list.get(i).getMovie_name().equalsIgnoreCase(movie.getMovie_name())) {
					flag = false;
					break;
				}

				else {
					flag = true;
				}
			}
			if (flag) {
				MovieModel.movie_list.add(movie);
				write_txt();
				//System.out.println("Adding movie is successfull");
			} else {
				// System.out.println("This movie is added before.");
			}
		} else {
			MovieModel.movie_list.add(movie);
			write_txt();
		}

	}

	public static void write_txt() {
		try {
			File file = new File("movie_list.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write("***************************** MOVIE LIST *****************************");
			for (int i = 0; i < MovieModel.movie_list.size(); i++) {
				bWriter.write("\n" + MovieModel.movie_list.get(i).getMovie_name() + "\n"
						+ MovieModel.movie_list.get(i).getMovie_language() + "\n"
						+ MovieModel.movie_list.get(i).getRelease_date() + "\n" + MovieModel.movie_list.get(i).getTrailer()
						+ "\n" + MovieModel.movie_list.get(i).getTemp_poster() + "\n" + MovieModel.movie_list.get(i).getDescription()
						+ "\n" + MovieModel.movie_list.get(i).getGenre() + "\n"
						+ MovieModel.movie_list.get(i).getDuration() + "\n" + MovieModel.movie_list.get(i).getDirector()
						+ "\n" + MovieModel.movie_list.get(i).getHall_number()+"\n");
				String temp ="";
				for (int j = 0; j < MovieModel.movie_list.get(i).getSeances().size(); j++) {
					temp += MovieModel.movie_list.get(i).getSeances().get(j).getDate().getYear()+","+MovieModel.movie_list.get(i).getSeances().get(j).getDate().getMonth()+","+
							MovieModel.movie_list.get(i).getSeances().get(j).getDate().getDate()+","+MovieModel.movie_list.get(i).getSeances().get(j).getDate().getHours()+","+
							MovieModel.movie_list.get(i).getSeances().get(j).getDate().getMinutes()+";";
				}
				temp = temp.substring(0,temp.length()-1);
				bWriter.write(temp);
				bWriter.write("\n--------------------------------------------------------------");
			}
			bWriter.close();

			// System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			// System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void editMovie(String name, String values) {
		String[] temp = values.split(",");

		for (int i = 0; i < MovieModel.movie_list.size(); i++) {
			if (MovieModel.movie_list.get(i).getMovie_name().equalsIgnoreCase(name)) {
				MovieModel.movie_list.get(i).setMovie_name(temp[0]);
				MovieModel.movie_list.get(i).setMovie_language(temp[1]);
				MovieModel.movie_list.get(i).setRelease_date(Integer.parseInt(temp[2]));
				MovieModel.movie_list.get(i).setTrailer(temp[3]);
				MovieModel.movie_list.get(i).setPoster(temp[4]);
				MovieModel.movie_list.get(i).setTemp_poster(temp[4]);
				MovieModel.movie_list.get(i).setDescription(temp[5]);
				MovieModel.movie_list.get(i).setGenre(temp[6]);
				MovieModel.movie_list.get(i).setDuration(Integer.parseInt(temp[7]));
				MovieModel.movie_list.get(i).setDirector(temp[8]);
				MovieModel.movie_list.get(i).setHall_number(Integer.parseInt(temp[9]));
				MovieModel.movie_list.get(i).setSeances(Arrays.asList(temp[10].split(";")));
				break;
			}
		}
		write_txt();
	}

	public static void deleteMovie(String name) {
		Movie temp;
		for (int i = 0; i < MovieModel.movie_list.size(); i++) {
			if (MovieModel.movie_list.get(i).getMovie_name().equalsIgnoreCase(name)) {
				temp = MovieModel.movie_list.get(i);
				MovieModel.movie_list.remove(temp);
				break;
			}
		}
		write_txt();

	}
}
