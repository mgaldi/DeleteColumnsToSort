import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] strings = new String[]{"zyx", "wvu", "tsr"};
        System.out.printf("The indices to delete are %s%n", minDeletionSize(strings));
    }

    public static List<Integer> minDeletionSize(String[] stringSequence) {
        // checks if there are at least 2 strings
        if (stringSequence.length <= 1)
            return Collections.emptyList();

        // checks if every string has the same length
        int seqLen = stringSequence.length;
        int stringLen = stringSequence[0].length();
        for (int i = 1; i < seqLen; i++) {
            if (stringLen != stringSequence[i].length())
                return Collections.singletonList(-1);
        }

        List<Integer> indices = new LinkedList<>();
        outerLoop:
        for (int i = 0; i < stringLen; i++) {
            for (int j = 0; j < seqLen - 1; j++) {
                if (stringSequence[j].charAt(i) > stringSequence[j + 1].charAt(i)) {
                    indices.add(i);
                    continue outerLoop;
                }
            }
        }
        return indices;
    }
}
