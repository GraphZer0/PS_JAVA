package PracticalWorkNumberThree;

import java.util.Random;

public class MusicPlaylist {

    private String[] songs;
    private int size;

    public MusicPlaylist() {
        songs = new String[5];
        size = 0;
    }

    // 1. Добавление песни
    public void addSong(String title) {
        if (size == songs.length) {
            resize();
        }
        songs[size++] = title;
    }

    // 2. Удаление песни по индексу
    public void removeSong(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            songs[i] = songs[i + 1];
        }

        songs[--size] = null;
    }

    public void moveSong(int from, int to) {
        checkIndex(from);
        checkIndex(to);

        if (from == to) return;

        String temp = songs[from];

        if (from < to) {
            for (int i = from; i < to; i++) {
                songs[i] = songs[i + 1];
            }
        } else {
            for (int i = from; i > to; i--) {
                songs[i] = songs[i - 1];
            }
        }

        songs[to] = temp;
    }

    public void shuffle() {
        Random random = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            String temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }
    }

    private void resize() {
        String[] newSongs = new String[songs.length * 2];
        for (int i = 0; i < songs.length; i++) {
            newSongs[i] = songs[i];
        }
        songs = newSongs;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

}