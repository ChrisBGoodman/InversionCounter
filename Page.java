package InversionCounter;

/**
 * Class to hold info for our pages
 */
public class Page implements Comparable {
    private int number;
    private int value;

    /**
     * Creates a page
     * @param i Page Number
     * @param v Page Value from source
     */
    public Page(int i, int v) {
        number = i;
        value = v;
    }

    /**
     * Get the page number
     * @return page number
     */
    public int getPageNumber(){
        return number;
    }

    /**
     * Get the value associated the the page
     * @return value
     */
    public int getPageValue() {
        return value;
    }

    /**
     * Set the value for the page
     * @param i value to set
     */
    public void setPageValue(int i) {
        value = i;
    }

    /**
     * Add value to the page's value
     * @param i amount to increment
     */
    public void incrementValue(int i) {
        value += i;
    }

    @Override
    public int compareTo(Object o) {
        Page page = (Page)o;
        return value < page.value ? -1 : value == page.value ? 0 : 1;
    }
}
