// Base Class
public class MatiSense {
    protected String systemName;

    public MatiSense(String systemName) {
        this.systemName = systemName;
    }

    // Polymorphic method (overridden by subclasses)
    public void showInfo() {
        System.out.println("System: " + systemName);
    }
}
