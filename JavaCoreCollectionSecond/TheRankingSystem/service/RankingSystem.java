package JavaCoreCollectionSecond.TheRankingSystem.service;

import JavaCoreCollectionSecond.TheRankingSystem.exceptions.PlayerNotFoundException;
import JavaCoreCollectionSecond.TheRankingSystem.model.Player;

import java.util.*;

public class RankingSystem {

    private TreeMap<Integer, Set<Player>> playerRankings =
            new TreeMap<>(Collections.reverseOrder());

    private Map<Integer, Player> playersById = new HashMap<>();

    public void addPlayer(Player player) {

        playersById.put(player.getId(), player);

        playerRankings
                .computeIfAbsent(player.getRating(), k -> new LinkedHashSet<>())
                .add(player);

        System.out.println("Добавлен игрок: " +
                player.getName() +
                " (ID: " + player.getId() +
                ", Рейтинг: " + player.getRating() + ")");
    }

    public void updatePlayerRating(int playerId, int newRating)
            throws PlayerNotFoundException {

        Player player = playersById.get(playerId);
        if (player == null) {
            throw new PlayerNotFoundException(playerId);
        }

        int oldRating = player.getRating();

        Set<Player> oldSet = playerRankings.get(oldRating);
        oldSet.remove(player);

        if (oldSet.isEmpty()) {
            playerRankings.remove(oldRating);
        }

        player.setRating(newRating);

        playerRankings
                .computeIfAbsent(newRating, k -> new LinkedHashSet<>())
                .add(player);

        System.out.println("\nОбновлен рейтинг игрока "
                + player.getName() + ": " + newRating);
    }

    public List<Player> getTopPlayers(int n) {

        List<Player> result = new ArrayList<>();

        for (Set<Player> players : playerRankings.values()) {
            for (Player p : players) {
                result.add(p);
                if (result.size() == n) {
                    return result;
                }
            }
        }

        return result;
    }

    public int getPlayerRank(int playerId)
            throws PlayerNotFoundException {

        Player player = playersById.get(playerId);
        if (player == null) {
            throw new PlayerNotFoundException(playerId);
        }

        int rank = 1;

        for (Set<Player> players : playerRankings.values()) {
            for (Player p : players) {
                if (p.equals(player)) {
                    return rank;
                }
                rank++;
            }
        }

        return -1;
    }
}