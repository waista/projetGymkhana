##attention cette version n'est pas a jour, si vous voulez la version a jour demandez moi de rajouter les modifs

# projetGymkhana

##Presentation
Bonjour et bienvenue sur notre GitHub. Ce projet est un travail d'école réalisé par des étudiants. Nous avons donc un tuteur qui a définit notre sujet, qui note notre travail et aupres duquel nous avons un rendu de notre travail a présenter régulierement.

###But
Réaliser une version ordinateur du gymkhana en réalisant un joueur artificiel contre lequel le joueur pourra jouer

###Objectifs
Dans un premier temps, nous allons créer les bases de l'algorythme. 

###Regles du jeu
Contenu de la boîte. 
	1.  Un  plateau  quadrillé  par  des  plots  rouges  et  blancs disposés en cinq rangées symétriques de chaque couleur. 
	2. 21 pièces octogonales blanches.  
	3. 21 pièces octogonales rouges. 
	4. Une  règle  du  jeu  et  un  récapitulatif  des  différentes 
  
Pour  gagner,  il  faut  être  le  premier  à  établir  une ligne continue  avec  sa  couleur,  d’un  bord  à  l’autre  du  plateau,en  reliant  les  plots  entre  eux.  Très  vite,  il  faut mettre  en place une stratégie pour défier les attaques de l’adversaire qui  fera  tout  pour  empêcher  la  ligne  de  se  créer.
Le  deuxième  type  de  stratégie  à  utiliser  pour  gagner consiste à encercler un ou plusieurs plots de l’adversaire (Nous ne traiterons pas celle-ci pour le moment).

deroulement d'une partie:
La durée moyenne d’une partie est de 5 minutes.  
1.  Les  joueurs  s’assoient  et  jouent  à  angle  droit  devant  le plateau de jeu. 
2.  Chaque  joueur  choisit  la  couleur  de  ses  pièces  et  se place devant les flèches de la couleur correspondante. 
3.  Les  joueurs  jouent  chacun  à  leur  tour  et  ne  placent qu’une seule pièce à la fois. 
4.  Les  joueurs  placent  leurs  pièces  où  ils  veulent en fonction  de  leur  stratégie,  mais  de  sorte  que  la  ligne  de 
couleur  des  pièces  s’aligne  toujours  avec  celle  des plots. Toute  pièce  placée  au  bord  du  plateau  doit  également 
relier  deux  plots  de  même  couleur.  Aucune  pièce  ne doit être positionnée dans les angles. 
5.  La  ligne  continue  (souvent  en  zig-zag)  ne  peut  se  faire que  dans  l’axe  des  flèches  devant  lesquelles  les  joueurs 
sont assis. 
6. Les joueurs ne sont pas obligés de poser leurs pièces à côté de celles déjà placées sur le plateau

Définitions. 
Faire  une ”ligne” ou  faire  une  ”connexion”  signifie  tracer une ligne continue avec des pièces de la même couleur à 
partir  d’un  bord  du  plateau,  jusqu’aux  plots  de  même couleur,  situés  à  l’opposé.  La  ligne  peut  être  droite  ou 
brisée, avec ou sans ramifications. 
Un ”encerclement” signifie   entourer   un   plot   ou   un ensemble de pièces adverses avec ses propres pièces.



#Cahier des Charges:
Alors notre commanditaire nous l'a demandé, le voila :
Un petit cahier des charges.

##plusieurs modeles possible:
###Modele aretes uniquement
Un modele basé uniquement sur des aretes. Le principe de ce modele est simple. Vu que les utilisateurs ne font que rajouter des pions. Le systeme n'enregistre que les pions. Pour retranscrire tout le plateau le systeme va simuler des noeuds artificiels en utilisant les pions comme aretes d'un graphe en maths.
Avantages de ce modele : on utilise peu de memoire. Au final on enregistre que le necessaire absolu.
Inconvenient : Pose certains problemes au systeme : Pour gérer l'interaction, le plateau doit quand meme etre simulé ce qui peut demander plus de ressources.
Un autre gros inconvénient c'est que le plateau enregistré ne correspond pas au plateau réel. L'affichage est donc bien moche et un systeme pour redécaler les cases est necessaire pour avoir un plateau a peu pres jouable.

###Modele tableau aretes et noeuds
Le deuxieme modele possible serait de tout enregistrer. Faire un gros tableau avec les plots et les pions joués par les utilisateurs. 
avantages:
Probablement le modele le plus simple et le plus correspondant au plateau réel
inconvenients
Il demande quand meme une certaine quantité d'espace memoire et un systeme pour verifier le gagnant plutot complexe

###Modele classes de connéxités
Le dernier modele n'est pas indépendant. C'est un systeme qui ne représentes pas du tout le plateau réel et ne permet donc pas de l'afficher. Il faut donc l'utiliser en jointure avec un des deux autres.
Le principe est assez mathématique: il voudrait définir les ensembles de pions reliés comme des classes de connéxités.
Avantages:
Ceci simpliferais énormément certaines fonctions du systeme. Par exemple pour vérifier qu'un joueur est gagnant il n'y aurais pas un parcours a faire a travers les pions reliés du joueur et vérifier si les deux cotés du chemin sont sur les deux bords du plateau. Il suffirait de vérifier si la classe de connéxité du dernier pion rajouté admet deux pions aux bords de plateau. Ce qui est beaucoup plus simple a faire et beaucoup moins demandant.
Inconvenient:
Ce n'est pas independant. Il faut donc quand meme un autre systeme pour enregister tous le plateau en plus de toutes les classes de connéxités. Gérer les classes de connéxités pose aussi quelques problemes, par exemple il faut les enregistrer dynamiquement car les classes peuvent etre crées ou détruites tout au long de la partie. Ou lorsqu'un pion relie deux classes de connexités ensemble il faut avoir un systeme qui transforme tous les pîons de cette classe en une seule classe.


##Fonctions a réaliser:
Nous avons décidés d'utilser le modele enregistrant des Aretes uniquement.
Le code du Gymkhana sera donc divisé en plusieurs parties qui auront chacune une series de fonctions :

###Tout d'abord les verifications
A la creation du jeu il faut qu'il soit jouable en ligne de commande. L'utilisateur a donc la possibilité 
d'entrer n'importe quoi.
Il est donc necessaire d'avoir:
Une verification que les valeurs entrées soient des valeurs numeriques
Une verification que les valeurs entrées existent dans le plateau

Ensuite pour tout le jeu il faut verifier que l'utilisateur n'essayes pas de rejouer un pion sur un pion existant

Pour mettre tout ceci au propre une fonction gerant toutes les verifications peut etre utile


Une fonction pour verifier que le jeu est fini! Logiquement le jeu ne peut que se finir avec un gagnant. Cette fonction est assez complexe est dépdend du modele utilisé.
Dans notre cas A chaque fois qu'un pion est rajouté cette fonction va lancer une fonction auxiliaire recursive sur les deux noeuds du pion: Il y auras ensuite un parcours des tous les voisins du pion pour verifier que de chaque coté il n'y en ai pas un qui soit sur le bord du plateau.


###La structure Generale du jeu
Une fonction regissant un tour: Il boucle une demande d'input a l'utilisateur en verifiant les donnes recues a chaque fois. Renvoie le pion a rajouter.

Une fonction gerant la structure generale du jeu : Un boucle qui continues jusqu'a ce qu'il y ait un gagnant. Elle appeleras la fonction gerant un tour avec les joueurs alternatifs.


###Fonctions utilitaires
Recuperer les donnes
	En lignes de commandes nous pourront utiliser un scanner
	En interface graphique... A voir

Avant d'avoir une vraie interphace graphique, on va juste afficher notre tableau.

Si on a la fois on le representeras de maniere jolie.

###Fonctions pour une interface graphique

??
Nous n'avons pas encore vus comment gerer une interface graphique, nous nous occuperons de ceci plus tard


###Fonctions pour notre IA
En tout premier, quelque chose de simple : Une IA qui choisie de maniere completement aléatoire ses coups.

Ensuite il faudra faire plus de recherches sur le fonctionnement de l'algorithme minimaxi pour avancer.
 
