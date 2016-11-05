import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Gymkhana{
		/*
	---------------------------------------------------------------------------------------------------------------------------
													Attributs
	---------------------------------------------------------------------------------------------------------------------------
	*/
	// un attribut tableau qui represente tous les pions placÃ©s au cours de la partie
	private int[][] plateau;
	private static int taille = 5; //en prÃ©vision de futures fonctionnalitÃ©s : pour changer la taille du plateau
	//remarque vu la disposition du plateau, on le reprÃ©senteras par un tableau de taille int [2*taille-1][taille]


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Constructeur
	---------------------------------------------------------------------------------------------------------------------------
	*/
	//notre constructeur
	public Gymkhana(){
		plateau = new int[2*this.taille-1][this.taille];
		//proposition : pour chaque case utiliser un systeme d'un entier unique pour reprÃ©senter le joueur et le sens
		//0 et 1 correspondent au joueur un donc 2 et 3 correspondent au joueur deux (infÃ©rieur ou supÃ©rieur a 2)
		// pour le sens du pion on utilise pair ou impair
		//-1 correspond a une case vide.
		//-2 correspond a une case interdite
		//on initialise tout le tableau en vide
		for (int i= 0 ;i <2*this.taille-1 ;i++ ) {
			for (int j = 0;j <this.taille;j++ ) {
				if (i%2==1 && j == 0 ) {//une colonne sur deux comprend taille cases et les autres comprennent taille-1 cases
							 //on dÃ©finit donc certaines valeurs du tableau comme interdite
					plateau[i][j] = -2;
				}else{
					plateau[i][j] = -1;
				}
			}
		}
	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions de vÃ©rification
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public boolean verifPionExisteSurCase(int x, int y){
		//fonction qui vÃ©rifie si le pion qui va etre placÃ© ne joue pas sur un pion dÃ©ja existant
		//renvoie vrai si un pion n'est pas dÃ©ja a la case demandÃ©e et faux sinon
		if (this.plateau[x][y] != -1) {
			return false;
		}else{
			return true;
		}
	}

	public boolean verifPionDansTableau(int x, int y){
		//fonction qui vÃ©rifie si le pion qui va etre placÃ© ne joue pas en dehors du plateau
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
		//fonction qui vÃ©rifie si le pion qui va etre placÃ© correspond a une case authorisÃ©e
		if (plateau[x][y]==-2) {
			return false;
		}else{
			return true;
		}
	}

	public boolean gestionDesVerifs(int x, int y){
		if (!verifPionDansTableau(x,y)) {
			System.out.println("La case demandÃ©e ne se trouve pas dans le tableau, veuillez rÃ©essayer avec une case valide");
			return false;
		}
		if (!verifPionDansPlateau(x,y)) {
			System.out.println("La case demandÃ©e ne se trouve pas dans le plateau, veuillez rÃ©essayer avec une case valide");
			return false;
		}
		if (!verifPionExisteSurCase(x,y)) {
			System.out.println("Un pion a dÃ©ja Ã©tÃ© jouÃ© sur cette case, veuillez rÃ©essayer avec une autre case");
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
		// Je l'avoue cette fonction est un gros copiÃ© collÃ© d'internet.
		//en ma dÃ©fense faire un scanf en java est Ã©tonnemment compliquÃ© 
		//et je comptes faire un systeme diffÃ©rent et graphique plus tard 
		//tout crÃ©dit revient a http://www.mkyong.com/java/how-to-read-input-from-console-java
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
		//fonction qui renvoie un tableau a trois cases : x et y les coordonnÃ©es du pion a placer et z le sens du pion
		//recuperes les valeurs depuis la ligne de commande
		// je me suis donc basÃ© sur la fonction de test


		//ne pas oublier de vÃ©rifier les valeurs entrees (bien trois entiers) et z bien o ou 1
		System.out.println("Vous pouvez entrer 'q' pour sortir");

		int[] donnes = new int[3];

		int cpt = 0;
		if (joueur == 1) {
			System.out.println("Vous etes le joueur 1");
		}else if (joueur == 2) {
			System.out.println("Vous etes le joueur 2");
		}else{
			System.out.println("Il y a un probleme, allez voir le dev");
			return null;
		}

		while (cpt < 3) {
			if (cpt ==0) {
				System.out.print("Veuillez entrer la coordonne x de votre case : "); // on pourrais faire nos verifs au niveau utilisateur pour l'input
			}

			if (cpt ==1) {
				System.out.print("Veuillez maintenant entrer la coordonne y de votre case : ");
			}

			if (cpt ==2) {
				System.out.print("Veuillez enfin choisir le sens dans lequel vous voulez mettre votre pion : ");
			}

			String input = System.console().readLine();


			if ("q".equals(input)) {
				System.out.println("Exit!");
				System.exit(0);
			}

			try {
			      donnes[cpt] = Integer.parseInt(input);
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
													Fonctions gÃ©nÃ©rales du systeme de jeu
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public int entierASauvgarder(int joueur, int sens){
		//fonction qui renvoie l'entier a enregistrer dans le plateau dÃ©pendant du sens du pion et du joueur qui le place
		//le joueur doit etre 1 ou 2 et le sens doit etre o ou 1
		int x = 0;
		if (joueur ==2) {
			x +=2;
		}
		if (sens == 1) {
			x++;
		}
		return x;
	}

	public int[] unTour(int joueur){
		//fonction qui geres le tour d'un joueur dans la partie
		//renvoie les donnees du pion jouÃ© par le joueur pendant le tour

		boolean verif = false;
		int[] donnes = new int[3];
		while (!verif) {
			donnes = recupDonnee(joueur); // fonction non finie
			System.out.println("donne[0]" + donnes[0]);
			System.out.println("donne[1]" + donnes[1]);
			System.out.println("donne[2]" + donnes[2]);
			verif = gestionDesVerifs(donnes[0], donnes[1]);
		}
		int x = entierASauvgarder(joueur, donnes[2]);
		this.plateau[donnes[0]][donnes[1]] = x;

		return donnes;
	}

	public void jeu(){
		//fonction qui geres le dÃ©roulement du jeu en son entieretÃ©
		System.out.println("Bonjour et bienvenu au magnifique jeu du Gymkhana !");
		System.out.println("Petite remarque : cette version du jeu est encore en alpha, n'en attendez pas trop");
		int finDuJeu = 0;//0 : partie en cours; 1:joueur 1 a gagnÃ©; 2:joueur 2 a gagnÃ©; 3 : Ã©galitÃ©
		int cpt = 1;
		int[] donnes = new int[3];
		int joueur = 1;
		while (finDuJeu == 0) {
			afficherPlateau();
			unTour(joueur);
			cpt++;
			if (aGagne(donnes)) {// fonction aGagne non implemente
				finDuJeu = joueur;
			}
			if (plateauRempli()) {//fonction plateauRempli non implemente
				finDuJeu = 3;
			}
			cpt++;
			joueur = cpt%2 + 1;
		}


	}

	public void afficherPlateau(){
		System.out.print("    ");
		for (int i = 0;i <this.taille ;i++ ) {
			System.out.print(i + "   ");
		}
		System.out.println(" ");
		for (int i= 0 ;i <2*this.taille-1 ;i++ ) {
			System.out.print(i + ": ");
			for (int j = 0;j <this.taille;j++ ) {
				System.out.print(plateau[i][j] + " /");
			}
			System.out.println(" ");
		}
		System.out.println("sens 0 = ->");
		System.out.println("sens 1 = ^");
	}


	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions a rÃ©aliser
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public boolean aGagne(int[] donnes){
		//fonction qui renvoie vrai si le dernier pion placÃ© rÃ©alise une ligne d'un cotÃ© a l'autre du plateau et faux sinon

		return false;
	}

	public boolean plateauRempli(){
		//fonction qui renvoie vrai si le plateau ne permet pas de jouer de pion supplÃ©mentaire et faux sinon
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
		maPartie.afficherPlateau();
		maPartie.jeu();
		maPartie.afficherPlateau();
	}
}

//liste de choses a faire :
// fonction aGagne
// fonction plateauRempli
//fini recupDonne
