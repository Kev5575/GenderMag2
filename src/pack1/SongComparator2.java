package pack1;

import java.util.Comparator;

public class SongComparator2  implements Comparator<String[]> {
	@Override
    public int compare(String[] song1, String[] song2) {
        return Comparator.comparing((String[] s) -> s[3]) // Compare by year
                .thenComparing((String[] s) -> s[1]) // Compare by name
                .compare(song1, song2);
    }
}
