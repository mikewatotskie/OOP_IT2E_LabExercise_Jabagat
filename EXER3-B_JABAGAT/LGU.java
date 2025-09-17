public class LGU extends MatiSense {
    String department;

    public LGU(String systemName, String department) {
        super(systemName);
        this.department = department;
    }

    public void manageReports() {
        System.out.println(department + " department is managing citizen reports.");
    }

    public void publishAnnouncement(String announcement) {
        System.out.println(department + " department published: " + announcement);
    }

    public void analyzeData() {
        System.out.println(department + " department is analyzing data using maps and dashboards.");
    }
}
