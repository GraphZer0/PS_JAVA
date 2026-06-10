package JavaCoreCollectionSecond.TheRankingSystem.service;

import JavaCoreCollectionSecond.TheRankingSystem.exceptions.InvalidTopRequestException;
import JavaCoreCollectionSecond.TheRankingSystem.exceptions.PlayerNotFoundException;
import JavaCoreCollectionSecond.TheRankingSystem.model.Player;

import java.util.List;

public interface RankingManager {

    void addPlayer(Player player);

    void updatePlayerRating(int playerId, int newRating)
            throws PlayerNotFoundException;

    List<Player> getTopPlayers(int n)
            throws InvalidTopRequestException;

    int getPlayerRank(int playerId)
            throws PlayerNotFoundException;
}