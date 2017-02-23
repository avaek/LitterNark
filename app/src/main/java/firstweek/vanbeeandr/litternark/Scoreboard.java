package firstweek.vanbeeandr.litternark;

import android.app.Activity;
import android.widget.TextView;

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
                    input = "1";
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

    public static String[][] reorderScores(String[][] oldScores){
        String[][] newScores = new String[10][2];
        int maxNarks = -1;
        String maxComp = "";

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                String narkStr = oldScores[j][1];
                int currNarks = Integer.parseInt(narkStr);

                if(currNarks > maxNarks){
                    maxNarks = currNarks;
                    maxComp = oldScores[j][0];
                }
            }

            newScores[i][0] = maxComp;
            newScores[i][1] = "" + maxNarks;
            maxNarks = -1;

            for(int k = 0; k < 10; k++){
                String removeComp = oldScores[k][0];
                if(removeComp.equals(maxComp)){
                    oldScores[k][1] = "" + -1;
                }
            }
        }

        return newScores;
    }

    public static void matchTable(String[][] scoreArray, Activity act){

        TextView tv11 = (TextView) act.findViewById(R.id.comp_1);
        TextView tv21 = (TextView) act.findViewById(R.id.comp_2);
        TextView tv31 = (TextView) act.findViewById(R.id.comp_3);
        TextView tv41 = (TextView) act.findViewById(R.id.comp_4);
        TextView tv51 = (TextView) act.findViewById(R.id.comp_5);
        TextView tv61 = (TextView) act.findViewById(R.id.comp_6);
        TextView tv71 = (TextView) act.findViewById(R.id.comp_7);
        TextView tv81 = (TextView) act.findViewById(R.id.comp_8);
        TextView tv91 = (TextView) act.findViewById(R.id.comp_9);
        TextView tv101 = (TextView) act.findViewById(R.id.comp_10);
        TextView tv12 = (TextView) act.findViewById(R.id.narks_1);
        TextView tv22 = (TextView) act.findViewById(R.id.narks_2);
        TextView tv32 = (TextView) act.findViewById(R.id.narks_3);
        TextView tv42 = (TextView) act.findViewById(R.id.narks_4);
        TextView tv52 = (TextView) act.findViewById(R.id.narks_5);
        TextView tv62 = (TextView) act.findViewById(R.id.narks_6);
        TextView tv72 = (TextView) act.findViewById(R.id.narks_7);
        TextView tv82 = (TextView) act.findViewById(R.id.narks_8);
        TextView tv92 = (TextView) act.findViewById(R.id.narks_9);
        TextView tv102 = (TextView) act.findViewById(R.id.narks_10);

        tv11.setText(scoreArray[0][0]);
        tv21.setText(scoreArray[1][0]);
        tv31.setText(scoreArray[2][0]);
        tv41.setText(scoreArray[3][0]);
        tv51.setText(scoreArray[4][0]);
        tv61.setText(scoreArray[5][0]);
        tv71.setText(scoreArray[6][0]);
        tv81.setText(scoreArray[7][0]);
        tv91.setText(scoreArray[8][0]);
        tv101.setText(scoreArray[9][0]);
        tv12.setText(scoreArray[0][1]);
        tv22.setText(scoreArray[1][1]);
        tv32.setText(scoreArray[2][1]);
        tv42.setText(scoreArray[3][1]);
        tv52.setText(scoreArray[4][1]);
        tv62.setText(scoreArray[5][1]);
        tv72.setText(scoreArray[6][1]);
        tv82.setText(scoreArray[7][1]);
        tv92.setText(scoreArray[8][1]);
        tv102.setText(scoreArray[9][1]);

    }
}
