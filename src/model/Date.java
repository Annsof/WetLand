package model;

public class Date {

	private int day;
	private int month;
	private int year;
	
	//getters
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	//setters
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * This is the constructor of a Date class
	 * @param day int, indicates the day
	 * @param month int, indicates the month
	 * @param year int, indicates the year
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

}