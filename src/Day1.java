import java.util.ArrayList;
import java.util.List;

public class Day1 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        final List<String> depths = readLines("input-1-1.txt");

        int lastDepth = 0;
        int increases = 0;

        for (int i = 1; i < depths.size(); i++)
        {
            int depth = Integer.parseInt(depths.get(i));

            if (depth > lastDepth)
            {
                increases++;
            }

            lastDepth = depth;
        }

        return String.valueOf(increases);
    }

    @Override
    protected String solve2()
    {
        final List<String> depths = readLines("input-1-1.txt");
        List<Integer> windows = new ArrayList<>();

        for (int i = 2; i < depths.size(); i++)
        {
            windows.add(Integer.parseInt(depths.get(i)) + Integer.parseInt(depths.get(i - 1)) +
                Integer.parseInt(depths.get(i - 2)));
        }

        int lastWindow = 0;
        int increases = 0;

        for (int i = 1; i < windows.size(); i++)
        {
            int window = windows.get(i);

            if (window > lastWindow)
            {
                increases++;
            }

            lastWindow = window;
        }

        return String.valueOf(increases);
    }
}
