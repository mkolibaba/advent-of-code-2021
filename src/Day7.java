import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day7 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        final List<Integer> crabs = Arrays.stream(readLines("input-7-1.txt").get(0).split(",")).map(Integer::parseInt)
            .collect(Collectors.toList());

        final int median = median(crabs);

        return String.valueOf(
            crabs.stream()
                .mapToInt(v -> Math.abs(median - v))
                .sum()
        );
    }

    @Override
    protected String solve2()
    {
        final List<Integer> crabs = Arrays.stream(readLines("input-7-1.txt").get(0).split(",")).map(Integer::parseInt)
            .collect(Collectors.toList());

        final int mean = mean(crabs);

        return String.valueOf(
            crabs.stream()
                .mapToInt(v -> sum1ToN(Math.abs(mean - v)))
                .sum()
        );
    }

    private int median(List<Integer> list)
    {
        Collections.sort(list);
        final int len = list.size();
        return len % 2 == 1
            ? list.get(len / 2)
            : Integer.valueOf((list.get(len / 2 - 1) + list.get(len / 2)) / 2);
    }

    private int mean(List<Integer> list)
    {
        return list.stream().mapToInt(v -> v).sum() / list.size();
    }

    private int sum1ToN(int n)
    {
        return n * (n + 1) / 2;
    }
}
