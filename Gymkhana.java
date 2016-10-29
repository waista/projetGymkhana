import java.util.*

Class Gymkhana{
		/*
	---------------------------------------------------------------------------------------------------------------------------
													Attributs
	---------------------------------------------------------------------------------------------------------------------------
	*/
	// un attribut tableau qui represente tous les pions placés au cours de la partie
	private int[][] plateau;
	private static int taille = 5; //en prévision de futures fonctionnalités : pour changer la taille du plateau
	//remarque vu la disposition du plateau, on le représenteras par un tableau de taille int [2*taille-1][taille]


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Constructeur
	---------------------------------------------------------------------------------------------------------------------------
	*/
	//notre constructeur
	public Gymkhana(){
		plateau = new int[2*this.taille-1][this.taille];
		//proposition : pour chaque case utiliser un systeme d'un entier unique pour représenter le joueur et le sens
		//0 et 1 correspondent au joueur un donc 2 et 3 correspondent au joueur deux (inférieur ou supérieur a 2)
		// pour le sens du pion on utilise pair ou impair
		//-1 correspond a une case vide.
		//-2 correspond a une case interdite
		//on initialise tout le tableau en vide
		for (int i= 0 ;i <2*this.taille-1 ;i++ ) {
			for (int j = 0;this.taille; ) {
				if (i%2==1) {//une colonne sur deux comprend taille cases et les autres comprennent taille-1 cases
							 //on définit donc certaines valeurs du tableau comme interdite
					plateau[i][j] = -2;
				}else{
					plateau[i][j] = -1;
				}
			}
		}
	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions de vérification
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public boolean verifPionExisteSurCase(int x, int y){
		//fonction qui vérifie si le pion qui va etre placé ne joue pas sur un pion déja existant
		//renvoie vrai si un pion n'est pas déja a la case demandée et faux sinon
		if (this.plateau[x][y] != -1) {
			return true;
		}else{
			return false;
		}
	}

	public boolean verifPionDansTableau(int x, int y){
		//fonction qui vérifie si le pion qui va etre placé ne joue pas en dehors du plateau
		//renvoie vrai si pion dans tableau et faux si en dehors du tableau
		if (x < 0 || y < 0) {
			return false;
		}
		if (x >= this.taille || y >= this.taille) {
			return false;
		}else{
			return true;
		}
	}

	public boolean verifPionDansPlateau(int x, int y){
		//fonction qui vérifie si le pion qui va etre placé correspond a une case authorisée
		if (plateau[x][y]==-2) {
			return false;
		}else{
			return true;
		}
	}

	public boolean gestionDesVerifs(int x, int y){
		if (!verifPionDansTableau(x,y)) {
			System.out.println("La case demandée ne se trouve pas dans le tableau, veuillez réessayer avec une case valide");
			return false;
		}
		if (!verifPionDansPlateau(x,y)) {
			System.out.println("La case demandée ne se trouve pas dans le plateau, veuillez réessayer avec une case valide");
			return false;
		}
		if (!verifPionExisteSurCase(x,y)) {
			System.out.println("Un pion a déja été joué sur cette case, veuillez réessayer avec une autre case");
			return false;
		}else{
			return true;
		}
	}




	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonction main
	---------------------------------------------------------------------------------------------------------------------------
	*/
	public static void main(String[] args) {
		System.out.println("test !");
	}
}
