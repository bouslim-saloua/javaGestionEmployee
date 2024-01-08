package com.api.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.api.dbconn.Connexion;
import com.api.model.Heures;

public class HeuresController {

	//ouvrir la connection
	Connexion connection = new Connexion();
	
	public int calculerNombreHeures(int heureEntree, int heureSortie) {
		return heureSortie - heureEntree;
	}
	
	public void AjouterHeures(Heures h) {
		int nbreHeures = calculerNombreHeures(h.getHeureEntree(), h.getHeureSortie());
		
			try {
				//	Heures heures = new Heures();
					//Initialiser les attributs de l'objet heures
					//insérer les données dans la table prescence
					String sql = "INSERT INTO heures (heure_entree, heure_sortie, nbre_heure_jour) VALUES(?, ?, ?)";
					PreparedStatement pst = connection.conn.prepareStatement(sql);
					pst.setInt(1, h.getHeureEntree());
					pst.setInt(2, h.getHeureSortie());
					pst.setDouble(3, nbreHeures );
					int lignesAjoutees = connection.executerAction(sql);
					 
					 if(lignesAjoutees > 0) {
						 System.out.println("La présence a été ajoutée avec succès !");
					 }else {
						 System.out.println("Echec de l'ajout de la présence.");
					 }
			
		}catch(SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
}

