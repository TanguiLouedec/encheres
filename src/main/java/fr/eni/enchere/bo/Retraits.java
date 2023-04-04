package fr.eni.enchere.bo;

public class Retraits {
	private String rueRetrait;
	private String codePostalRetrait;
	private String villeRetrait;
	private Articles article;
	
	
	public Retraits(String rueRetrait, String codePostalRetrait, String villeRetrait, Articles article) {
		super();
		this.rueRetrait = rueRetrait;
		this.codePostalRetrait = codePostalRetrait;
		this.villeRetrait = villeRetrait;
		this.article = article;
	}
	@Override
	public String toString() {
		return "Retraits [rueRetrait=" + rueRetrait + ", codePostalRetrait=" + codePostalRetrait + ", villeRetrait="
				+ villeRetrait + "]";
	}
	public String getRueRetrait() {
		return rueRetrait;
	}
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
	}
	public String getCodePostalRetrait() {
		return codePostalRetrait;
	}
	public void setCodePostalRetrait(String codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}
	public String getVilleRetrait() {
		return villeRetrait;
	}
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}
	public Articles getArticle() {
		return article;
	}
	public void setArticle(Articles article) {
		this.article = article;
	}
	
}
