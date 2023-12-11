//This class will hol all out String outputs.
//If another class needs a text output, they can call a method from this class

public class Output {

    //Example method
    //The methods will be static so that other classes can call the methods
    // without the need to create a new instance in each class
    //Delete the example when we have added some real methods
    //Letting the test-method be here if someone needs to test the output somewhere during testing
    public static void test(){
        System.out.println("test");
    }

    public static void exceptionErrorInt() { System.out.println("Du behöver välja ett heltalsnummer \n");}
}
