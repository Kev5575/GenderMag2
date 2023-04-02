package pack1;

import java.util.ArrayList;
import java.util.List;

public class SearchSongs {
    public static Song[] searchSongsByName(Song[] songs, String name) {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getName().equals(name)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs.toArray(new Song[matchingSongs.size()]);
    }


    public static List<Song> searchSongsByYearAndName(List<Song> songs, String year, String name) {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getYear().equals(year) && song.getName().equals(name)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs;
    }


}