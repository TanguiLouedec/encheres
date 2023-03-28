package fr.eni.enchere.bo;

public class Authentification {
	protected String pseudo;
	protected String motDePasse;

	// Constructeurs
	public Authentification() {
		super();
	}

	public Authentification(String pseudo, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	// Getters & Setters
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	// toString
	@Override
	public String toString() {
		return "Authentification [pseudo=" + pseudo + ", motDePasse=" + motDePasse + "]";
	}

	

}
