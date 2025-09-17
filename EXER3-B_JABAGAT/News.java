public class News extends MatiSense {
    String headline;

    public News(String systemName, String headline) {
        super(systemName);
        this.headline = headline;
    }

    public void publishNews() {
        System.out.println("News update: " + headline);
    }
}
