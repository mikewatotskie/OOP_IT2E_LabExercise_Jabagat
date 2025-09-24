public class News extends MatiSense {
    private String headline;

    public News(String systemName, String headline) {
        super(systemName);
        this.headline = headline;
    }

    // Runtime polymorphism
    @Override
    public void showInfo() {
        System.out.println("News from " + systemName + ": " + headline);
    }

    // Compile-time polymorphism (method overloading)
    public void publishNews() {
        System.out.println("Publishing news: " + headline);
    }

    public void publishNews(String category) {
        System.out.println("Publishing " + category + " news: " + headline);
    }
}
