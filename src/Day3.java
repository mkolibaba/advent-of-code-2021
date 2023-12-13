import java.util.ArrayList;
import java.util.List;

public class Day3 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        final List<String> measurements = readLines("input-3-1.txt");
        final int[] weights = new int[measurements.get(0).length()];

        for (String measurement : measurements)
        {
            final char[] bits = measurement.toCharArray();
            for (int i = 0; i < bits.length; i++)
            {
                int weight = weights[i];
                weight += (bits[i] == '1' ? 1 : -1);
                weights[i] = weight;
            }
        }

        String gamma = "";
        String epsilon = "";
        for (Integer weight : weights)
        {
            gamma += weight > 0 ? "1" : "0";
            epsilon += weight > 0 ? "0" : "1";
        }

        return String.valueOf(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }

    @Override
    protected String solve2()
    {
        List<String> measurements = readLines("input-3-1.txt");

        String oxygen = solvesolve2(measurements, true);
        String co2 = solvesolve2(measurements, false);

        return String.valueOf(Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2));
    }

    private String solvesolve2(List<String> measurements, boolean isOxygen)
    {
        int weightsLength = measurements.get(0).length();
        int[] weights;

        List<String> result = new ArrayList<>(measurements);
        int idx = 0;
        do
        {
            weights = new int[weightsLength];

            for (String measurement : result)
            {
                final char[] bits = measurement.toCharArray();
                for (int i = 0; i < bits.length; i++)
                {
                    int weight = weights[i];
                    weight += (bits[i] == '1' ? 1 : -1);
                    weights[i] = weight;
                }
            }

            char decision = isOxygen
                ? (weights[idx] >= 0 ? '1' : '0')
                : (weights[idx] >= 0 ? '0' : '1');

            List<String> swap = new ArrayList<>();
            for (String measurement : result)
            {
                if (measurement.toCharArray()[idx] == decision) {
                    swap.add(measurement);
                }
            }

            result = new ArrayList<>(swap);
            idx = (idx + 1) % weightsLength;
        } while (result.size() != 1);

        return result.get(0);
    }
}
