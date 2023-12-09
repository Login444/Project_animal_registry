package org.example.view;

import org.example.animals.abstractAnimals.Animal;

public interface View {
    enum MainMenu {
        ADD_ANIMAL ("Занести животное"),
        SHOW_COMANDS ("Показать команды животного"),
        EXIT ("Выйти");

        private String tag;

        MainMenu(String tag){
            this.tag = tag;
        }

        public String getTag(){
            return tag;
        }
    }

    enum AddComandMenu{
        ADD_COMAND ("Обучить команде"),
        EXIT ("Выйти");
         private String tag;
         AddComandMenu(String tag){
             this.tag = tag;
         }
         public String getTag(){
             return tag;
         }
    }

    void showStorage();
    MainMenu showMainMenuWithResult();
    boolean showAddAnimalDiaog();
    void showDetailInfoAnimalDialog();
    void showAnimalInfo(Animal animal);
    AddComandMenu showAddComandMenu(Animal animal);
    boolean showAddComandDialog(Animal animal);
}
