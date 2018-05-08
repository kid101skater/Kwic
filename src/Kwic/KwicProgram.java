package Kwic;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KwicProgram
{
    // Setup our variables
    private static final ArrayList<String> allLines = new ArrayList<String>();
    private static final ArrayList<String> shiftedLines = new ArrayList<String>();
    private static final String READ_FILE_PATH = "readfile.txt";
    private static  final String OUTPUT_FILE_PATH = "output.txt";


    public static void main(String[] args)
    {
        readLinesFromFile();
        shiftLines();
        sortShiftedLines();
        writeDataToFile();
    }

    public static void readLinesFromFile()
    {
        try
        {
            File file = new File(READ_FILE_PATH);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
               allLines.add(line);
            }
            fileReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void shiftLines()
    {
        for(int i = 0; i < allLines.size(); i++)
        {
            String line[] = allLines.get(i).split(" ", 2);
            shiftedLines.add(line[1] + " " + line[0]);
        }
    }

    public static void sortShiftedLines()
    {
        Collections.sort(shiftedLines);
    }

    public static void writeDataToFile()
    {
        File file = new File(OUTPUT_FILE_PATH);
        if(file.exists())
        {
            file.delete();
        }
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH));
            for(String s : shiftedLines)
            {
                System.out.println(s);
                writer.write(s + "\n");
            }

            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
