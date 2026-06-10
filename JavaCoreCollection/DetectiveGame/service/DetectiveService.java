package JavaCoreCollection.DetectiveGame.service;

import JavaCoreCollection.DetectiveGame.model.Evidence;

import java.util.HashSet;
import java.util.Set;

public class DetectiveService {

    private final Set<Evidence> foundEvidences = new HashSet<>();
    private final Set<Evidence> databaseEvidences = new HashSet<>();

    public DetectiveService() {
        // Инициализация базы данных
        databaseEvidences.add(new Evidence("Отпечаток пальца на двери"));
        databaseEvidences.add(new Evidence("Волосы на кресле"));
        databaseEvidences.add(new Evidence("Следы обуви в коридоре"));
    }

    // Добавление новой улики
    public boolean addEvidence(String name) {
        Evidence evidence = new Evidence(name);
        if (foundEvidences.contains(evidence)) {
            return false;
        }
        foundEvidences.add(evidence);
        return true;
    }

    // Проверка наличия улики
    public boolean hasEvidence(String name) {
        return foundEvidences.contains(new Evidence(name));
    }

    // Удаление улики
    public boolean removeEvidence(String name) {
        return foundEvidences.remove(new Evidence(name));
    }

    // Сравнение с базой данных
    public Set<Evidence> getMatchesWithDatabase() {
        Set<Evidence> matches = new HashSet<>(foundEvidences);
        matches.retainAll(databaseEvidences);
        return matches;
    }

    // Получение всех найденных улик
    public Set<Evidence> getAllFoundEvidences() {
        return new HashSet<>(foundEvidences);
    }
}