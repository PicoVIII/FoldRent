package com.foldrent;

import java.util.List;
import java.util.Scanner;

import com.foldrent.models.Tenants;
import com.foldrent.services.AuthService;
import com.foldrent.services.TenantService;
import com.foldrent.services.PaymentService;
import com.foldrent.services.LandlordService;
import com.foldrent.services.RegistrationService;

public class Main {
    private static AuthService authService;
    private static TenantService tenantService;
    private static PaymentService paymentService;
    private static LandlordService landlordService;
    private static RegistrationService registrationService;
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
        landlordService = new LandlordService();
        authService = new AuthService();
        paymentService = new PaymentService(tenantService);
        registrationService = new RegistrationService(authService, tenantService, landlordService);
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
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Select Role:");
        System.out.println("1. Landlord");
        System.out.println("2. Tenant");
        System.out.print("Choose (1-2): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        if (roleChoice == 1) {
            // GET LANDLORD DETAILS
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Middle Initial: ");
            char midInitial = scanner.nextLine().charAt(0);
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            // CALL REGISTRATION SERVICE
            boolean success = registrationService.registerLandlord(username, password, firstName, lastName, midInitial,
                    email,
                    phone);
            System.out.println(success ? "Landlord registered!" : "Registration failed!");

        } else if (roleChoice == 2) {
            // GET TENANT DETAILS
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Middle Initial: ");
            char middleInitial = scanner.nextLine().charAt(0);
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            // CALL REGISTRATION SERVICE
            boolean success = registrationService.registerTenant(username, password, firstName, lastName, middleInitial, email, phone);
            System.out.println(success ? "Tenant registered!" : "Registration failed!");
        }
    }
}