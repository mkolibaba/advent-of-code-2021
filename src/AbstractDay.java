import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractDay implements Day
{
    @Override
    public final void printSolution1()
    {
        System.out.println(solve1());
    }

    @Override
    public final void printSolution2()
    {
        System.out.println(solve2());
    }

    abstract protected String solve1();

    abstract protected String solve2();

    protected List<String> readLines(String filename)
    {
        List<String> result = new ArrayList<>();
        try
        {
            final Scanner scanner = new Scanner(new File("res/" + filename));
            while (scanner.hasNextLine())
            {
                result.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        return result;
    }
}
