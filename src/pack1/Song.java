package pack1;
import java.io.*;
import java.util.*;


public class Song<T> {
    public static void main(String[] args) throws IOException {
//      Song song1 = new Song(1000000,"Wonderful",2.22,2019);
//      song1.setId(8473242);
//      song1.setName("Wonderful U");
//      song1.setArtist("AGA");
//      System.out.println(song1.toString());
//      System.out.println("The song id is: "+song1.getId()+" artist is: "+song1.getArtist()+"the year is: "+song1.getYear());
//      Song song2 = new Song(7417018,1,"Temptations",2020);
//      System.out.println("The id 7417018 get the wrong name of the song: "+song2.getName());
//      Song song3 = new Song(1000000,1,1,1);
//      System.out.println(song3.toString());

      //Test the readSongs method
      Song[] songs = readSongs("C:/Users/Kev/eclipse-workspace/GenderMag2/song_table.txt");
      for (Song song : songs) {
          System.out.println(song);
      }
      System.out.println("_______________");
      LinkedList<Song> songsList = readSongs_link("C:/Users/Kev/eclipse-workspace/GenderMag2/song_table.txt");
      for (Song song : songsList) {
          System.out.println(song);
      }

//      Song[] songs = new Song[5];
//      songs[0] = new Song("1", "Bohemian Rhapsody", "Queen", "1975");
//      songs[1] = new Song("2", "Hotel California", "Eagles", "1976");
//      songs[2] = new Song("3", "Wonderwall", "Oasis", "2020");
//      songs[3] = new Song("4", "My Heart Will Go On", "Celine Dion", "1997");
//      songs[4] = new Song("5", "Another Brick in the Wall", "Pink Floyd", "1979");
//
//      Song[] songByName = SearchSongs.searchSongsByName(songs, "Wonderwall");
//      //Song[] songByName = SearchSongs.searchSongsByName(songs, "Wonderwal");
//
//      if (songByName != null && songByName.length > 0) {
//          System.out.println("Song(s) found by name: ");
//          for (Song song : songByName) {
//              System.out.println(song.getName());
//          }
//      } else {
//          System.out.println("Song not found by name");
//      }
//
//      List<Song> songs1 = new ArrayList<>();
//      songs1.add(new Song("1", "Bohemian Rhapsody", "Queen", "1975"));
//      songs1.add(new Song("2", "Hotel California", "Eagles", "1976"));
//      songs1.add(new Song("3", "Wonderwall", "Oasis", "2020"));
//      songs1.add(new Song("4", "My Heart Will Go On", "Celine Dion", "1997"));
//      songs1.add(new Song("5", "Another Brick in the Wall", "Pink Floyd", "1979"));
//
//      List<Song> matchingSongs = SearchSongs.searchSongsByYearAndName(songs1, "1975", "Bohemian Rhapsody");
//      System.out.println("Songs found by year and name: ");
//      for (Song song : matchingSongs) {
//          System.out.println(song.getName());
//      }

  }
    public Song(String trim, String name, String artist, String language, String year) {
    }
    /**Data Field**/
    private T id;
    private T name;
    private T artist;
    private T year;

    /**Constructors*/
    public Song(){

    }

    public Song(T id, T name, T artist, T year) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name=" + name +
                ", artist=" + artist +
                ", year=" + year +
                '}';
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getArtist() {
        return artist;
    }

    public void setArtist(T artist) {
        this.artist = artist;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }

    //displayAllSongs Method:
    public static void displayAllSongs(LinkedList<Song> songs) {
        int count = 0;
        for (Song song : songs) {
            if(count>=3)
                break;
            System.out.println("The "+count+" music information: " + song.toString());
        }
    }

    //readSongs() method: return an array of Song objects from the .txt
    public static Song[] readSongs(String filename) throws IOException {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename)
                            ));
            String linestr;
            int numLines = 0;
            while ((linestr = br.readLine()) != null) {
                numLines++;
            }
            br.close();

            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename)));
            Song[] songs = new Song[numLines - 1];
            int i = 0;
            while ((linestr = br.readLine()) != null) {
                if (linestr.startsWith("ID")) {
                    continue;
                }
                String[] parts = linestr.split("\\s{1,}");
                String id = parts[0].trim();
                String name = parts[1].trim();
                String artist = parts[2].trim();
                String year = parts[4].trim();
                songs[i] = new Song(id, name, artist, year);
                i++;
            }
            br.close();

            return songs;
        }
        catch (Exception e) {
            System.out.println("File Fail!");
            e.printStackTrace();
        }
        return new Song[0];
    }

    //readSongs_link(): return a LinkedList of Song objects from the .txt
    public static LinkedList<Song> readSongs_link(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        LinkedList<Song> songs = new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s{1,}");
            String id = parts[0].trim();
            String name = parts[1].trim();
            String artist = parts[2].trim();
            String year = parts[4].trim();
            Song song = new Song(id, name, artist, year);
            songs.add(song);
        }
        br.close();
        return songs;
    }

    //searchSongs() Method to search Songs by their name from unsorted array
//    public static Song[] searchSongsByName(Song[] songs, String name) {
//        List<Song> matchingSongs = new ArrayList<>();
//        for (Song song : songs) {
//            if (song.getName().equals(name)) {
//                matchingSongs.add(song);
//            }
//        }
//        return matchingSongs.toArray(new Song[matchingSongs.size()]);
//    }
    //searhShongs_year() Method to search Songs by year(first) and then by name(second) from unsorted


//    public static List<Song> searchSongs_year(List<Song> songs, int year) {
//        List<Song> matchingSongs = new ArrayList<>();
//        for (Song song : songs) {
//            if (song.getYear() == year) {
//                matchingSongs.add(song);
//            }
//        }
//        Collections.sort(matchingSongs, new Comparator<Song>() {
//            @Override
//            public int compare(Song s1, Song s2) {
//                int yearComparison = Integer.compare(s1.getYear(), s2.getYear());
//                if (yearComparison != 0) {
//                    return yearComparison;
//                }
//                return s1.getName().compareTo(s2.getName());
//            }
//        });
//        return matchingSongs;
//    }



}


























