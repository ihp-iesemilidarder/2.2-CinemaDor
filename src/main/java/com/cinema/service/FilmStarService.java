package com.cinema.service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cinema.bd.BDConnectionMySQL;
import com.cinema.dto.Film;
import com.cinema.dto.FilmStar;

public class FilmStarService {
	public FilmStarService() {}
	
	public List<FilmStar> getFilmStarService(Integer idStar) {
		BDConnectionMySQL bd = new BDConnectionMySQL();
        List<FilmStar> list = new ArrayList<>();
        try {
        	String query = "SELECT sta_name,fil_name,fil_description FROM films,stars,filxsta WHERE fil_id = fxs_fil_id AND sta_id = fxs_sta_id AND sta_id = ?";
            Connection connexio = bd.getConnection();
            PreparedStatement sentencia = connexio.prepareStatement(query);
            sentencia.setString(1, idStar.toString());
            ResultSet resultat  = sentencia.executeQuery();
                  
            if (resultat!=null) {
	            while (resultat.next()) {
					String name = resultat.getString("fil_name");
					String description = resultat.getString("fil_description");
					String star = resultat.getString("sta_name");
					
					FilmStar peli = new FilmStar( name, description, star);
					System.out.println( peli.toString() );
					list.add(peli);
	            }
            }
            sentencia.close();
            connexio.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

	}
}
