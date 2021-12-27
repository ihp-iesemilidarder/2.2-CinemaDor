package com.cinema.dto;

import java.util.Objects;

public class FilmStar {
	private String fil_name;
	private String fil_description;
	private String sta_name;
	private static int idFilmStar = 0;
	
	public FilmStar(String fil_name,String fil_description,String sta_name) {
		this.fil_name = fil_name;
		this.fil_description = fil_description;
		this.sta_name = sta_name;
		idFilmStar++;
	}
	public FilmStar() {}
	
	public String getFil_name() {
		return fil_name;
	}
	public void setFil_name(String fil_name) {
		this.fil_name = fil_name;
	}
	public String getFil_description() {
		return fil_description;
	}
	public void setFil_description(String fil_description) {
		this.fil_description = fil_description;
	}
	public String getSta_name() {
		return sta_name;
	}
	public void setSta_name(String sta_name) {
		this.sta_name = sta_name;
	}
	public static int getIdFilmStar() {
		return idFilmStar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fil_description, fil_name, sta_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmStar other = (FilmStar) obj;
		return Objects.equals(fil_description, other.fil_description) && Objects.equals(fil_name, other.fil_name)
				&& Objects.equals(sta_name, other.sta_name);
	}
	@Override
	public String toString() {
		return "FilmStar [id="+idFilmStar + ", sta_name=" + sta_name+", fil_name=" + fil_name + ", fil_description=" + fil_description + "]";
	}
		
}
