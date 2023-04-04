package Kinomichi;


import Kinomichi.Activite.Activite;
import Kinomichi.Menu.Menu;
import Kinomichi.Menu.MenuBuilder;
import Kinomichi.Personne.Personne;

import java.time.DateTimeException;
import java.util.List;

    public class KinomichiVue {
        private Controller controller = new Controller();

        private MenuBuilder menuBuilder = new MenuBuilder();

//        public void getVue(){
//            RecupData recupData = new RecupData();
//            recupData.load();
//            Data data = recupData.getData();
//
////            List<PersonneModel> fileListPersonneModel = data.getFileListPersonneModel();
////            List<AbstractActivitesModel> fileListActivite = data.getFileListActivite();
//
//            Menu menuPrincipal = getMenuPrincipal(fileListPersonneModel, fileListActivite);
//            while (!menuPrincipal.isFinish()){
//                menuPrincipal.execute();
//                recupData.save();
//            }
//        }

        public Menu getMenuPrincipal(){
            Menu menuPrincipal = menuBuilder.start("Kinomichi.Menu Principal");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------------Kinomichi.Menu principal-----------------------------");
            System.out.println("-----------------------------------------------------------------------");
            getGestionPersonne();
//            getGestionActivite(personne, activite);
//            getGestionInscription(personne, activite);
            menuBuilder.addItem("q", "Quitter", () -> menuPrincipal.setFinish(true));
            menuBuilder.end();

            while (!menuPrincipal.isFinish()) {
                menuPrincipal.execute();
            }

            return menuPrincipal;

        }

        public void getGestionPersonne(){


            Menu menuGestionPersonne = menuBuilder.startMenu("1", "Gestion des personnes");
            menuBuilder.addItem("1", "Ajouter une personne", () -> controller.addPersonne());
            menuBuilder.addItem("2", "Afficher la liste", () -> controller.printListePersonnes());
            menuBuilder.addItem("3", "Supprimer une personne", () -> controller.supprimerPersonne());
            menuBuilder.addItem("4", "Modifier une personne", () -> controller.modifierPersonne());
            menuBuilder.addItem("q", "Quitter", () -> menuGestionPersonne.setFinish(true));
            menuBuilder.endMenu();


        }



//        public void getGestionActivite(List<Personne> personne, List<Activite> activite){
//            Menu gestionDesActivites = menuBuilder.startMenu("2", "Gestion des activités");
//            try{
//                menuBuilder.addItem("1", "Ajouter une activité", listeActivite.addToListActivite(fileListActivite));
//            }catch (DateTimeException e){
//                System.out.println(e.getMessage());
//            }
//            menuBuilder.addItem("2", "Liste des activité", vueActivites.getScreenAllActivite(activite));
//            menuBuilder.addItem("3", "Supprimer une activité", listeActivite.deleteActivite(personne, activite));
//            menuBuilder.addItem("4", "Modifier une activité", listeActivite.modifyActivite(activite));
//            menuBuilder.addItem("5", "Ajouter un responsable", listeActivite.addResponsable(personne, activite));
//            menuBuilder.addItem("6", "Modifier un responsable", listeActivite.modifyResponsable(personne, activite));
//            menuBuilder.addItem("q", "Quitter", () -> gestionDesActivites.setFinish(true));
//            menuBuilder.endMenu();
//        }

//        public void getGestionInscription(List<Personne> personne, List<Activite> activite){
//            Menu gestionDesInscriptions = menuBuilder.startMenu("3", "Gestion des inscriptions");
//            menuBuilder.addItem("1", "Inscrire une personne a une activité", controller.inscrirePersonneActivite(personne, activite););
//            menuBuilder.addItem("2", "Afficher la liste des activités et des inscrits", vueInscription.getScreenMap(personne, activite));
//            menuBuilder.addItem("q", "Retour", () -> gestionDesInscriptions.setFinish(true));
//            menuBuilder.endMenu();
//        }


    }

