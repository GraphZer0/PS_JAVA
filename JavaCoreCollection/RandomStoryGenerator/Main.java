package JavaCoreCollection.RandomStoryGenerator;

import JavaCoreCollection.RandomStoryGenerator.UI.Menu;
import JavaCoreCollection.RandomStoryGenerator.service.StoryService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StoryService service = new StoryService();
        Menu menu = new Menu(service);
        menu.start();
    }
}