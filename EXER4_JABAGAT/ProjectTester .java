public class ProjectTester {
    public static void main(String[] args) {

        // Polymorphic array 
        MatiSense[] users = {
            new Resident("MatiSense", "Banaybanay Alingalan Jabagat Lopez"),
            new LGU("MatiSense", "Engineering Office"),
            new News("MatiSense", "Mayor inaugurates New Sports Complex")
        };
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 POLYMORPHISM DEMO                ");
        System.out.println("==================================================\n");

        System.out.println(">>> Runtime Polymorphism\n");
        for (MatiSense user : users) {
            user.showInfo(); // Polymorphic call
        }

        System.out.println("\n--------------------------------------------------\n");

        System.out.println(">>> Compile-time Polymorphism\n");

        // Resident test
        System.out.println("=============== Resident Actions ===============");
        Resident r = new Resident("MatiSense", "Maria Santos");
        r.reportIssue("Broken traffic light");
        r.reportIssue("Flooded street", "Barangay Central");
        System.out.println();

        // LGU test
        System.out.println("================= LGU Actions =================");
        LGU l = new LGU("MatiSense", "Disaster Risk Management");
        l.announce("Storm warning: classes suspended");
        l.announce("Heavy rainfall expected", "URGENT");
        System.out.println();

        // News test
        System.out.println("================ News Updates =================");
        News n = new News("MatiSense", "Free vaccination on Saturday!");
        n.publishNews();
        n.publishNews("Health");

        System.out.println("\n==================================================");
        System.out.println("             END OF POLYMORPHISM DEMO             ");
        System.out.println("==================================================");
    }
}
