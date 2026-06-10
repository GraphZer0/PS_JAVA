package JavaCoreCollectionSecond.TheRankingSystem;

import JavaCoreCollectionSecond.TheRankingSystem.model.Player;
import JavaCoreCollectionSecond.TheRankingSystem.service.RankingSystem;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        RankingSystem system = new RankingSystem();

        system.addPlayer(new Player(1, "Alex", 1500));
        system.addPlayer(new Player(2, "John", 1800));
        system.addPlayer(new Player(3, "Kate", 1700));
        system.addPlayer(new Player(4, "Mike", 1600));

        try {
            System.out.println("Топ-3:");
            printTopPlayers(system.getTopPlayers(3));

            system.updatePlayerRating(1, 1900);

            System.out.println("\nПосле обновления:");
            printTopPlayers(system.getTopPlayers(3));

            System.out.println("\nРанг Kate:");
            System.out.println(system.getPlayerRank(3));

            System.out.println("\nПробуем получить ранг несуществующего игрока:");
            System.out.println(system.getPlayerRank(99));

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
    private static void printTopPlayers(List<Player> players) {

        int position = 1;

        for (Player player : players) {
            System.out.println(position + ". "
                    + player.getName()
                    + " - "
                    + player.getRating());
            position++;
        }
    }
}