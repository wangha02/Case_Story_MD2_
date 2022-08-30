package view.ViewAll;

import com.sun.org.apache.regexp.internal.RE;
import config.Config;
import controller.UserController;
import dto.request.SignInDTO;
import dto.request.SignUpDTO;
import dto.response.ResponseMessenger;
import model.User;
import view.ViewAll.ViewHome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static color.ConsoleColors.*;

public class ViewMainMenu {
    UserController userController = new UserController();
    List<User> userList = userController.getUserList();

    public void menu() {
        System.out.println(PURPLE + "╔══════════════════════════╗");
        System.out.println         ("║           MENU           ║");
        System.out.println         ("╠═══════╦══════════════════╣");
        System.out.println         ("║   1   ║  Show user list  ║");
        System.out.println         ("╠═══════╬══════════════════╣");
        System.out.println         ("║   2   ║  Register        ║");
        System.out.println         ("╠═══════╬══════════════════╣");
        System.out.println         ("║   3   ║  Login           ║");
        System.out.println         ("╚═══════╩══════════════════╝" + RESET);

        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                formShowListUser();
                break;
            case 2:
                formRegister();
                break;
            case 3:
                formLogin();
                break;
            default:
                System.out.println(RED + "Invalid choice" + RESET);
        }
        menu();
    }

    private void formLogin() {
        //username
        String username;
        while (true) {
            System.out.println(BLUE + "╔═══════════════════╗");
            System.out.println(       "║  Enter username:  ║");
            System.out.println(       "╚═══════════════════╝"+ RESET);
            username = Config.scanner().nextLine();
            System.out.println();
            if (username.matches("[a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println(RED +"Invalid username, try again!"+ RESET);
            }
        }
        //password
        String password;
        while (true) {
            System.out.println(BLUE + "╔═══════════════════╗");
            System.out.println(       "║  Enter password:  ║");
            System.out.println(       "╚═══════════════════╝"+ RESET);
            password = Config.scanner().nextLine();
            if (password.matches("[a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println(RED +"Invalid password, try again!"+ RESET);
            }
        }
        SignInDTO signInDTO = new SignInDTO(username, password);
        ResponseMessenger responseMessenger = userController.login(signInDTO);
        switch (responseMessenger.getMessage()) {
            case "blocked":
                System.err.println(BLUE+"This user is blocked"+ RESET);
                break;
            case "login_success":
                System.out.println(BLUE+ "Login successful!" + RESET);
                new ViewHome();
                break;
            case "login_failure":
                System.out.println(RED + "Username or password is incorrect!"+ RESET);
        }
    }
    private void formRegister() {
        System.out.println("╔══════════════╗");
        System.out.println("║   REGISTER   ║");
        System.out.println("╚══════════════╝");
        //id
        int id = userController.getLastId();
        //name
        String name;
        while (true) {
            System.out.println("Enter name:");
            name = Config.scanner().nextLine();
            if (name.matches("[A-Z][a-zA-Z0-9 ]{1,10}")) {
                break;
            } else {
                System.out.println(RED +"Invalid name, try again!"+ RESET);
            }
        }
        //username
        String username;
        while (true) {
            System.out.println("Enter username:");
            username = Config.scanner().nextLine();
            if (username.matches("[a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println(RED + "Invalid username, try again!"+ RESET);
            }
        }
        //email
        String email;
        while (true) {
            System.out.println("Enter email:");
            email = Config.scanner().nextLine();
            if (email.matches(".+@.+")) {
                break;
            } else {
                System.out.println(RED + "Invalid email, try again!" + RESET);
            }
        }
        //password
        String password;
        while (true) {
            System.out.println("Enter password:");
            password = Config.scanner().nextLine();
            if (password.matches("[a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println(RED + "Invalid password, try again!" + RESET);
            }
        }
        //role
        String role = "user";
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(id, name, username, email, password, strRole);
        ResponseMessenger responseMessenger = userController.register(signUpDTO);
        switch (responseMessenger.getMessage()) {
            case "user_existed":
                System.out.println(RED +"Username already exists"+ RESET);
                break;
            case "email_existed":
                System.out.println(RED +"Email already exists"+ RESET);
                break;
            case "invalid_role":
                System.out.println(RED + "Invalid role, try again!" + RESET);
                break;
            case "success":
                System.out.println(BLUE + "Register success" + RESET);
        }

    }
    private void formShowListUser() {
        System.out.printf("%-15s %s %n", "Username", "Role");
        for (User user : userList) {
            System.out.printf("%-15s %s %n", user.getUsername(), new ArrayList<>(user.getRoles()).get(0).getRoleName());
        }
    }

}
