import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;

class Gymkhana{
		/*
	---------------------------------------------------------------------------------------------------------------------------
													Attributs
	---------------------------------------------------------------------------------------------------------------------------
	*/
	// un attribut tableau qui represente tous les pions placés au cours de la partie
	private Case[][] plateau;
	private static int taille = 11; //en prévision de futures fonctionnalités : pour changer la taille du plateau
	//remarque vu la disposition du plateau, on le représenteras par un tableau de taille int [taille][taille]

	private ArrayList<ClassesConnexite> classesConnexiteRouge;
	private ArrayList<ClassesConnexite> classesConnexiteBlanc;

	/*
	---------------------------------------------------------------------------------------------------------------------------
													Constructeur
	---------------------------------------------------------------------------------------------------------------------------
	*/
	//notre constructeur
	public Gymkhana(){
		plateau = new Case[this.taille][this.taille];
		//proposition : pour chaque case utiliser un systeme d'un entier unique pour représenter le joueur et le sens
		//0 et 1 correspondent au joueur un donc 2 et 3 correspondent au joueur deux (inférieur ou supérieur a 2)
		// pour le sens du pion on utilise pair ou impair
		//-1 correspond a une case vide.
		//-2 correspond a une case interdite
		//on initialise tout le tableau en vide
		for (int i= 0 ;i <this.taille;i++ ) {
			for (int j = 0;j <this.taille;j++ ) {
				if(i%2==1 && j == 0 ){//une colonne sur deux comprend taille cases et les autres comprennent taille-1 cases
							 //on définit donc certaines valeurs du tableau comme interdite
					plateau[i][j] = new Noeud();
				}else{
					plateau[i][j] = new Arete(i,j, 0, this);//un joueur -1 définit une case vide
				}
			}
		}
	}


	public Gymkhana(int length){
		//constructeur définissant la taille du plateau, si on veut faire un truc un peu plus gros (ou petit)
		taille = length;
		plateau = new Case[this.taille][this.taille];
		//proposition : pour chaque case utiliser un systeme d'un entier unique pour représenter le joueur et le sens
		//0 et 1 correspondent au joueur un donc 2 et 3 correspondent au joueur deux (inférieur ou supérieur a 2)
		// pour le sens du pion on utilise pair ou impair
		//-1 correspond a une case vide.
		//-2 correspond a une case interdite
		//on initialise tout le tableau en vide
		for (int i= 0 ;i <this.taille;i++ ) {
			for (int j = 0;j <this.taille;j++ ) {
				if (i%2==1 && j == 0 ) {//une colonne sur deux comprend taille cases et les autres comprennent taille-1 cases
							 //on définit donc certaines valeurs du tableau comme interdite
					plateau[i][j] = null;
				}else{
					plateau[i][j] = null;
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
		if (this.plateau[x][y] != null) {
			return false;
		}else{
			return true;
		}
	}

	public boolean verifPionDansTableau(int x, int y){
		//fonction qui vérifie si le pion qui va etre placé ne joue pas en dehors du plateau
		//renvoie vrai si pion dans tableau et faux si en dehors du tableau
		if (x < 0 || y < 0) {
			return false;
		}
		if (x >= this.taille || y > this.taille ) {
			return false;
		}else{
			return true;
		}
	}

	public boolean verifPionDansPlateau(int x, int y){
		//fonction qui vérifie si le pion qui va etre placé correspond a une case authorisée
		if (plateau[x][y]== null) {
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
		if (!verifPionExisteSurCase(x,y)) {
			System.out.println("Un pion a déja été joué sur cette case, veuillez réessayer avec une autre case");
			return false;
		}else{
			return true;
		}
	}

//--------------------------------------verifs de fin du jeu--------------------------------------------------------

	public boolean plateauRempli(){
		//fonction qui renvoie vrai si le plateau ne permet pas de jouer de pion supplémentaire et faux sinon
		for (int i= 0 ;i <this.taille;i++ ) {
			for (int j = 0;j <this.taille;j++ ) {
				if (plateau[i][j]==null) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions de création d'Case
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public int getSens(int x, int j){
		if (j == 1) {
			if (x%2==0) {
				return 2;
			}else{
				return 1;
			}
		}else{
			if (x%2==0) {
				return 1;
			}else{
				return 2;
			}
		}
	}



	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions d'interface utilisateur
	---------------------------------------------------------------------------------------------------------------------------
	*/



	public void testRecupDonnee(){
		// Je l'avoue cette fonction est un gros copié collé d'internet.
		//en ma défense faire un scanf en java est étonnemment compliqué 
		//et je comptes faire un systeme différent et graphique plus tard 
		//tout crédit revient a http://www.mkyong.com/java/how-to-read-input-from-console-java
		//cette fonction permet de tester la lecture depuis une console


 		BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter something : ");
                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                System.out.println("input : " + input);
                System.out.println("-----------\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}


	public int[] recupDonnee(int joueur){
		//fonction qui renvoie un tableau a trois cases : x et y les coordonnées du pion a placer et z le sens du pion
		//recuperes les valeurs depuis la ligne de commande
		// je me suis donc basé sur la fonction de test
		//petite remarque cette fonction utilises des librairies du JDK1.6, votre version de java doit donc bien etre a jour

		//ne pas oublier de vérifier les valeurs entrees (bien trois entiers) et z bien o ou 1
		System.out.println("Vous pouvez entrer 'q' pour sortir");

		int[] donnes = new int[2];

		int cpt = 0;
		if (joueur == 1) {
			System.out.println("Vous etes le joueur 1");
		}else if (joueur == 2) {
			System.out.println("Vous etes le joueur 2");
		}else{
			System.out.println("Il y a un probleme, allez voir le dev");
			return null;
		}

		while (cpt < 2) {
			if (cpt ==1) {
				System.out.print("Veuillez entrer la coordonne x de votre case : "); // on pourrais faire nos verifs au niveau utilisateur pour l'input
			}

			if (cpt ==0) {
				System.out.print("Veuillez maintenant entrer la coordonne y de votre case : ");
			}

			String input = System.console().readLine();


			if ("q".equals(input)) {
				System.out.println("Exit!");
				System.exit(0);
			}

			try {
			    donnes[cpt] = Integer.parseInt(input);//Je me suis trompé dans l'ordre

			} catch (NumberFormatException e) {
			      System.out.println("Ce que vous venez d'entrer n'est pas un entier. Essayez encore");
			      cpt--;// dans ce cas on n'avance pas au prochain stade
			}

			System.out.println("input : " + input);
			System.out.println("-----------\n");
			cpt++;// on boucles 3 fois
		}

		return donnes;
	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions générales du systeme de jeu
	---------------------------------------------------------------------------------------------------------------------------
	*/
	//fonction obsolete

	// public int entierASauvgarder(int joueur, int sens){
	// 	//fonction qui renvoie l'entier a enregistrer dans le plateau dépendant du sens du pion et du joueur qui le place
	// 	//le joueur doit etre 1 ou 2 et le sens doit etre o ou 1
	// 	int x = 0;
	// 	if (joueur ==2) {
	// 		x +=2;
	// 	}
	// 	if (sens == 1) {
	// 		x++;
	// 	}
	// 	return x;
	// }


	public Arete unTour(int joueur){
		//fonction qui geres le tour d'un joueur dans la partie
		//renvoie les donnees du pion joué par le joueur pendant le tour

		boolean verif = false;
		Arete monArete;
		int[] donnes = new int[3];
		while (!verif) {
			donnes = recupDonnee(joueur); // fonction non finie
			verif = gestionDesVerifs(donnes[0], donnes[1]);
		}
		monArete = new Arete(donnes[0], donnes[1], joueur, this);
		monArete.afficherJoueurArete();
		this.plateau[monArete.getCoordx()][monArete.getCoordy()] = monArete;

		return monArete;
	}

	public void jeu(){
		//fonction qui geres le déroulement du jeu en son entiereté
		System.out.println("Bonjour et bienvenue au magnifique jeu du Gymkhana !");
		System.out.println("Petite remarque : cette version du jeu est encore en alpha, n'en attendez pas trop");
		int finDuJeu = 0;//0 : partie en cours; 1:joueur 1 a gagné; 2:joueur 2 a gagné; 3 : égalité
		int cpt = 1;
		Arete monArete;
		int joueur = 1;
		while (finDuJeu == 0) {
			afficherPlateau();
			monArete = unTour(joueur);
			cpt++;
			if (aGagne(monArete)) {// fonction aGagne non implemente
				finDuJeu = joueur;
			}
			cpt++;
			joueur = cpt%2 + 1;
		}

		System.out.println("Bravo joueur "+finDuJeu+", vous avez gagné !");
	}

	public void afficherPlateau(){
		System.out.print("    ");
		for (int i = 0;i <this.taille ;i++ ) {
			System.out.print(i + "   ");
		}
		System.out.println(" ");
		for (int i= 0 ;i <this.taille;i++ ) {
			System.out.print(i + ": ");
			for (int j = 0;j <this.taille;j++ ) {
				System.out.print(plateau[i][j].toString() + " /");
			}
			System.out.println(" ");
		}
		System.out.println("sens 0 = ->");
		System.out.println("sens 1 = ^");
	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions utilitaires
	---------------------------------------------------------------------------------------------------------------------------
	*/


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions De L'IA
	---------------------------------------------------------------------------------------------------------------------------
	*/
	//On a la possibilité de faire plusieurs types d'IA avec des niveaux de difficultés différents dépendant de leurs systemes de résolutions

	public int random(int min,int max){
		//fonction qui retourn une valeur pseudo Aleatoire entre la valeur min et la valeur max incluse
		return min + (int)(Math.random() * ((max - min) + 1));
	}

	public int[] iaAleatoire(){
		//fonction qui renvoie les cases que le joueur artificiel compte jouer.
		//le positionnement de la case est entierement aléatoire
		int [] donnes = new int[3];
		donnes[0] = random(0,taille - 1);
		donnes[1] = random(0, taille - 1);
		donnes[2] = random(1,2);
		return donnes;
	}



	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions a réaliser
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public boolean aGagne(Arete monArete){
		//fonction qui renvoie vrai si le dernier pion placé réalise une ligne d'un coté a l'autre du plateau et faux sinon
		//strategie : verifier que les noeuds que l'arete relie appartiennent a la meme classe de connexite
		return false;
	}

	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonction main
	---------------------------------------------------------------------------------------------------------------------------
	*/
	public static void main(String[] args) {
		System.out.println("test !");

		Gymkhana maPartie = new Gymkhana();
		//maPartie.jeu();
		maPartie.jeu();
	}
}

//liste de choses a faire :
// fonction aGagne
//refaire modele, faire une classe pion (nos Cases) et une classe LesPetitsCarresRougesEtBlancs (les noeuds)
//fonction afficherArete
//refaire la verif des donnees
