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
import java.time.LocalDate;

import com.cinema.bd.BDConnectionMySQL;
import com.cinema.dto.Film;
import com.cinema.dto.Genere;
import com.cinema.dto.Session;
import com.cinema.dto.Star;

public class StarService {
	
	public StarService() {}

	// LListat de pel·lícules
	public List<Star> getListStars() {
        
		BDConnectionMySQL bd = new BDConnectionMySQL();
        List<Star> list = new ArrayList<>();
        try {
        	String query = "select * from stars";            
            Connection connexio = bd.getConnection();
            Statement sentencia = connexio.createStatement();
            ResultSet resultat  = sentencia.executeQuery(query);
                  
            if (resultat!=null) {
	            while (resultat.next()) {
					int id = resultat.getInt("sta_id");
					String name = resultat.getString("sta_name");
					LocalDate date = LocalDate.parse(resultat.getString("sta_date"));
					
					Star star = new Star(id,name,date);
					System.out.println( star.toString() );
					list.add(star);
	            }
            }
            sentencia.close();
            connexio.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
        
    }
	
	// Llista filtrada per genere
	public List<Star> getListStars(String idStar) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		List<Star> list = new ArrayList<>();
		try {
			String query = "select * from stars";
			if (idStar!=null) {
				query = "SELECT * FROM stars WHERE sta_id = ?";
			}          
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			// Configuram el pàrametre d'entrada gènere
			if (idStar!=null) {
				sentencia.setString(1, idStar.toString());
			}
			ResultSet resultat  = sentencia.executeQuery();
			if (resultat!=null) {
				while (resultat.next()) {
					int id = resultat.getInt("sta_id");
					String name = resultat.getString("sta_name");
					LocalDate date = LocalDate.parse(resultat.getString("sta_date")); 
					
					Star peli = new Star( Integer.valueOf(id),name,date); 
					
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
	// Recupera una pel·lícula
	public Star getStar(int filtreId) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		Star peli = null;
		try {
			String query = "SELECT * FROM stars WHERE sta_id = ?";        
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			
			// Configuram el pàrametre d'entrada gènere
			sentencia.setInt(1, filtreId);
	
			ResultSet resultat  = sentencia.executeQuery();
			
			if (resultat!=null) {
				resultat.next();
				int id = resultat.getInt("sta_id");
				String name = resultat.getString("flm_name");
				LocalDate date = LocalDate.parse(resultat.getString("flm_date")); 
				
				peli = new Star( Integer.valueOf(id),name,date);
				
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peli;
	}
}
