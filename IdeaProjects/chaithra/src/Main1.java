import java.util.Scanner;
public class Main1 {
    public static void main(String[] args)
    {
        UserDAO userDAO = new UserDAO();
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        //LOGIN/SIGN UP PAGE
        while (!loggedIn)
        {
            System.out.println("=========WELCOME TO STUDENT MANAGEMENT SYSTEM========");
            System.out.println("1.LOGIN");
            System.out.println("2.SIGNUP");
            System.out.println("3.EXIT");
            System.out.println("Enter your Choice : ");
            int authChoice = sc.nextInt();
            sc.nextLine();
            switch (authChoice)
            {
                case 1:
                    System.out.println("UserName");
                    String username = sc.nextLine();
                    System.out.println("password");
                    String password = sc.nextLine();
                    if (UserDAO.logIn(username, password))
                    {
                        System.out.println("Login Successfully  " + username+"!");
                        loggedIn=true;
                    } else
                    {
                        System.out.println("Invalid User name or Password");
                    }
                    break;
                case 2:
                    System.out.println("Choose UserName");
                    String newUname = sc.nextLine();
                    System.out.println("Choose Password");
                    String newPassword = sc.nextLine();
                    if (UserDAO.signUp(newUname, newPassword)) {
                        System.out.println("Login successfully " + newUname +"!");
                    }
                    break;
                case 3:
                    System.out.println("Good Bye");
                    return;
            }
        }
            int choice;
            do {
                System.out.println("===================STUDENT MANAGEMENT SYSTEM=============================");
                System.out.println("1.ADD STUDENT");
                System.out.println("2.VIEW ALL STUDENTS");
                System.out.println("3.UPDATE");
                System.out.println("4.DELETE");
                System.out.println("5.SEARCH STUDENT BY ROLL NO");
                System.out.println("6.VIEW REPORTS");
                System.out.println("7.LOGOUT");
                System.out.println("ENTER YOUR CHOICE : ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Name : ");
                        String name = sc.nextLine();
                        System.out.print("RollNo : ");
                        String rollNo = sc.nextLine();
                        System.out.print("Department : ");
                        String dept = sc.nextLine();
                        System.out.print("Marks : ");
                        int marks = sc.nextInt();
                        dao.addStudent(name, rollNo, dept, marks);
                        break;
                    case 2:
                        dao.viewAllStudents();
                        break;
                    case 3:
                        System.out.println("Enter RollNo");
                        String Roll = sc.nextLine();
                        System.out.println("Enter New Marks");
                        int Marks = sc.nextInt();
                        dao.updateMarks(Roll, Marks);
                        break;
                    case 4:
                        System.out.println("Enter RollNo");
                        String roll_no = sc.nextLine();
                        dao.deleteStudent(roll_no);
                        break;
                        case 5:
                            System.out.println("Enter RollNo to Search");
                            String Roll_No=sc.nextLine();
                            dao.searchStudents(Roll_No);
                            break;
                    case 6:
                        System.out.println("=========================================Student Report===============================================");
                        dao.averageMarks();
                        dao.highestScore();
                        break;
                    case 7:
                        System.out.println("Logged out successfully");
                        break;
                    default:
                        System.out.println("invalid Choice");

                }
            }

            while (choice != 7);
        }
    }