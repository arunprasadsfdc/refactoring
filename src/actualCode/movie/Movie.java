package actualCode.movie;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this.priceCode = _priceCode;
    }
}
