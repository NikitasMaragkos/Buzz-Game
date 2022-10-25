package Buzz;


//import com.sun.tools.sjavac.comp.FileObjectWithLocation;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveData {


    //private ArrayList<String> savedata = new ArrayList<>();


    public SaveData(ArrayList<Player> player) throws IOException {
        File file = new File("save");
        FileReader fr = new FileReader(file);
        BufferedReader br  = new BufferedReader(fr);


        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> points = new ArrayList<>();
        String line;

        while((line = br.readLine())!=null)
        {

            String[] data;
            data = line.split("//");
            names.add(data[0]);
            System.out.println("Data 0 - " + data[0]);
            points.add(Double.parseDouble(data[1]));
            System.out.println("Data 1 - " + data[1]);
        }


        for (int i = 0; i <player.size(); i++)
        {
            boolean flag = false;
            for (int j = 0; j < names.size(); j++)
            {
                if (player.get(i).getName().equals(names.get(j)))
                {
                    flag = true;
                    if (points.get(j) < player.get(i).getPoints())
                    {
                        points.set(j,player.get(i).getPoints());
                    }
                }
            }
            if(flag==false)
            {
                names.add(player.get(i).getName());
                points.add(player.get(i).getPoints());
            }
        }
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWrite = new PrintWriter(fileWriter);
        for (int i = 0; i <names.size(); i++)
        {
            printWrite.println(names.get(i) + "//" + points.get(i));
        }
        printWrite.close();

    }
}