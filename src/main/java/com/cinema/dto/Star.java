package com.cinema.dto;
import java.time.LocalDate;
import java.util.Objects;

public class Star {
	private int sta_id;
	private String sta_name;
	private LocalDate sta_date;
	
	public Star() {
		
	}
	public Star(int sta_id,String sta_name, LocalDate sta_date) {
		this.sta_id = sta_id;
		this.sta_name = sta_name;
		this.sta_date = sta_date;
	}
	public String getSta_name() {
		return sta_name;
	}
	public void setSta_name(String sta_name) {
		this.sta_name = sta_name;
	}
	public LocalDate getSta_date() {
		return sta_date;
	}
	public void setSta_date(LocalDate sta_date) {
		this.sta_date = sta_date;
	}
	public int getSta_id() {
		return sta_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sta_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Star other = (Star) obj;
		return sta_id == other.sta_id;
	}
	@Override
	public String toString() {
		return "StarService [sta_id=" + sta_id + ", sta_name=" + sta_name + ", sta_date=" + sta_date + "]";
	}
	
}