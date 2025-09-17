public class MatiSense {
    String systemName;

    public MatiSense(String systemName) {
        this.systemName = systemName;
    }

    public void showInfo() {
        System.out.println("Welcome to " + systemName + " - A Citizen Reporting and Information System.");
    }
}
