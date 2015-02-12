package InversionCounter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Source> sources = new ArrayList<Source>();
    public static Source key = new Source(new ArrayList<Page>());

    public static void buildSourceList() {
        for(int i = 1; i < 6; i++) {
            System.out.println("Loading values for source " + i);
            sources.add(FileHelper.getSourceFromFile("sources1/source" + i + ".txt"));
        }
    }

    public static void buildAverageList() {
        //Build a list with no values
        for(int i = 1; i <= sources.get(0).getSize(); i++) {
            key.addPage(new Page(i, 0));
        }

        for(Source source : sources) {
            for(int i = 1; i <= source.getSize(); i++) {
                key.getPageAtRank(i).incrementValue(source.getPageAtRank(i).getPageValue());
            }
        }

        SortingHelper.mergeSort(key.getValues(), key);

        for(Source source : sources) {
            List<Page> temp = new ArrayList<Page>();
            for (Page page : key.getValues()) {
                temp.add(new Page(page.getPageNumber(), source.findPage(page.getPageNumber()).getPageValue()));
            }
            source.setValues(temp);
        }
    }

    public static void mergeSortAll() {
        int i = 0;
        System.out.println("Starting Merge Sort: ");
        for(Source source : sources) {
            SortingHelper.mergeSort(source.getValues(), source);
            System.out.println("Source " + (++i) + " took " + source.getInversions() + " inversions");
        }
    }

    public static void quickSortAll() {
        sources.clear();
        buildSourceList();

        /**
         * DO QUICK SORT HERE something like SortingHelper.quickSort(source);
         */
    }

    public static void main(String[] args) {
        buildSourceList();
        buildAverageList();
        mergeSortAll();
        quickSortAll();
    }
}
