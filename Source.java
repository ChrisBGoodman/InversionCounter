package InversionCounter;

import java.util.List;

/**
 * Class to handle all the pages
 */
public class Source {
    private List<Page> values;
    private int inversions;

    /**
     * Creates a source object with the provided pages
     * @param list A list of pages
     */
    public Source(List<Page> list) {
        values = list;
        inversions = 0;
    }

    /**
     * Get the size of the source
     * @return how big source is
     */
    public int getSize() {
        return values.size();
    }

    /**
     * Get the page at the index (rank)
     * @param i The position of the page
     * @return The page at the rank
     */
    public Page getPageAtRank(int i) {
        if(values.get(i - 1) != null) {
            return values.get(i - 1);
        }
        return null;
    }

    /**
     * Set the page for position
     * @param page New page
     * @param i Position
     */
    public void setPage(Page page, int i) {
        values.set(i, page);
    }

    /**
     * Add a page to the source
     * @param page Page to add
     */
    public void addPage(Page page) {
        values.add(page);
    }

    public Page findPage(int pageNum) {
        for(Page page : this.values) {
            if(page.getPageNumber() == pageNum) {
                return page;
            }
        }
        return null;
    }

    public int getInversions() {
        return inversions;
    }

    public void incrementInversions() { inversions ++; }

    public void setInversions(int i) { inversions = i; }

    public void resetInversions() { inversions = 0; }

    public List<Page> getValues() {
        return values;
    }

    public void setValues(List<Page> newList) {
        values.clear();
        for(Page page : newList)
            values.add(page);

    }

    /**
     * Swap the two pages
     * @param page1 Page 1
     * @param page2 Page 2
     */
    public void swapPages(int page1, int page2) {
        Page temp = getPageAtRank(page1);
        setPage(getPageAtRank(page2), page1);
        setPage(temp, page2);
    }

    public String toString() {
        String output = "";
        for(Page page : this.values)
            output += "\n" + page.getPageNumber();

        return output;
    }
}
