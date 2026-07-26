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
            System.out.println("enter your choice");
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
                        System.out.println("Login Successfully  " + username);
                        loggedIn=true;
                    } else
                    {
                        System.out.println("Invalid user name or password");
                    }
                    break;
                case 2:
                    System.out.println("choose user name");
                    String newUname = sc.nextLine();
                    System.out.println("choose password");
                    String newPassword = sc.nextLine();
                    if (UserDAO.signUp(newUname, newPassword)) {
                        System.out.println("login successfully" + newUname);
                    }
                    break;
                case 3:
                    System.out.println("Good boy");
                    return;
            }
        }
            int choice;
            do {
                System.out.println("===============STUDENT MANAGEMENT SYSTEM=============");
                System.out.println("1.ADD STUDENT");
                System.out.println("2.VIEW ALL STUDENTS");
                System.out.println("3.UPDATE");
                System.out.println("4.DELETE");
                System.out.println("5.EXIT");
                System.out.println("ENTER YOUR CHOICE : ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Name");
                        String name = sc.nextLine();
                        System.out.print("Roll number");
                        String rollNo = sc.nextLine();
                        System.out.print("department");
                        String dept = sc.nextLine();
                        System.out.print("Marks");
                        int marks = sc.nextInt();
                        dao.addStudent(name, rollNo, dept, marks);
                        break;
                    case 2:
                        dao.viewAllStudents();
                        break;
                    case 3:
                        System.out.println("Enter roll number");
                        String Roll = sc.nextLine();
                        System.out.println("Enter new marks");
                        int Marks = sc.nextInt();
                        dao.updateMarks(Roll, Marks);
                        break;
                    case 4:
                        System.out.println("Enter roll number");
                        String roll_no = sc.nextLine();
                        dao.deleteStudent(roll_no);
                        break;
                    default:
                        System.out.println("invalid choice");

                }
            }

            while (choice != 5);
        }
    }