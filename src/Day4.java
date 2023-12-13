import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Day4 extends AbstractDay
{
    @Override
    protected String solve1()
    {
        List<String> lines = readLines("input-4-1.txt");

        List<int[][]> boards = new ArrayList<>();

        int[][] currentBoard = new int[5][];
        int currentLine = 0;

        for (int i = 2; i < lines.size(); i++)
        {
            String line = lines.get(i);
            if (line.equals(""))
            {
                boards.add(currentBoard);
                currentBoard = new int[5][];
                currentLine = 0;
            }
            else
            {
                currentBoard[currentLine] =
                    Arrays.stream(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                currentLine++;
            }
        }

        final List<Integer> numbers =
            Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());

        for (Integer number : numbers)
        {
            for (int[][] board : boards)
            {
                processBoard(board, number);
                if (checkBoard(board))
                {
                    int sum = 0;
                    for (int[] row : board)
                    {
                        for (int cell : row)
                        {
                            if (cell > 0)
                            {
                                sum += cell;
                            }
                        }
                    }

                    return String.valueOf(sum * number);
                }
            }
        }

        return "0";
    }

    @Override
    protected String solve2()
    {
        List<String> lines = readLines("input-4-1.txt");

        List<int[][]> boards = new ArrayList<>();

        int[][] currentBoard = new int[5][];
        int currentLine = 0;

        for (int i = 2; i < lines.size(); i++)
        {
            String line = lines.get(i);
            if (line.equals(""))
            {
                boards.add(currentBoard);
                currentBoard = new int[5][];
                currentLine = 0;
            }
            else
            {
                currentBoard[currentLine] =
                    Arrays.stream(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                currentLine++;
            }
        }

        final List<Integer> numbers =
            Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());

        int currentNumber = 0;
        for (Integer number : numbers)
        {
            for (int i = 0; i < boards.size(); )
            {
                final int[][] board = boards.get(i);
                processBoard(board, number);
                if (checkBoard(board))
                {
                    if (boards.size() == 1)
                    {
                        int sum = 0;
                        for (int[] row : board)
                        {
                            for (int cell : row)
                            {
                                if (cell > 0)
                                {
                                    sum += cell;
                                }
                            }
                        }
                        return String.valueOf(sum * number);
                    }
                    else
                    {
                        boards.remove(board);
                    }
                }
                else
                {
                    i++;
                }
            }
        }

        final int[][] board = boards.get(0);

        return "0";
    }

    private void processBoard(int[][] board, int number)
    {
        for (final int[] row : board)
        {
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] == number)
                {
                    row[j] = -1 * number;
                    break;
                }
            }
        }
    }

    private boolean checkBoard(int[][] board)
    {
        int val = 0;
        for (int i = 0; i < board.length; i++)
        {
            final int[] row = board[i];
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] < 0)
                {
                    val += row[j];
                }
                else
                {
                    val = 0;
                    break;
                }
            }
            if (val < 0)
            {
                return true;
            }
        }

        val = 0;

        for (int i = 0; i < board[0].length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                int b = board[j][i];
                if (b < 0)
                {
                    val += b;
                }
                else
                {
                    val = 0;
                    break;
                }
            }
            if (val < 0)
            {
                return true;
            }
        }

        return false;
    }
}
