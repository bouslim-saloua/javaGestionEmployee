package com.api.model;

import java.sql.Date;
import java.util.List;

public class Employe {
private int id;
private String nom; 
private String prenom;
private Date dateNaissance;
private Date dateAjout;
private String departement;
private String email;
private String telephone;
private String fonction;
private List<Conge> conges;
private List<Salaire> salaires;
private List<Presence> presences;

public Employe() {}

public Employe(int id, String nom, String prenom, Date dateNaissance, Date dateAjout, String departement, String email,
		String telephone, String fonction) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
	this.dateAjout = dateAjout;
	this.departement = departement;
	this.email = email;
	this.telephone = telephone;
	this.fonction = fonction;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public Date getDateNaissance() {
	return dateNaissance;
}

public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}

public Date getDateAjout() {
	return dateAjout;
}

public void setDateAjout(Date dateAjout) {
	this.dateAjout = dateAjout;
}

public String getDepartement() {
	return departement;
}

public void setDepartement(String departement) {
	this.departement = departement;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}

public List<Conge> getConges() {
	return conges;
}

public void setConges(List<Conge> conges) {
	this.conges = conges;
}

public List<Salaire> getSalaires() {
	return salaires;
}

public void setSalaires(List<Salaire> salaires) {
	this.salaires = salaires;
}

public List<Presence> getPresences() {
	return presences;
}

public void setPresences(List<Presence> presences) {
	this.presences = presences;
}

@Override
public String toString() {
	return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
			+ ", dateAjout=" + dateAjout + ", departement=" + departement + ", email=" + email + ", telephone="
			+ telephone + ", fonction=" + fonction + ", conges=" + conges + ", salaires=" + salaires + ", presences="
			+ presences + "]";
}




}
