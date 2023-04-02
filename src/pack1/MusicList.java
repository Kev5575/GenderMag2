package pack1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MusicList {

    public static void main(String[] args) {
    	String[][] data = {
    	        {"ID", "Song_Name", "Artist", "Language", "Year"},
    	        {"", "Wonderful_U", "AGA", "English", "2019"},
    	        {"", "Devil_Eyes", "Prinze_Gala", "English", "2023"},
    	        {"", "Killing_Me_Softy_With_His_Song", "Fugees", "English", "2020"},
    	        {"", "Bohemian_Rhapsody", "Queen", "English", "1975"},
    	        {"", "Hotel_California", "Eagles", "English", "1976"},
    	        {"", "退后", "周杰伦", "Chinese", "2003"},
    	        {"", "Billie_Jean", "Michael_Jackson", "English", "1982"},
    	        {"", "Cooha", "Mark_Femino", "English", "2020"},
    	        {"", "Livin'_on_a_Prayer", "Bon_Jovi", "English", "1986"},
    	        {"", "Wonderwall", "Oasis", "English", "2020"},
    	        {"", "My_girl", "Temptations", "English", "2020"},
    	        {"", "Another_Brick_in_the_Wall", "Pink_Floyd", "English", "1979"},
    	        {"", "稻香", "周杰伦", "Chinese", "2007"},
    	        {"", "七里香", "周杰伦", "Chinese", "1982"},
    	        {"", "夜曲", "周杰伦", "Chinese", "2005"},
    	        {"", "听妈妈的话", "周杰伦", "Chinese", "2007"},
    	        {"", "青花瓷", "周杰伦", "Chinese", "2008"},
    	        {"", "简单爱", "周杰伦", "Chinese", "2003"},
    	        {"", "不能说的秘密", "周杰伦", "Chinese", "2007"},
    	        {"", "My_Heart_Will_Go_On", "Celine_Dion", "English", "1997"},
    	        {"", "晴天", "周杰伦", "Chinese", "2003"},
    	        {"", "东风破", "周杰伦", "Chinese", "2004"},
    	        {"", "The_Twist", "Chubby_Checker", "English", "1960"},
    	        {"", "Hey_Ya!", "OutKast", "English", "2003"},
    	        {"", "Wonderful_U", "AGA", "English", "2019"},
    	        {"", "Devil_Eyes", "Prinze_Gala", "English", "2023"},
    	        {"", "Killing_Me_Softy_With_His_Song", "Fugees", "English", "2020"},
    	        {"", "Bohemian_Rhapsody", "Queen", "English", "1975"},
    	        {"", "Hotel_California", "Eagles", "English", "1976"},
    	        {"", "退后", "周杰伦", "Chinese", "2003"},
    	        {"", "Billie_Jean", "Michael_Jackson", "English", "1982"},
    	        {"", "Cooha", "Mark_Femino", "English", "2020"},
    	        {"", "Livin'_on_a_Prayer", "Bon_Jovi", "English", "1986"},
    	        {"", "Wonderwall", "Oasis", "English", "2020"},
    	        {"", "My_girl", "Temptations", "English", "2020"},
    	        {"", "Another_Brick_in_the_Wall", "Pink_Floyd", "English", "1979"},
    	        {"", "稻香", "周杰伦", "Chinese", "2007"},
    	        {"", "七里香", "周杰伦", "Chinese", "1982"},
    	        {"", "夜曲", "周杰伦", "Chinese", "2005"},
    	        {"", "听妈妈的话", "周杰伦", "Chinese", "2007"},
    	        {"", "青花瓷", "周杰伦", "Chinese", "2008"},
    	        {"", "简单爱", "周杰伦", "Chinese", "2003"},
    	        {"", "不能说的秘密", "周杰伦", "Chinese", "2007"},
    	        {"", "My_Heart_Will_Go_On", "Celine_Dion", "English", "1997"},
    	        {"", "晴天", "周杰伦", "Chinese", "2003"},
    	        {"", "东风破", "周杰伦", "Chinese", "2004"},
    	        {"", "The_Twist", "Chubby_Checker", "English", "1960"},
    	        {"", "Hey_Ya!", "OutKast", "English", "2003"}
    	};
    	//Arrays.sort(data, 1, data.length, new SongComparator1());
        Arrays.sort(data, 1, data.length, new SongComparator2());
        // Define the file name and path
        String fileName = "song_table.txt";

        // Write the data to the file
        try {
            FileWriter writer = new FileWriter(fileName);

            for (String[] row : data) {
                // Generate a random 7-digit integer ID for each song
                int id = (int) (Math.random() * (9999999 - 1000000 + 1)) + 1000000;
                row[0] = String.valueOf(id);
            }
            data[0][0]="ID";

            // Define the column widths
            int[] columnWidths = {25,25, 20, 15, 10};

            // Write the table header
            for (int i = 0; i < data[0].length; i++) {
                writer.write(String.format("%-" + columnWidths[i] + "s", data[0][i]) + "\t");
            }
            writer.write("\n");

            // Write the table rows
            for (int i = 1; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    writer.write(String.format("%-" + columnWidths[j] + "s", data[i][j]) + "\t");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote the song table to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the song table to " + fileName);
            e.printStackTrace();
        }
    }
}