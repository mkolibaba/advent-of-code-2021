import java.util.List;

public class Day5 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        return calculate(false);
    }

    @Override
    protected String solve2()
    {
        return calculate(true);
    }

    protected String calculate(boolean withDiagonals)
    {
        int[][] graph = new int[1000][1000];

        final List<String> lines = readLines("input-5-1.txt");
        for (String line : lines)
        {
            final String[] fromTo = line.split(" -> ");

            final String[] from = fromTo[0].split(",");
            final String[] to = fromTo[1].split(",");

            final int x1 = Integer.parseInt(from[0]);
            final int x2 = Integer.parseInt(to[0]);

            final int y1 = Integer.parseInt(from[1]);
            final int y2 = Integer.parseInt(to[1]);

            final int dx = x2 - x1;
            final int dy = y2 - y1;

            if (!withDiagonals && dx != 0 && dy != 0)
            {
                continue;
            }

            final int stepX = Integer.compare(dx, 0);
            final int stepY = Integer.compare(dy, 0);

            int end = Math.max(Math.abs(dx), Math.abs(dy));

            for (int i = 0; i <= end; i++)
            {
                int x = x1 + i * stepX;
                int y = y1 + i * stepY;
                graph[y][x]++;
            }
        }

        int count = 0;
        for (int[] Oy : graph)
        {
            for (int coord : Oy)
            {
                if (coord > 1)
                {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }
}
