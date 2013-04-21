package uk.co.certait.spring.web.utils;

public class FilterForm {

	private String surname;
	private String location;

	public FilterForm() {
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void clear() {
		surname = null;
		location = null;
	}
}
