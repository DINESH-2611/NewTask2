package Signuporlogin;

import AdminUser.AdminUserView;
import datalayer.TrainBookingDatabse;

import java.util.Scanner;

public class SignUpOrLoginView {
    Scanner scanner = new Scanner(System.in);
    private SignUporLoginModel signUporLoginModel;

    public SignUpOrLoginView() {
        signUporLoginModel = new SignUporLoginModel(this);
    }

    public void init() {
        while (true) {
            System.out.println("Welcome to " + TrainBookingDatabse.getInstance().getAppName() + "!!!");
            System.out.println("1.SignUp\n2.Login\n3.Exit\nEnter the choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    newUser();
                    break;
                case "2":
                    getLogindetails();
                    break;
                case "3":
                    showAlert("Thank You for using " + TrainBookingDatabse.getInstance().getAppName() + "App!!!");
                    break;
                default:
                    showAlert("Invalid choice,Enter valid choice");
                    break;
            }
            if (choice.equals("3"))
                return;
        }

    }

    private void getLogindetails() {
        System.out.println("Enter user name");
        String userName = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        signUporLoginModel.validUser(userName, password);
    }

    private void newUser() {
        System.out.println("Enter user name(Alpha numeric format)");
        String userName = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        signUporLoginModel.isUserExist(userName, password);
    }

    void showAlert(String alert) {
        System.out.println(alert);
    }

//    public void alreadyUser() {
//        showAlert("UserName already exist");
//        checkAgainForAdd();
//    }

    void checkAgainForAdd() {
        System.out.println("Do you want to continue\nYes\nNo");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            newUser();
        } else if (choice.equalsIgnoreCase("No")) {
            return;
        } else {
            showAlert("Invalid choice,Enter valid choice");
            checkAgainForAdd();
        }
    }

    public void onAdminLoginuccess() {
        showAlert("Admin Login successfull");
        new AdminUserView().adminPage();
    }

    public void onUserLoginSuccess(String userName) {
        new AdminUserView().userPage(userName);
    }

    public void onLoginfailed() {
        System.out.println("Do you want to continue\nYes\nNo");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            getLogindetails();
        } else if (choice.equalsIgnoreCase("No")) {
            return;
        } else {
            showAlert("Invalid choice,Enter valid choice");
            onLoginfailed();
        }
    }
}
