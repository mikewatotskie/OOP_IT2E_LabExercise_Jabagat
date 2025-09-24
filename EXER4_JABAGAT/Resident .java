public class Resident extends MatiSense {
    private String name;

    public Resident(String systemName, String name) {
        super(systemName);
        this.name = name;
    }

    // Runtime polymorphism
    @Override
    public void showInfo() {
        System.out.println("Resident User: " + name + " | Using " + systemName);
    }

    // Compile-time polymorphism (method overloading)
    public void reportIssue(String issue) {
        System.out.println(name + " reported: " + issue);
    }

    public void reportIssue(String issue, String location) {
        System.out.println(name + " reported: " + issue + " at " + location);
    }
}
