package src.Blackjack;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class HSManager {
    private static String hspath = "C:\\Users\\nadir\\HelloWorld\\Poker APCS Project\\textfiles\\highscores.txt"; // Path to high score file
    private static String pfpath = "C:\\Users\\nadir\\HelloWorld\\Poker APCS Project\\textfiles\\players.txt"; // Path to player file

    /**
     * Takes no arguements
     * Creates 2 files, one to store highscores and another for the player names
     * @throws IOException
     */
    public HSManager() throws IOException {
        File myObj = new File(hspath);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }

        myObj = new File(pfpath);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    // Add a high score to the record, takes the player name and score
    // Is a static function, no need to create a HSManager object
    public static void addHS(String player, Integer score){
        try {
            FileWriter myWriter = new FileWriter(hspath, true);
            myWriter.write("\n" + score.toString());
            myWriter.close();
            myWriter = new FileWriter(pfpath, true);
            myWriter.write("\n" + player);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Wipes both files
    // Is a static function, no need to create a HSManager object
    public static void wipeHS() throws IOException {
        FileWriter myWriter = new FileWriter(hspath);
        myWriter.write("");
        myWriter.close();
        myWriter = new FileWriter(pfpath);
        myWriter.write("");
        myWriter.close();
    }

    // Get highscores
    // Takes the number of scores from the top you want as input, eg: 3 would get you the top 3 scores
    // Returns as HighScore objects
    public static HighScore[] getHS(int fromTop){
        int[] scores = readIntArray(hspath);
        String[] players = readStringArray(pfpath);
        int[] sortedScores = scores;
        Arrays.sort(sortedScores);
        System.out.println(sortedScores.length);

        HighScore[] toRet = new HighScore[fromTop];
        for (int i = 0; i < toRet.length; i++){
            int temp = sortedScores[sortedScores.length - i - 1];
            toRet[i] = new HighScore(players[findIndex(scores, temp)], temp);
        }

        return toRet;
    }

    // Int index finder off of: https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
    private static int findIndex(int arr[], int t){
        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    private static int[] readIntArray(String filepath){
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            int[] arrold = new int[0];
            int[] arr;
            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();
                arr = new int[arrold.length + 1];
                for (int i = 0; i < arrold.length; i++) {
                    arr[i] = arrold[i];
                }
                arr[arr.length - 1] = data;
                arrold = arr;
            }
            myReader.close();
            return arrold;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    private static String[] readStringArray(String filepath){
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            String[] arrold = new String[0];
            String[] arr;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arr = new String[arrold.length + 1];
                for (int i = 0; i < arrold.length; i++) {
                    arr[i] = arrold[i];
                }
                arr[arr.length - 1] = data;
                arrold = arr;
            }
            myReader.close();
            return arrold;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
