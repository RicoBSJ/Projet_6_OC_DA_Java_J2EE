package org.exemple.demo.model.bean;

public class Utilisateur {

	Integer numUtil;
	String prenUtil;
	String pseudo;
	String mail;
	String motDePasse;
	Boolean inscrit;

	public Integer getNumUtil() {
		return numUtil;
	}

	public void setNumUtil(Integer numUtil) {
		this.numUtil = numUtil;
	}

	public String getPrenUtil() {
		return prenUtil;
	}

	public void setPrenUtil(String prenUtil) {
		this.prenUtil = prenUtil;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getInscrit() {
		return inscrit;
	}

	public void setInscrit(Boolean inscrit) {
		this.inscrit = inscrit;
	}
}