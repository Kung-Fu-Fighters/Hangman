//If a class needs to have a scanner, then the class can make an instance of this class and call it's methods


import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public int chooseInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException x) {
            Output.exceptionErrorInt();
        } return -1;
    }

    public String chooseString(){
        return sc.nextLine();
    }
}
