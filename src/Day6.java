import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        int days = 80;
        List<Integer> fishes = Arrays.stream(readLines("input-6-1.txt").get(0).split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        for (int i = 0; i < days; i++)
        {
            fishes = fishes.stream()
                .flatMap(f -> f > 0 ? Stream.of(f - 1) : Stream.of(8, 6))
                .collect(Collectors.toList());
        }

        return String.valueOf(fishes.size());
    }

    @Override
    protected String solve2()
    {
        int days = 256;
        List<Integer> fishes = Arrays.stream(readLines("input-6-1.txt").get(0).split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        long[] ages = new long[9];
        for (Integer fish : fishes)
        {
            ages[fish]++;
        }

        for (int i = 0; i < days; i++)
        {
            long[] iteration = new long[9];
            iteration[6] = ages[0];
            iteration[8] = ages[0];
            for (int j = 1; j < ages.length; j++)
            {
                iteration[j - 1] += ages[j];
            }
            ages = iteration;
        }

        return String.valueOf(Arrays.stream(ages).sum());
    }
}
