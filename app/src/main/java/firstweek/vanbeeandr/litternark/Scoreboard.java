package firstweek.vanbeeandr.litternark;

/**
 * Created by hofflajaco on 23/02/2017.
 */

public class Scoreboard {

    public static String[][] initArray(){
        String[][] scoreArray = new String[10][2];
        String input = "";

        for(int i = 0; i < 10; i++){

            if(i == 0) input = "Mc Donalds";
            if(i == 1) input = "Coca Cola";
            if(i == 2) input = "Monster Energy Drink";
            if(i == 3) input = "New World";
            if(i == 4) input = "Cigarettes";
            if(i == 5) input = "Tui";
            if(i == 6) input = "Burger King";
            if(i == 7) input = "Starbucks";
            if(i == 8) input = "Tinder for Cannibals";
            if(i == 9) input = "Cadbury";

            for(int j = 0; j < 2; j++){

                if(j == 1){
                    input = "0";
                }

                scoreArray[i][j] = input;
            }
        }
        return scoreArray;
    }

    public static String[][] updateNark(String[][] scoreArray, String company){

        String comp = "";

        for(int i = 0; i < 10; i++){
            comp = scoreArray[i][0];

            if(comp.equals(company)){
                String narkstring = scoreArray[i][1];
                int narks = Integer.parseInt(narkstring);
                narks++;
                scoreArray[i][1] = "" + narks;
            }
        }

        return scoreArray;
    }

    public String[][] reorderScores(String[][] oldScores){
        String[][] newScores = new String[10][2];
        int maxNarks = -1;
        String maxComp = "";

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                maxNarks = -1;
                String narkStr = oldScores[j][1];
                int currNarks = Integer.parseInt(narkStr);

                if(currNarks > maxNarks){
                    maxNarks = currNarks;
                    maxComp = oldScores[j][0];
                }
            }

            newScores[i][0] = maxComp;
            newScores[i][0] = "" + maxNarks;

            for(int k = 0; k < 10; k++){
                String removeComp = oldScores[k][0];
                if(removeComp.equals(maxComp)){
                    oldScores[k][1] = "" + -1;
                }
            }
        }

        return newScores;
    }
}
