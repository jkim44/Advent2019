import java.nio.file.Paths;
import java.util.Scanner;

public class DayOne {
	private int sum;
	private Scanner reader;
	
	public DayOne() {
		try {
			this.sum = 0;
			reader = new Scanner(Paths.get("fktim/fkTim.txt"));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public Integer getFuelSum() {
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			int mass = Integer.valueOf(line);
			mass = getFuel(mass);
			sum += mass;
		}
		return sum;
	}
	
	public Integer getTotalFuel() {
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			int mass = Integer.valueOf(line);
			mass = getMoreFuel(mass);
			sum += mass;
		}
		return sum;
	}
	
	private Integer getFuel(int mass) {
		return mass / 3 - 2;
	}
	
	private Integer getMoreFuel(int mass) {
		int sum = 0;
		while (mass > 0) {
			mass = getFuel(mass);
			if (mass >= 0) {
				sum += mass;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		DayOne fuel = new DayOne();
		System.out.println(fuel.getTotalFuel());
	}
}