import java.util.Arrays;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        return LSD(asciis);
    }

    private static String helperComplement(String str, int needLen, boolean LorM) {
        if (str.length() >= needLen) return str;
        String res = str;
        for (int i = str.length(); i < needLen; ++i) {
            if (LorM) {
                res = ((char) 0) + res;
            } else
                res += (char) 0;
        }
        return res;
    }

    /**
     * LSD helper method that performs a non-destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static String[] sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        // As you wish
        boolean lm = false;
        int maxSize = getMaxSize(asciis);
        // Make a new array
        String[] ns = new String[asciis.length];
        // Find min and max
        int min = helperComplement(asciis[0], maxSize, lm).charAt(index), max = min;
        for (String s : asciis) {
            String t = helperComplement(s, maxSize, lm);
            if (t.charAt(index) > max) max = t.charAt(index);
            if (t.charAt(index) < min) min = t.charAt(index);
        }
        max -= min;
        // Make starts a position array and initialize
        int[] starts = new int[max + 1];
        // Counting
        for (String s : asciis) {
            ++starts[helperComplement(s, maxSize, lm).charAt(index) - min];
        }
        // Get the end position
        for (int i = 0; i < starts.length - 1; ++i) {
            starts[i + 1] += starts[i];
        }
        for (int i = asciis.length - 1; i > -1; --i) {
            ns[--starts[
                    helperComplement(asciis[i], maxSize, lm).charAt(index) - min
                    ]] = asciis[i];
        }
        return ns;
    }

    private static String[] LSD(String[] asciis) {
        if (asciis.length < 2) return asciis;
        // Find the longest
        int maxL = getMaxSize(asciis);
        // Copy strings
        String[] ns = copyStrArr(asciis);
        // Sort
        for (int i = maxL; i > 0; --i) {
            ns = sortHelperLSD(ns, i - 1);
        }
        return ns;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static String[] sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        // Get maxSize
        int maxSize = getMaxSize(asciis);
        if (index >= maxSize) return asciis;
        if (start > end) throw new IllegalArgumentException();
        if (asciis.length < 2 || start == end) return asciis;
        boolean lm = false;
        // Copy the array
        String[] ns = copyStrArr(asciis);
        // Get min and max
        int min = helperComplement(ns[start], maxSize, lm).charAt(index), max = min;
        for (int j = start; j < end; ++j) {
            String t = helperComplement(ns[j], maxSize, lm);
            if (min > t.charAt(index)) min = t.charAt(index);
            if (max < t.charAt(index)) max = t.charAt(index);
        }
        max -= min;
        // Make starts
        int[] starts = new int[max + 1];
        initializeArray(starts);
        // Counting
        for (int j = start; j < end; ++j) {
            String t = helperComplement(ns[j], maxSize, lm);
            ++starts[t.charAt(index) - min];
        }
        // Set positions
        for (int j = 0; j < starts.length - 1; ++j) {
            starts[j + 1] += starts[j];
        }
        // Send back
        String[] nt = new String[end - start];
        int[] stsBackup = copyIntArr(starts);
        for (int j = end - 1; j > start - 1; --j) {
            String t = helperComplement(ns[j], maxSize, lm);
            nt[--starts[t.charAt(index) - min]] = ns[j];
        }
        System.arraycopy(nt, 0, ns, start, end - start);
        ns = sortHelperMSD(ns, start, start + stsBackup[0], index + 1);
        for (int j = 1; j < stsBackup.length; ++j) {
            ns = sortHelperMSD(
                    ns, start + stsBackup[j - 1], start + stsBackup[j], index + 1
            );
        }

        return ns;
    }

    private static int getMaxSize(String[] str) {
        int maxSize = 0;
        for (String s : str) {
            if (maxSize < s.length()) maxSize = s.length();
        }
        return maxSize;
    }

    private static String[] copyStrArr(String[] str) {
        String[] ns = new String[str.length];
        System.arraycopy(str, 0, ns, 0, ns.length);
        return ns;
    }

    private static int[] copyIntArr(int[] arr) {
        int[] na = new int[arr.length];
        System.arraycopy(arr, 0, na, 0, arr.length);
        return na;
    }

    private static void initializeArray(int[] arr) {
        Arrays.fill(arr, 0);
    }

    public static String[] MSD(String[] asciis) {
        return sortHelperMSD(asciis, 0, asciis.length, 0);
    }
}
