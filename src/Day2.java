import java.util.List;

public class Day2 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        final List<String> commands = readLines("input-2-1.txt");

        int x = 0;
        int d = 0;

        for (String command : commands)
        {
            final String[] split = command.split(" ");

            switch (split[0])
            {
                case "forward":
                    x += Integer.parseInt(split[1]);
                    break;
                case "up":
                    d -= Integer.parseInt(split[1]);
                    break;
                case "down":
                    d += Integer.parseInt(split[1]);
                    break;
                default:
                    break;
            }
        }

        return String.valueOf(x * d);
    }

    @Override
    protected String solve2()
    {
        final List<String> commands = readLines("input-2-1.txt");

        int x = 0;
        int d = 0;
        int aim = 0;

        for (String command : commands)
        {
            final String[] split = command.split(" ");

            final int val = Integer.parseInt(split[1]);
            switch (split[0])
            {
                case "forward":
                    x += val;
                    d += (aim * val);
                    break;
                case "up":
                    aim -= val;
                    break;
                case "down":
                    aim += val;
                    break;
                default:
                    break;
            }
        }

        return String.valueOf(x * d);
    }
}
