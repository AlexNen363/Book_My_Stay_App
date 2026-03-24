// Add-on services (UC7)
AddOnServiceManager manager = new AddOnServiceManager();

// Example reservation IDs (from UC6 output)
String res1 = "SI-1";
String res2 = "DO-2";

// Add services
manager.addService(res1, new Service("Breakfast", 200));
        manager.addService(res1, new Service("WiFi", 100));
        manager.addService(res2, new Service("Airport Pickup", 500));

// Display services
        manager.displayServices(res1);

// Total cost
double total = manager.calculateTotalCost(res1);
System.out.println("Total Add-on Cost for " + res1 + ": Rs." + total);