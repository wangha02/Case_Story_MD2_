package view.ViewAll;

import config.Config;
import controller.StoryController;
import controller.StoryControllerSearchName;
import controller.UserController;
import dto.response.ResponseMessenger;
import model.RoleName;
import model.Story;
import model.User;
import view.ViewStory.*;

import java.util.ArrayList;
import java.util.List;
import static color.ConsoleColors.*;  // Màu
public class ViewHome {
    UserController userController = new UserController();
    User currentUser = userController.getCurrentUser();
    RoleName roleName = new ArrayList<>(currentUser.getRoles()).get(0).getRoleName();
    StoryControllerSearchName searchName = new StoryControllerSearchName();
    List<Story> storyList = searchName.showSearchName();
    StoryController storyController = new StoryController();

    StoryControllerSearchName storyControllerSearchName = new StoryControllerSearchName();



    public ViewHome() {
        switch (roleName) {
            case ADMIN:
                menuAdmin();
                break;
            case USER:
                menuUser();
                break;
            case PM:
                menuPm();
                break;
        }
    }

    private void menuPm() {
        System.out.println(PURPLE + "╔══════════════════════════════╗");
        System.out.println         ("║             MENU             ║");
        System.out.println         ("╠═══════╦══════════════════════╣");
        System.out.println         ("║   1   ║    Show list user    ║");
        System.out.println         ("╠═══════╬══════════════════════╣");
        System.out.println         ("║   2   ║    Delete user       ║");
        System.out.println         ("╠═══════╬══════════════════════╣");
        System.out.println         ("║   3   ║    Block user        ║");
        System.out.println         ("╠═══════╬══════════════════════╣");
        System.out.println         ("║   4   ║    List Menu         ║");
        System.out.println         ("╠═══════╬══════════════════════╣");
        System.out.println         ("║   5   ║    Back              ║");
        System.out.println         ("╚═══════╩══════════════════════╝" + RESET);
        int choice = Config.getValidInteger();
        if (choice == 0) return;
        switch (choice) {
            case 1:
                formShowListUser();
                break;
            case 2:
                formDeleteUser();
                break;
            case 3:
                formBlockUser();
                break;
            case 4:
                formListMenu();
                break;
            case 5:
                userController.logout();
                new ViewMainMenu().menu();
                return;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
        menuPm();
    }


    public void menuUser() {
        System.out.println("Hello USER: " + currentUser.getName());
        System.out.println(PURPLE  + "╔═══════════════════════════════╗");
        System.out.println          ("║       Hello USER: " + currentUser.getName()+ "        ║");
        System.out.println          ("╠═══════╦═══════════════════════╣");
        System.out.println          ("║   1   ║    Change password    ║");
        System.out.println          ("╠═══════╬═══════════════════════╣");
        System.out.println          ("║   2   ║    Page Menu          ║");
        System.out.println          ("╠═══════╬═══════════════════════╣");
        System.out.println          ("║   3   ║    Log out            ║");
        System.out.println          ("╚═══════╩═══════════════════════╝" + RESET);
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                formChangePassword();
                break;
            case 2:
                bigMenu();
                break;
            case 3:
                userController.logout();
                new ViewMainMenu().menu();
                break;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
        menuUser();
    }

    public void bigMenu() {

        System.out.println          ("╔═══════╦═══════════════════════════════╗");
        System.out.println          ("║   1   ║    Show All Story             ║");
        System.out.println          ("╠═══════╬═══════════════════════════════╣");
        System.out.println          ("║   2   ║    Search Story               ║");
        System.out.println          ("╠═══════╬═══════════════════════════════╣");
        System.out.println          ("║   3   ║    Show Series Story         ║");
        System.out.println          ("╠═══════╬═══════════════════════════════╣");
        System.out.println          ("║   4   ║    Show Single Story          ║");
        System.out.println          ("╚═══════╩═══════════════════════════════╝" + RESET);
//        System.out.println("5. Show Top 10 Story View");
//        System.out.println("6. Show Top 10 Story Vote 5* ");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                formShowListAllStory();
                break;
            case 2:
                formSearchStory();
                break;
            case 3:
                formSeriesStory();
                break;
            case 4:
                formSingleStory();
                break;
//            case 6:
//                formTop10StoryView();
//                break;
//
//            case 7:
//                formTop10Vote();
//                break;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }

    }

    private void formShowListAllStory() {
        System.out.println(PURPLE  + "╔════════════════════╗");
        System.out.println          ("║   All Story List   ║");
        System.out.println          ("╚════════════════════╝" + RESET);
        System.out.println("All Story List");
        for (Story story : storyList) {
            System.out.println(story.getName());
        }
    }

    public void formSearchStory() {
        System.out.println(PURPLE  + "╔═══════╦═════════════════════════╗");
        System.out.println          ("║   1   ║   Enter Category Name   ║");
        System.out.println          ("╠═══════╬═════════════════════════╣");
        System.out.println          ("║   2   ║   Enter Story Name      ║");
        System.out.println          ("╚═══════╩═════════════════════════╝" + RESET);
        int choc = Integer.parseInt(Config.scanner().nextLine());
        switch (choc) {
            case 1:
                formList();
                break;
            case 2:
                new ViewSearchName().nameSearchStory();
                break;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
    }

    public void formSeriesStory() {
        System.out.println("All Series List Story ");
        System.out.println("Enter 1 to display Single story");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        if (choice == 1) {
            new ViewSeriesStory().SeriesStory();
        } else {
            System.out.println(RED + "Invalid choice" + RESET);
        }
    }

    public void formSingleStory() {
        System.out.println("All Story List");
        System.out.println("Enter 1 to display Single story");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        if (choice == 1) {
            new ViewSinger().SingerStory();
        } else {
            System.out.println(RED + "Invalid choice" + RESET);
        }
    }


    public void formList() {

        System.out.println(PURPLE  + "╔═══════╦══════════════════════════╗");
        System.out.println          ("║   1   ║    Truyện Dân Gian       ║");
        System.out.println          ("╠═══════╬══════════════════════════╣");
        System.out.println          ("║   2   ║    Truyện Trinh Thám     ║");
        System.out.println          ("╠═══════╬══════════════════════════╣");
        System.out.println          ("║   3   ║    Truyện Ngụ Ngôn       ║");
        System.out.println          ("╚═══════╩══════════════════════════╝" + RESET);

        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                new ViewDanGian().formSearchStory();
                break;
            case 2:
                new ViewTrinhTham().formSearchStory2();
                break;
            case 3:
                new ViewNguNgon().formSearchStory3();
                break;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
        bigMenu();
    }

    //ADMIN
    public void menuAdmin() {

        System.out.println(PURPLE  + "╔══════════════════════════════════╗");
        System.out.println          ("║          Hello ADMIN: " + currentUser.getName()+ "      ║");
        System.out.println          ("╠═══════╦══════════════════════════╣");
        System.out.println          ("║   1   ║    User Manage           ║");
        System.out.println          ("╠═══════╬══════════════════════════╣");
        System.out.println          ("║   2   ║    Change Password       ║");
        System.out.println          ("╠═══════╬══════════════════════════╣");
        System.out.println          ("║   3   ║    List Menu             ║");
        System.out.println          ("╠═══════╬══════════════════════════╣");
        System.out.println          ("║   4   ║    Log out               ║");
        System.out.println          ("╚═══════╩══════════════════════════╝" + RESET);
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                formUserManage();
                break;
            case 2:
                formChangePassword();
                break;
            case 3:
                formListMenu();
                break;
            case 4:
                userController.logout();
                new ViewMainMenu().menu();
                return;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
        menuAdmin();
    }

    //LIST MENU
    public void formListMenu() {
        System.out.println(PURPLE +"╔═══════╦═══════════════════════════════╗");
        System.out.println        ("║   1   ║  Show List Series Story       ║");
        System.out.println        ("╠═══════╬═══════════════════════════════╣");
        System.out.println        ("║   2   ║  Create Series Story          ║");
        System.out.println        ("╠═══════╬═══════════════════════════════╣");
        System.out.println        ("║   3   ║  Update Series Story          ║");
        System.out.println        ("╠═══════╬═══════════════════════════════╣");
        System.out.println        ("║   4   ║  Delete Series Story          ║");
        System.out.println        ("╠═══════╬═══════════════════════════════╣");
        System.out.println        ("║   5   ║  Detail Series Story          ║");
        System.out.println        ("╠═══════╬═══════════════════════════════╣");
        System.out.println        ("║   6   ║  Back Menu                    ║");
        System.out.println        ("╚═══════╩═══════════════════════════════╝" + RESET);
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                showListSeries();
                break;
            case 2:
                editStory();
                break;
            case 3:
                updateStory();
                break;
            case 4:
                deleteStory();
                break;
            case 5:
                detailStory();
                break;
            case 6:
                menuAdmin();
                break;
            default:
                System.out.println(RED +"Invalid choice" + RESET);
        }
    }


    public void showListSeries() {
        List<Story> storyList = storyControllerSearchName.showSearchName();
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println(       "║  STT               NAME              ║");
        System.out.println(       "╚══════════════════════════════════════╝"+ RESET);
//        System.out.println(RED +"|STT|       NAME          " );
        for (Story story : storyList) {
            System.out.println(WHITE + "| " + story.getId() + " |" + "     " + story.getName() + RESET);
        }
    }

    public void editStory() {
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println       ("║         Enter stt want fix ?         ║");
        System.out.println       ("╚══════════════════════════════════════╝"+ RESET);
        int update = Integer.parseInt(Config.scanner().nextLine());
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println       ("║        Enter story want fix ?        ║");
        System.out.println       ("╚══════════════════════════════════════╝"+ RESET);
        String name = Config.scanner().nextLine();
        List<Story> storyEditList = storyControllerSearchName.editStory(update, name);
        for (Story story : storyEditList) {
            System.out.println(WHITE +
                    "| " + story.getId() + "      " + story.getName() + RESET);

        }
    }


    public void updateStory() {
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println       ("║       Enter stt want to add ?        ║");
        System.out.println       ("╚══════════════════════════════════════╝"+ RESET);
        int update = Integer.parseInt(Config.scanner().nextLine());
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println       ("║       Enter story wan to add ?       ║");
        System.out.println       ("╚══════════════════════════════════════╝"+ RESET);
        String name = Config.scanner().nextLine();
        List<Story> updateStoryList = storyControllerSearchName.editStory(update, name);
        for (Story story : updateStoryList) {
            System.out.println(
                    "| " + story.getId() + "      " + story.getName());
        }
    }


    public void deleteStory() {
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println       ("║         Enter Id to delete ?         ║");
        System.out.println       ("╚══════════════════════════════════════╝"+ RESET);
        int id = Integer.parseInt(Config.scanner().nextLine());
        if (!isValid(id)) {
            System.out.println(RED + "out side id !" + RESET);
            return;
        }
        System.out.println("Chosse Yes or No (Y / N ) ?");
        String check = Config.scanner().nextLine();
        if (check.equalsIgnoreCase("Y")) {
            storyControllerSearchName.deleteStory(id);
        } else if (check.equalsIgnoreCase("N")) {
            System.out.println(RED +"No Delete !"+ RESET);
        } else {
            System.out.println("Option no fit ");
        }
        System.out.println(GREEN + "successfully deleted !" + RESET);
        List<Story> storyDelete = storyControllerSearchName.showSearchName();
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println(       "║  STT               NAME              ║");
        System.out.println(       "╚══════════════════════════════════════╝"+ RESET);
        for (int i = 1; i < storyDelete.size(); i++) {
            System.out.println(
                    "| " + storyDelete.get(i).getId() + "      " + storyDelete.get(i).getName());
        }
    }

    public void detailStory() {
        System.out.println(BLUE + "╔══════════════════════════════════════╗");
        System.out.println(       "║    Enter Id Story want to find ?     ║");
        System.out.println(       "╚══════════════════════════════════════╝"+ RESET);
        int id = Integer.parseInt(Config.scanner().nextLine());
        List<Story> storiesUpdateList = storyControllerSearchName.findStoriesById(id);
        System.out.println(storiesUpdateList);
        for (Story story : storiesUpdateList) {
            System.out.println("| " + story.getId() + " |" + story.getName() + " |");
        }
    }

    private boolean isValid(int id) {
        int size = storyController.getStory().size();
        return id >= 0 && id < size;
    }

    private void formChangePassword() {
        String oldPassword;
        while (true) {
            System.out.println(GREEN_BOLD + "╔════════════════════════════╗");
            System.out.println             ("║  Enter your old password:  ║");
            System.out.println             ("╚════════════════════════════╝" + RESET);
            oldPassword = Config.scanner().nextLine();
            if (oldPassword.matches("[a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println(RED + "Invalid password, try again!"+ RESET);
            }
        }
        System.out.println(GREEN_BOLD + "╔════════════════════════════╗");
        System.out.println             ("║  Enter your new password:  ║");
        System.out.println             ("╚════════════════════════════╝"+ RESET);
        String newPassword = Config.scanner().nextLine();

        System.out.println(GREEN_BOLD + "╔════════════════════════════╗");
        System.out.println             ("║  Repeat the new password:  ║");
        System.out.println             ("╚════════════════════════════╝"+ RESET);
        String newPassword2 = Config.scanner().nextLine();

        if (!newPassword.equals(newPassword2)) {
            System.out.println(RED + "Repeat password incorrect" + RESET);
        } else {
            ResponseMessenger messenger = userController.changePassword(oldPassword, newPassword);
            switch (messenger.getMessage()) {
                case "not_match":
                    System.out.println(RED + "Old password does not matches!"+ RESET);
                    break;
                case "success":
                    System.out.println(BLUE + "Change password successfully!" + RESET);
                    userController.logout();
                    new ViewMainMenu().menu();
            }
        }
    }

    private void formUserManage() {
        System.out.println(PURPLE + "╔═══════════════════════════════════════╗");
        System.out.println         ("║                  MENU                 ║");
        System.out.println         ("╠═══════╦═══════════════════════════════╣");
        System.out.println         ("║   1   ║  Show list user               ║");
        System.out.println         ("╠═══════╬═══════════════════════════════╣");
        System.out.println         ("║   2   ║  Delete user                  ║");
        System.out.println         ("╠═══════╬═══════════════════════════════╣");
        System.out.println         ("║   3   ║  Change role                  ║");
        System.out.println         ("╠═══════╬═══════════════════════════════╣");
        System.out.println         ("║   4   ║  Block user                   ║");
        System.out.println         ("╠═══════╬═══════════════════════════════╣");
        System.out.println         ("║   5   ║  Back                         ║");
        System.out.println         ("╚═══════╩═══════════════════════════════╝" + RESET);


        int choice = Config.getValidInteger();
        if (choice == 0) return;
        switch (choice) {
            case 1:
                formShowListUser();
                break;
            case 2:
                formDeleteUser();
                break;
            case 3:
                formChangeRole();
                break;
            case 4:
                formBlockUser();
                break;
            case 5:
                return;
            default:
                System.out.println(RED + "Invalid choice" + RESET);
        }
        formUserManage();
    }

    private void formBlockUser() {
        formShowListUser();
        System.out.println(BLUE + "╔══════════════════════════╗");
        System.out.println(       "║  Enter id user to block  ║");
        System.out.println(       "╚══════════════════════════╝"+ RESET);
        int id = Config.getValidInteger();
        ResponseMessenger messenger = userController.blockUser(id);
        switch (messenger.getMessage()) {
            case "not_found":
                System.err.println("►ID not found◄");
                break;
            case "blocked":
                System.out.println("You just blocked user id " + id);
                break;
            case "unblocked":
                System.out.println("You just unblocked user id " + id);
        }
    }

    private void formChangeRole() {
        formShowListUser();
        System.out.println(BLUE + "╔═══════════════════════════════════╗");
        System.out.println(       "║  Enter id of user to change role  ║");
        System.out.println(       "╚═══════════════════════════════════╝"+ RESET);
        int id = Config.getValidInteger();
        System.out.println(BLUE + "╔════════════════════════════════════╗");
        System.out.println(       "║  Enter role to change (pm / user)  ║");
        System.out.println(       "╚════════════════════════════════════╝"+ RESET);
        String roleName = Config.scanner().nextLine();
        ResponseMessenger messenger = userController.changeRole(id, roleName);
        switch (messenger.getMessage()) {
            case "success":
                System.out.println(BLUE + "Change role successfully!" + RESET);
                break;
            case "invalid_role":
                System.err.println(RED + "Invalid role!" + RESET);
                break;
            case "not_found":
                System.out.println(RED +"►ID not found◄" + RESET);
        }
    }

    private void formDeleteUser() {
        formShowListUser();
        System.out.println("Enter id of user to delete");
        int id = Config.getValidInteger();
        ResponseMessenger messenger = userController.deleteUser(id);
        switch (messenger.getMessage()) {
            case "success":
                System.out.println(BLUE + "Delete user successfully" + RESET);
                break;
            case "not_found":
                System.out.println(RED +"►ID not found◄" + RESET);
        }
    }

    private void formShowListUser() {
        List<User> users = userController.getUserList();
        System.out.println(users);
        System.out.printf("%3s      %-12s %-7s %s\n", "ID", "USERNAME", "ROLE", "STATUS");
        for (User user : users) {
            System.out.printf(RED + "%3s      %-12s %-7s %s\n", user.getId(), user.getUsername(), user.getRoleName(), (user.isStatus() ? "BLOCKED" : "NOT BLOCKED") + RESET);
        }
    }
}
