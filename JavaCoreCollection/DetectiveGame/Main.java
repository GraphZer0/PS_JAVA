package JavaCoreCollection.DetectiveGame;

import JavaCoreCollection.DetectiveGame.service.DetectiveService;
import JavaCoreCollection.DetectiveGame.UI.Menu;

public class Main {
    public static void main(String[] args) {
        DetectiveService service = new DetectiveService();
        Menu menu = new Menu(service);
        menu.start();
    }
}