package it.polito.tdp.libretto.db;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;


// implemento dei metodi


public class VotoDAO {
	
	// Operazione di titpo
	// CRUD - Create Read Update Delete List Search
	
	public List<Voto> listVoti() { // dammi la lista di tutti i voti
			
		// apre connessione, esegue query
		
			try {
				Connection conn = DBConnect.getConnection();
				Statement st = conn.createStatement();
				
				String sql = "SELECT corso, punti, data "
						+ "FROM voto";

				ResultSet res = st.executeQuery(sql);
			
				
				List<Voto> voti = new ArrayList<>();
				
				while(res.next()) {
					String corso = res.getString("corso");
					int punti = res.getInt("punti");
					LocalDate data = res.getDate("data").toLocalDate();
					
//					System.out.println(corso + " = " + punti);
				
					Voto v = new Voto(corso, punti, data);
					voti.add(v);
					
				}
				
				
				conn.close();
				
				return voti;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
					

	}

	
	public void createVoto(Voto v) { // gli passo un oggetto voto e lui lo inserisce nel database

		// devo usare prepared statement, non un normale statement (definisco i punti variabili)
//		String sql = "INSERT INTO `voto' (`corso`, `punti`, `data`) "
//			+ "VALUES ('"+v.getCorso()+"','"+v.getPunti()+"','"+v.getDataEsame()+"')";

		String sql = "INSERT INTO voto ('corso', 'punti', 'data') "+
		"VALUES (?, ?, ?);";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, v.getCorso());
			st.setInt(2, v.getPunti());
//			st.setDate(3, new Date(v.getDataEsame));
			
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Voto readVoto(String corso) { // il corso è la chiave primaria
		
	}
	
	public List<Voto> searchVotoPuntiMaggiori (int punti) {
		
		
	}
}
	
