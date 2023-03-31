package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Encheres {
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Integer noEnchere;
	
	
	
	public Encheres(LocalDate dateEnchere, Integer montantEnchere, Integer noEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noEnchere = noEnchere;
	}
	
	@Override
	public String toString() {
		return "Encheres [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", noEnchere="
				+ noEnchere + "]";
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
}
