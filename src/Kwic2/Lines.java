package Kwic2;

public class Lines
{
    public String originalLine;
    public String shiftedLine;

    public String getOriginalLine()
    {
        return originalLine;
    }

    public void setOriginalLine(String originalLine)
    {
        this.originalLine = originalLine;
        String line[] = originalLine.split(" ", 2);
        shiftedLine = line[1] + " " + line[0];
    }

    public String getShiftedLine()
    {
        return shiftedLine;
    }

    public void setShiftedLine(String shiftedLine)
    {
        this.shiftedLine = shiftedLine;
    }
}
