public class Car {

    private String color;
    private String plateNo;
    private String chassisNo;
    private String Model;
    private String Brand;

    public Car() {
        this.color = "No Color";
        this.plateNo = "No Plate Number";
        this.chassisNo = "No Chassis Number";
        this.Model = "No Model";
        this.Brand = "No Brand";
    }

    public Car(String color, String plateNo, String chassisNo, String model, String brand) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.Model = model;
        this.Brand = brand;
    }

    public void DisplayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "\nPlateNumber: " + this.plateNo;
        info += "\nChassisNumber: " + this.chassisNo;
        info += "\nModel: " + this.Model;
        info += "\nBrand: " + this.Brand;

        System.out.println(info);
    }
}
