package com.api.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.api.dbconn.Connexion;
import com.api.model.Heures;
import com.api.model.Presence; 

public class PresenceController {

	//insérer une nouvelle présence 
	
	Connexion connection = new Connexion();
	
	public void ajouterPresence(Presence p, int heure_id, int employe_id) {
		try {
		//	Heures heures = new Heures();
			//Initialiser les attributs de l'objet heures
			//insérer les données dans la table prescence
			String sql = "INSERT INTO presence (date, heures_id, employe_id) VALUES(?, ?, ?)";
			PreparedStatement pst = connection.conn.prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(p.getDate().getTime()));
			pst.setInt(2, heure_id);
			pst.setInt(3, employe_id);
			
			int lignesAjoutees = connection.executerAction(sql);
			 
			 if(lignesAjoutees > 0) {
				 System.out.println("La présence a été ajoutée avec succès !");
			 }else {
				 System.out.println("Echec de l'ajout de la présence.");
			 }
			 
			 pst.close();
			 connection.disconnect();
			 
			
		}catch(SQLException e) {
			System.out.println("Error " + e.getMessage());
			
		}
	}
}
