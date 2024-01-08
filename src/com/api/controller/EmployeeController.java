package com.api.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.api.dbconn.Connexion;

import com.api.model.Employe;

public class EmployeeController {
	//crud
		 Connexion connection = new Connexion();
		 
		 //enregistrer un nouveau employé
		 
		 public void insert(Employe emp) throws SQLException {
			 String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
			   try {
				 PreparedStatement pst = connection.conn.prepareStatement("INSERT INTO EMPLOYE (nom, prenom, date_naissance, date_ajout, departement, email, telephone, fontion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", 0);
				 
				 pst.setString(1, emp.getNom());
				 pst.setString(2, emp.getPrenom());
				 pst.setDate(3, emp.getDateNaissance());
				 pst.setString(4, date);
				 pst.setString(5, emp.getDepartement());
				 pst.setString(6, emp.getEmail());
				 pst.setString(7, emp.getTelephone());
				 pst.setString(8, emp.getFonction());
				 pst.executeUpdate();
				 System.out.println("L'employé avec le nom : " + emp.getNom() + " est enregistré avec succès");
		            connection.disconnect();
				 
			   }catch(SQLException e){
				   System.out.println("Error " + e.getMessage());
				   
			   }
		 }
		 
		 //update
		 
		 public void update(Employe emp, int id) throws SQLException {
			 connection.getConnexion();
			try {
				 
		            PreparedStatement pst = connection.conn.prepareStatement("UPDATE employe SET nom= ?, prenom= ?, departement= ?, email= ?, telephone= ?, fonction= ?, date_naissance=?, date_ajout=?  WHERE id=?");
		            pst.setString(1, emp.getNom());
		            pst.setString(2, emp.getPrenom());
		            pst.setString(3, emp.getDepartement());
		            pst.setString(4, emp.getEmail());
		            pst.setString(5, emp.getTelephone());
		            pst.setString(6, emp.getFonction());
		            pst.setDate(7, emp.getDateNaissance());
		            pst.setDate(8, emp.getDateAjout());
		            pst.setInt(9, id);
		            pst.executeUpdate();
		           
		            
		            System.out.println("L'employé avec l'id "+ id + " a été mis à jour avec succès");
		            //deconnexion
		            connection.disconnect();   
			}catch(SQLException e){
				System.out.println("Error " + e.getMessage());
			}
		 }
		 
		//Delete
		 public void delete(int id) {
			connection.getConnexion();
			try {
				PreparedStatement pst = connection.conn.prepareStatement("DELETE FROM employe WHERE id = ?");
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("L'employé avec l'id " + id + " a été supprimé avec succès");
				
			}catch(SQLException e) {
				System.out.println("Error : "+ e.getMessage());
			}
			 
		 }
		 
		 //selectionner tous les employés
		 
		 public ResultSet selectAll() {
			 connection.getConnexion();
			String query = "SELECT * FROM employe";
			connection.executeSQL(query);
			ResultSet rs= connection.executerSelect(query);
			connection.disconnect();
			return rs;
		 }
		 
		 //select a user by its id
		 public ResultSet selectedId(int id) throws SQLException {
			 connection.getConnexion();
			 String query = "SELECT * FROM emplye WHERE id = ?";
			 PreparedStatement ps = connection.conn.prepareStatement(query);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 connection.disconnect();
			 return rs;
		 }
		 
		 
}
