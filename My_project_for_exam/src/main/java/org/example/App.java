package org.example;

import org.example.controller.Controller;
import org.example.memory.DbAnimals;
import org.example.view.ConsoleView;
import org.example.view.View;


public class App {

    public static void run(){
    Controller controller = new Controller(new DbAnimals());
    View view = new ConsoleView(controller);

        while (true) {
        view.showStorage();
        View.MainMenu code = view.showMainMenuWithResult();
        switch (code) {
            case ADD_ANIMAL -> {
                boolean result = view.showAddAnimalDiaog();
                String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                System.out.println(resMessage);
            }
            case SHOW_COMANDS -> {
                view.showDetailInfoAnimalDialog();
            }
            case EXIT -> {
                System.out.println("Bye!");
                return;
            }
        }
    }
}
}
