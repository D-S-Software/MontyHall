import java.lang.*;
import java.util.*;

public class CreateFile {

    private Formatter resultsFile;

    public void openFile()
    {
        try
        {
            resultsFile = new Formatter("results.txt");
        }
        catch(Exception e)
        {
            System.out.println("There is an error");
        }
    }

    public void addRecords(boolean[] array)
    {
        resultsFile.format("%s%s%s", "[", arrayToString(array), "]");
    }

    public void closeFile()
    {
        resultsFile.close();
    }

    public void addSpace()
    {
        resultsFile.format("\n");
    }

    public String arrayToString(boolean[] array)
    {
        String output = array[0] + "";
        for(int i = 1; i < array.length; i++)
        {
            output += " " + array[i];
        }
        return output;
    }
}
