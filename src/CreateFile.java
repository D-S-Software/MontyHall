import java.lang.*;
import java.io.*;
import java.util.*;

public class CreateFile {

    private Formatter ResultsFile;

    public void openFile()
    {
        try
        {
            ResultsFile = new Formatter("results/txt");
        }
        catch(Exception e)
        {
            System.out.println("There is an error");
        }
    }

    public void addRecords()
    {

    }
}
