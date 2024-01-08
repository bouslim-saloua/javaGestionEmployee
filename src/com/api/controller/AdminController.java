package com.api.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.dbconn.Connexion;
import com.api.model.Admin;

public class AdminController {

	//crud
	 Connexion connection = new Connexion();
	 
	
	//ajouter un nouveau administrateur
	 
	 public void ajouterAdmin(Admin admin) {
		 String sql = "INSERT INTO employes (nom, prenom, dateNaissance, dateAjout, departement, email, telephone, fonction, login, password) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 try {
			 PreparedStatement pst = connection.conn.prepareStatement(sql);
			 pst.setString(1, admin.getNom());
			 pst.setString(2, admin.getPrenom());
			 pst.setDate(3, new java.sql.Date(admin.getDateNaissance().getTime()));
			 pst.setDate(4, new java.sql.Date(admin.getDateAjout().getTime()));
			 pst.setString(5, admin.getDepartement());
			 pst.setString(6, admin.getEmail());
			 pst.setString(7, admin.getTelephone());
			 pst.setString(8, admin.getFonction());
			 pst.setString(9, admin.getLogin());
			 pst.setString(10, admin.getPassword());
			 
			 int lignesAjoutees = connection.executerAction(sql);
			 
			 if(lignesAjoutees > 0) {
				 System.out.println("Nouvel admin ajouté avec succès !");
			 }else {
				 System.out.println("Echec de l'ajout de l'admin.");
			 }
			 
			 //Fermeture de la connexion
			 pst.close();
			 connection.disconnect();
		 }catch(SQLException e){
			 System.out.println("Error : " + e.getMessage());
		 }
		 
	 }
	 
	 public void adminLogin(String loginSaisi, String passwordSaisi) {
		 
		 try {
			 String sql = "SELECT * From employe WHERE login = ? AND password = ?";
			PreparedStatement stm = connection.conn.prepareStatement(sql);
			
			stm.setString(1, loginSaisi);
			stm.setString(2, passwordSaisi);
			
			ResultSet rs = connection.executerSelect(sql);
			if(rs.next()) {
				// administrateur est authentifié avec succès
				System.out.println("Connexion réussie");
			}else {
				System.out.println("Connexion échouée");
			}
			rs.close();
			stm.close();
			connection.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
}
