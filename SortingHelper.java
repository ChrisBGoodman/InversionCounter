package InversionCounter;

import java.util.ArrayList;
import java.util.List;

public class SortingHelper {
    public static List<Page> mergeSort(List<Page> whole, Source source)
    {
        List<Page> first = new ArrayList<Page>();
        for(Page page : whole)
            first.add(page);

        List<Page> left = new ArrayList<Page>();
        List<Page> right = new ArrayList<Page>();
        int center;

        if(whole.size() == 1) //Condition to stop
            return whole;
        else
        {
            center = whole.size() / 2;
            for(int i = 0; i < center; i++)
                left.add(whole.get(i));


            for(int i = center; i < whole.size(); i++)
                right.add(whole.get(i));

            left  = mergeSort(left, source);
            right = mergeSort(right, source);
            merge(left, right, whole, source);

        }

        for(int i = 0; i < first.size(); i++) {
            if(first.get(i).getPageNumber() != whole.get(i).getPageNumber())
                source.incrementInversions();
        }

        return whole;
    }

    private static void merge(List<Page> left, List<Page> right, List<Page> whole, Source source) {

        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size())
        {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex)))<0)
            {
                whole.set(wholeIndex,left.get(leftIndex));
                leftIndex++;
            }
            else
            {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        List<Page> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        }
        else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }

    /**
     * Implement Quick Sort Here
     * @param source
     */
    public static void quickSort(Source source) {}

}
