package com.foldrent;

import java.util.List;
import java.util.Scanner;

import com.foldrent.models.Tenants;
import com.foldrent.services.AuthService;
import com.foldrent.services.TenantService;
import com.foldrent.services.PaymentService;

public class Main {
    private static AuthService authService;
    private static TenantService tenantService;
    private static PaymentService paymentService;
    private static Scanner scanner;

    public static void main(String[] args) {
        initializeServices();
        scanner = new Scanner(System.in);

        System.out.println("=== FOLD RENT CONSOLE ===");

        while (true) {
            showMainMenu();
        }
    }

    private static void initializeServices() {
        tenantService = new TenantService();
        authService = new AuthService();
        paymentService = new PaymentService(tenantService);
        System.out.println("Services initialized!");
    }

    private static void login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authService.loginUser(username, password)) {
            System.out.println("Login successful!");
            showRoleMenu();
        } else {
            System.out.println("Login failed!");
        }
    }

    private static void showRoleMenu() {
        // Will show landlord or tenant menu based on user role
        System.out.println("Role menu coming soon...");
        authService.logout(); // Temporary
    }

    private static void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private static void register() {
        System.out.println("\n=== REGISTER ===");

        // Get credentials first
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Role selection
        System.out.println("Select Role:");
        System.out.println("1. Landlord");
        System.out.println("2. Tenant");
        System.out.print("Choose (1-2): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String role;
        int tenantId = 0;

        if (roleChoice == 1) {
            role = "LANDLORD";
            // Register landlord user
            if (authService.registerUser(username, password, role, tenantId)) {
                System.out.println("Landlord account created!");
            }

        } else if (roleChoice == 2) {
            role = "TENANT";

            // Get tenant personal information
            System.out.println("\n=== TENANT INFORMATION ===");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Monthly Rent: ");
            double rentAmount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            // Create tenant record first
            if (tenantService.addTenant(firstName, lastName, rentAmount)) {
                // Get the auto-generated tenant ID
                List<Tenants> allTenants = tenantService.getActiveTenants();
                Tenants newTenant = allTenants.get(allTenants.size() - 1); // Get the last added tenant
                tenantId = newTenant.getTenantID();

                // Register user account linked to tenant
                if (authService.registerUser(username, password, role, tenantId)) {
                    System.out.println("Tenant account created successfully!");
                    System.out.println("Your Tenant ID: " + tenantId);
                }
            }

        } else {
            System.out.println("Invalid choice!");
        }
    }
}