package JavaCoreCollectionSecond.TheRankingSystem.exceptions;


public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException(int id) {
        super("Игрок с ID " + id + " не найден");
    }
}