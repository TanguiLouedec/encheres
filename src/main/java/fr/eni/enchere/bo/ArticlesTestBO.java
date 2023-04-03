package fr.eni.enchere.bo;

import java.time.LocalDate;

public class ArticlesTestBO extends Articles {

	private static final Utilisateurs Utilisateurs = null;
	private static final Categories Categories = null;

	public static void main(String[] args) {
			//Creation d'un article pour tester le BO
			Articles articleTest = new Articles(1,"Motocultor4000", "Pour la motoculture, pas sérieux s'abstenir merci",LocalDate.of(2007, 12, 3), LocalDate.of(2017, 12, 3),726,730,Utilisateurs,Categories);
			//Affichage de l'article test
			System.out.println(articleTest);
	}

}
