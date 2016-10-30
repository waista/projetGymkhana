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
													Fonctions d'interface utilisateur
	---------------------------------------------------------------------------------------------------------------------------
	*/



	public void testRecupDonnee(){
	       System.out.println("Entrez vos valeurs : ");

	       String sWhatever;

	       Scanner scanIn = new Scanner(System.in);
	       sWhatever = scanIn.nextLine();

	       scanIn.close();            
	       System.out.println(sWhatever);
	}
	public int[] recupDonnee(){
		//fonction qui renvoie un tableau a trois cases : x et y les coordonnées du pion a placer et z le sens du pion
		//je ne sais pas encore récuperer les données de la ligne de commande, il me faut une fonction type scanf, a voir plus tard

		//ne pas oublier de vérifier les valeurs entrees (bien trois entiers) et z bien o ou 1

	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions générales du systeme de jeu
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public int entierASauvgarder(int joueur, int sens){
		//fonction qui renvoie l'entier a enregistrer dans le plateau dépendant du sens du pion et du joueur qui le place
		//le joueur doit etre 1 ou 2 et le sens doit etre o ou 1
		int x = 0;
		if (joueur ==2) {
			x +=2
		}
		if (sens == 1) {
			x++;
		}
		return x;
	}

	public int[] unTour(int joueur){
		//fonction qui geres le tour d'un joueur dans la partie
		//renvoie les donnees du pion joué par le joueur pendant le tour

		boolean verif = false;
		int[] donnes = new int[3];
		while (!verif) {
			donnes = recupDonnee();
			verif = gestionDesVerifs();
		}
		int x = entierASauvgarder(joueur, donnes[2]);
		this.plateau[donnes[0]][donnes[1]] = x;
	}

	public void jeu(){
		//fonction qui geres le déroulement du jeu en son entiereté
		System.out.println("Bonjour et bienvenu au magnifique jeu du Gymkhana !");
		System.out.println("Petite remarque : cette version du jeu est encore en alpha,n'attendez pas grand chose de nous");
		int finDuJeu = 0;//0 : partie en cours; 1:joueur 1 a gagné; 2:joueur 2 a gagné; 3 : égalité
		int cpt = 0;
		while (finDuJeu = 0) {
			unTour(cpt%2);
			cpt++;
			if (aGagne(donnes)) {
				finDuJeu = cpt%2;
			}
			if (plateauRempli()) {
				finDuJeu = 3;
			}
		}


	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions a réaliser
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public boolean aGagne(int[] donnes){
		//fonction qui renvoie vrai si le dernier pion placé réalise une ligne d'un coté a l'autre du plateau et faux sinon
	}

	public boolean plateauRempli(){
		//fonction qui renvoie vrai si le plateau ne permet pas de jouer de pion supplémentaire et faux sinon
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
