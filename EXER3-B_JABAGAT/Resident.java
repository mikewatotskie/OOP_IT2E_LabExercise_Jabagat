public class Resident extends MatiSense {
    String residentName;

    public Resident(String systemName, String residentName) {
        super(systemName);
        this.residentName = residentName;
    }

    public void reportIssue(String issue) {
        System.out.println(residentName + " reported an issue: " + issue);
    }

    public void trackStatus(int reportId) {
        System.out.println(residentName + " is tracking status of report #" + reportId);
    }

    public void viewUpdates(String update) {
        System.out.println(residentName + " viewed update: " + update);
    }
}
