import java.util.Scanner;

public class HospitalApplication {
    private static String answer = "";
    private static Doctor john = new Doctor("Doctor John", 121, 90000, "Heart");
    private static Nurse jane = new Nurse("Nurse Jane", 122, 50000, 10);
    private static Receptionist sally = new Receptionist("Receptionist Sally", 111, 45000, false);
    private static Janitor chris = new Janitor("Janitor Chris", 132, 40000, false);
    private static Patient jeff = new Patient("Jeff", 100, 50);
    private static Patient andre = new Patient("Andre", 70, 60);

    public static void main(String[] args) {

        printWelcomeStatement();

        printEmployeeStatus();

        System.out.println("Choose which employee you would like to be");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        caseStatementGame(scanner, userChoice);
    }











    private static void caseStatementGame(Scanner scanner, String userChoice) {
        int count = 0;
        while (count < 1) {

            switch (userChoice.toLowerCase()) {
                case "doctor":
                case "nurse":
                    System.out.println("Please choose which patient you would like to see today.");
                    System.out.println("\n");
                    printPatientList();
                    answer = scanner.nextLine();
                    john.drawBlood(jeff);
                    john.careForPatient(jeff);
                    if (answer.toLowerCase().equals("jeff")) {
                        System.out.println("You have treated the patient and he is back to health!");
                        System.out.println("Blood level is now at " + jeff.getBloodLevel());
                        System.out.println("Health level is now at " + jeff.getHealthLevel());
                        System.out.println("\n");
                        printEmployeePaidStatus();
                        printClosingRemarks();
                        break;
                    } else if(answer.toLowerCase().equals("andre")){
                        System.out.println("You have treated the patient and he is back to health!");
                        System.out.println("Blood level is now at " + andre.getBloodLevel());
                        System.out.println("Health level is now at " + andre.getHealthLevel());
                        System.out.println("\n");
                        printEmployeePaidStatus();
                        printClosingRemarks();

                    } else {
                        System.out.println("You have killed your patient. You will now go to jail.");
                        System.exit(0);
                    }
                    break;

                case "receptionist":
                    System.out.println("Answer the phone? Yes or No");
                    answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("yes")) {
                        // System.out.println("Please help the customer!");
                        Receptionist sally = new Receptionist("Sally", 121, 45000, true);
                        System.out.println("You have been paid for doing your job!");
                        sally.receivePay();
                        System.out.println(sally);
                        System.out.println("\n");
                        printPatientStatus();
                        printClosingRemarks();
                    } else {
                        System.out.println("You have been fired for not doing your job!");
                    }
                    System.exit(0);
                    break;
                case "janitor":
                    System.out.println("Sweep or sleep?");
                    answer = scanner.nextLine();

                    if (answer.toLowerCase().equals("sweep")) {
                        System.out.println("Sweep");
                        System.out.println("You have been paid for doing your job!");
                        Janitor chris = new Janitor("chris", 132, 40000, true);
                        chris.receivePay();
                        System.out.println(chris);
                        System.out.println("\n");
                        printPatientStatus();
                        printClosingRemarks();

                    } else {
                        System.out.println("You have been fired for not doing your job!");
                    }
                    System.exit(0);
                    userChoice = scanner.nextLine();
                    break;
                default:
                    System.out.println("You've been fired or you won the lotto and quit your job!");
            }
            count++;
        }
    }

    private static void printPatientList() {
        Patient jeff = new Patient("Jeff", 100, 50);
        Patient andre = new Patient("Andre", 70, 30);
        System.out.println(jeff);
        System.out.println(andre);

    }
    private static void printPatientStatus() {
        System.out.println("In a different department, the patients have been treated by the doctor and nurse.");
        john.careForPatient(jeff);
        jane.careForPatient(andre);
        System.out.println("Jeff's health level is currently at " + jeff.getHealthLevel() + ". ");
        System.out.println("The patient Andre's health level is now at " + andre.getHealthLevel() + ".");
        System.out.println("\n");
    }

    private static void printWelcomeStatement() {
        System.out.println("Welcome to High Street Hospital! Where patient care comes first!" + "\n"
                + "Here is a list of all of our employees!");

        System.out.println("\n");
    }

    private static void printEmployeeStatus() {
        System.out.println(john);
        System.out.println(jane);
        sally.getIsOnThePhone();
        System.out.println(sally);
        chris.getIsSweeping();
        System.out.println(chris);
        System.out.println("\n");


    }
    private static void printEmployeePaidStatus() {
        john.receivePay();
        System.out.println(john);
        jane.receivePay();
        System.out.println(jane);
        sally.receivePay();
        sally.noLongerOnThePhone();
        System.out.println(sally);
        chris.isNoLongerSweeping();
        chris.receivePay();
        System.out.println(chris);
        System.out.println("\n");
    }

    private static void printClosingRemarks() {
        System.out.println("We are glad you had a great and short stay at High Street Hospital! \n" +
                "If you have have any family or friends who are not feeling welcome, do not hesitate to send them our way. \n" +
                "With our wonderful staff, We will take GREAT care of them. High Street Hospital, where patient comes first! ");
    }
}
