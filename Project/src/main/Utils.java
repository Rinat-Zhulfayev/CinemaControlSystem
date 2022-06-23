package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
	public static void saveToFile(User user) {
		File file = new File("users.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(user.getLogin() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getPhone() + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean login(String name, String password) {
		File file = new File("users.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] args = scanner.nextLine().split(",");
				if (args[0].equals(name) && args[1].equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
