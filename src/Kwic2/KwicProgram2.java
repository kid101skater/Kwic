package Kwic2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KwicProgram2
{
    private static final String READ_FILE_PATH = "readfile.txt";
    private static  final String OUTPUT_FILE_PATH = "output.txt";
    public static ArrayList<Lines> lines = new ArrayList<Lines>();

    public static void main(String[] args)
    {
        readFileToObject();
        sortLines();
        writeToFile();
    }

    public static void readFileToObject()
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
                Lines newLine = new Lines();
                newLine.setOriginalLine(line);
                lines.add(newLine);
            }
            fileReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void sortLines()
    {
        Collections.sort(lines, new Comparator<Lines>() {
            @Override
            public int compare(Lines l1, Lines l2) {
                return l1.toString().compareTo(l2.toString());
            }
        });
    }

    public static void writeToFile()
    {
        File file = new File(OUTPUT_FILE_PATH);
        if(file.exists())
        {
            file.delete();
        }
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH));
            for(int i = 0; i < lines.size(); i++)
            {
                String shiftedLine = lines.get(i).getShiftedLine();
                System.out.println(shiftedLine);
                writer.write(shiftedLine + "\n");
            }

            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


}
