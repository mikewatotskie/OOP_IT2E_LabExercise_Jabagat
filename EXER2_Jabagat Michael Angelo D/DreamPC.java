public class DreamPC {

    private String cpu;
    private String gpu;
    private String ram;
    private String storage;
    private String caseColor;
    private String motherboard;
    private String fans;
    private String monitor;

    // Default constructor
    public DreamPC() {
        this.cpu = "No CPU";
        this.gpu = "No GPU";
        this.ram = "No RAM";
        this.storage = "No Storage";
        this.caseColor = "No Case Color";
        this.motherboard = "No Motherboard";
        this.fans = "No Fans";
        this.monitor = "No Monitor";
    }

    // Parameterized constructor
    public DreamPC(String cpu, String gpu, String ram, String storage, String caseColor, String motherboard, String fans, String monitor) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.caseColor = caseColor;
        this.motherboard = motherboard;
        this.fans = fans;
        this.monitor = monitor;
    }

    // Method to display PC information
    public void DisplayInfo() {
        String info = "";
        info += "CPU: " + this.cpu;
        info += "\nGPU: " + this.gpu;
        info += "\nRAM: " + this.ram;
        info += "\nStorage: " + this.storage;
        info += "\nCase Color: " + this.caseColor;
        info += "\nMotherboard: " + this.motherboard;
        info += "\nFans: " + this.fans;
        info += "\nMonitor: " + this.monitor;
        System.out.println(info);
    }
}
