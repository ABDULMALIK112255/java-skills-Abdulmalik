
public class PayrollCalculator {

    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid input values.");
            return 0;
        }

        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked > 40) {
                    return (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                }
                return hoursWorked * hourlyRate;

            case "PART_TIME":
                return Math.min(hoursWorked, 25) * hourlyRate;

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                return Math.min(hoursWorked, 20) * (hourlyRate * 0.8);

            default:
                System.out.println("Unknown employee type: " + employeeType);
                return 0;
        }
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;
        if (grossPay <= 500) tax = grossPay * 0.10;
        else if (grossPay <= 1000) tax = grossPay * 0.15;
        else if (grossPay <= 2000) tax = grossPay * 0.20;
        else tax = grossPay * 0.25;

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        if (employeeTypes.length != hours.length || hours.length != rates.length || rates.length != names.length) {
            System.out.println("Error: Mismatched array lengths.");
            return;
        }

        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String highestPaid = "";
        String lowestPaid = "";
        double totalPay = 0;
        int overtimeCount = 0;

        System.out.printf("%-10s %-12s %-8s %-10s %-10s\n", "Name", "Type", "Hours", "GrossPay", "Tax");

        for (int i = 0; i < names.length; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true);
            double net = gross - tax;

            System.out.printf("%-10s %-12s %-8.1f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], gross, tax);

            if (gross > maxPay) {
                maxPay = gross;
                highestPaid = names[i];
            }

            if (gross < minPay) {
                minPay = gross;
                lowestPaid = names[i];
            }

            if (hours[i] > 40) overtimeCount++;

            totalPay += gross;
        }

        System.out.println("\nSummary:");
        System.out.println("Highest Paid: " + highestPaid + " ($" + maxPay + ")");
        System.out.println("Lowest Paid: " + lowestPaid + " ($" + minPay + ")");
        System.out.println("Average Pay: $" + (totalPay / names.length));
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Test calculation functions
        System.out.println("Alice pay: $" + calculateWeeklyPay("FULL_TIME", 45, 25));
        System.out.println("Alice tax: $" + calculateTaxDeduction(1200, true));
        System.out.println();

        // Process all employees
        processPayroll(types, hours, rates, names);
    }
}
