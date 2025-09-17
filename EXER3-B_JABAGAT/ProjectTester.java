public class ProjectTester {
    public static void main(String[] args) {
        // Create system
        System.out.println("=== SYSTEM INFORMATION ===");
        MatiSense system = new MatiSense("MatiSense");
        system.showInfo();
        System.out.println();

        // Resident actions
        System.out.println("=== RESIDENT ACTIONS ===");
        Resident resident = new Resident("MatiSense", "Banaybanay Alingalan Jabagat");
        System.out.println("  -> Reporting Issue:");
        resident.reportIssue("Broken streetlight at City Hall Road");

        System.out.println("  -> Tracking Status:");
        resident.trackStatus(101);

        System.out.println("  -> Viewing Updates:");
        resident.viewUpdates("Streetlight repair scheduled tomorrow");
        System.out.println();

        // LGU actions
        System.out.println("=== LGU ACTIONS ===");
        LGU lgu = new LGU("MatiSense", "Engineering Office");
        System.out.println("  -> Managing Reports:");
        lgu.manageReports();

        System.out.println("  -> Publishing Announcement:");
        lgu.publishAnnouncement("Water interruption on Sunday, 9AM-3PM");

        System.out.println("  -> Analyzing Data:");
        lgu.analyzeData();
        System.out.println();

        // News updates
        System.out.println("=== NEWS UPDATES ===");
        News news = new News("MatiSense", "Mayor inaugurates new Mati Sports Complex.");
        news.publishNews();
    }
}
