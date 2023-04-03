package fr.eni.enchere.bo;

public class Utilisateurs extends Authentification {
	protected Integer noUtilisateur;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String telephone;
	protected String rue;
	protected String codePostal;
	protected String ville;
	protected boolean administrateur;

	public Utilisateurs(Integer noUtilisateur, String pseudo, String motDePasse, String nom, String prenom,
			String email, String telephone, String rue, String codePostal, String ville, boolean administrateur) {
		super(pseudo, motDePasse);
		this.noUtilisateur = noUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.administrateur = administrateur;
	}
	
	public Utilisateurs(String pseudo, String motDePasse, String nom, String prenom,
			String email, String telephone, String rue, String codePostal, String ville, boolean administrateur) {
		super(pseudo, motDePasse);
		this.noUtilisateur = noUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.administrateur = administrateur;
	}
	
	// Getters & Setters
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "Utilisateurs [noUtilisateur=" + noUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + ", administrateur=" + administrateur + "]";
	}

}
