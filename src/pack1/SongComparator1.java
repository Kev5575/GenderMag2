package pack1;
import java.util.Comparator;

public class SongComparator1 implements Comparator<String[]> {

    @Override
    public int compare(String[] song1, String[] song2) {
        return song1[1].compareTo(song2[1]);
    }
}


