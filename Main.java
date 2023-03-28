import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    private String name;
    private String serialNumber;
    private int value;

    public Inventory(String name, String serialNumber, int value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + "," + serialNumber + "," + value;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        int choice;

        do {
            System.out.println("Press 1 to add an item.");
            System.out.println("Press 2 to delete an item.");
            System.out.println("Press 3 to update an item.");
            System.out.println("Press 4 to show all the items.");
            System.out.println("Press 5 to quit the program.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.println("Enter the serial number:");
                    String serialNumber = scanner.nextLine();

                    System.out.println("Enter the value in dollars (whole number):");
                    int value = scanner.nextInt();

                    inventoryList.add(new Inventory(name, serialNumber, value));
                    break;

                case 2:
                    System.out.println("Enter the serial number of the item to delete:");
                    scanner.nextLine();
                    String deleteSerialNumber = scanner.nextLine();

                    for (Inventory inventory : inventoryList) {
                        if (inventory.getSerialNumber().equals(deleteSerialNumber)) {
                            inventoryList.remove(inventory);
                            break;
                        }
                    }

                    break;

                case 3:
                    System.out.println("Enter the serial number of the item to change:");
                    scanner.nextLine();
                    String changeSerialNumber = scanner.nextLine();

                    for (Inventory inventory : inventoryList) {
                        if (inventory.getSerialNumber().equals(changeSerialNumber)) {
                            System.out.println("Enter the new name:");
                            String newName = scanner.nextLine();

                            System.out.println("Enter the new Value in dollars (whole number):");
                            int newValue = scanner.nextInt();

                            inventory.setName(newName);
                            inventory.setValue(newValue);
                           
                            break;
                        }
                    }

                    break;

                case 4:
                    for (Inventory inventory : inventoryList) {
                        System.out.println(inventory.toString());
                    }

                    break;

                case 5:                    
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);
    }
}