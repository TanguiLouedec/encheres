package fr.eni.enchere.bo;

public class Administrateur extends Utilisateurs {
	protected Integer idAdministrateur;
	
	public Administrateur() {
		super();
	}

	public Administrateur(String pseudo, String motDePasse,Integer noUtilisateur, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville,Integer administrateur) {
		super(pseudo,motDePasse,noUtilisateur,nom,prenom,email,telephone,rue,codePostal,ville);
		this.idAdministrateur = administrateur;
	}


	public Integer getAdministrateur() {
		return idAdministrateur;
	}

	public void setAdministrateur(Integer administrateur) {
		this.idAdministrateur = administrateur;
	}

	@Override
	public String toString() {
		return "Administrateur [idAdministrateur=" + idAdministrateur + ", noUtilisateur=" + noUtilisateur + ", nom="
				+ nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", pseudo=" + pseudo + ", motDePasse="
				+ motDePasse + "]";
	}
}
