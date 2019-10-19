import java.security.SecureRandom;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        double answ;
        int mult1[] = new int[10];
        int mult2[] = new int[10];
        int difficulty = 0;
        int problemType = 0;
        int cont = 1;
        Scanner scnr  = new Scanner(System.in);
        SecureRandom  rand = new SecureRandom();
        double totalRight = 0.0;
        while(cont == 1)
        {
            difficulty = getDifficulty(scnr);

            problemType = getProblemType(scnr);

            for (int i = 0; i < 10; i++) {
                answ = generateQuestion(rand, mult1, mult2, i, difficulty, problemType);
                totalRight += checkAnswer(answ, scnr);
            }
            totalRight /= 10;
            if (totalRight > .75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
                totalRight = 0;
            } else {
                System.out.println("Please ask your teacher for extra help.");
                totalRight = 0;
            }
            System.out.println("Enter 1 if you would like to test another student, 0 if you wish to exit.");
            cont = scnr.nextInt();
        }
    }

    static int getDifficulty(Scanner scnr)
    {
        System.out.println("Please enter a difficulty from 1 to 4.");
        return (int)Math.pow(10, scnr.nextInt());
    }

    static int getProblemType(Scanner scnr)
    {
        System.out.println("Please enter a number for problem type, 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, and 5 for a mix of all.");
        return scnr.nextInt();
    }
    static double generateQuestion(SecureRandom rand, int[] arr1, int[] arr2, int location, int difficulty, int problemType)
    {

        int mult1 = rand.nextInt(difficulty);
        int mult2 = rand.nextInt(difficulty);
        while(checkIfAlreadyAsked(mult1, mult2, arr1, arr2, location))
        {
            mult1 = rand.nextInt(difficulty);
            mult2 = rand.nextInt(difficulty);
        }
        arr1[location] = mult1;
        arr2[location] = mult2;
        return getAnswer(mult1, mult2, problemType);
    }

    static double getAnswer(int mult1, int mult2, int problemType)
    {
        int problem = problemType;
        if(problem == 5)
        {
            SecureRandom rand = new SecureRandom();
            problem = rand.nextInt(4) + 1;
        }
        if(problem == 1)
        {
            System.out.println("How much is " + mult1 + " plus " + mult2 + "?");
            return mult1 + mult2;
        }
        else if(problem == 2)
        {
            System.out.println("How much is " + mult1 + " times " + mult2 + "?");
            return mult1 * mult2;
        }
        else if(problem == 3)
        {
            System.out.println("How much is " + mult1 + " minus " + mult2 + "?");
            return mult1 - mult2;
        }
        else if(problem == 4)
        {
            System.out.println("How much is " + mult1 + " divided by " + mult2 + "?");
            return (mult1* 1.0) / (mult2* 1.0);
        }
        throw new IllegalArgumentException("Improper problem type number " + problem);
    }

    public static boolean checkIfAlreadyAsked(int mul1, int mul2, int[] arr1, int[] arr2, int location)
    {
        for(int i = 0; i < location; i++)
        {
            if(mul1 == arr1[i])
                if(mul2 == arr2[i])
                    return true;
            if(mul2 == arr1[i])
                if(mul1 == arr2[i])
                    return true;
        }
        return false;
    }

    public static int checkAnswer(double answ, Scanner scnr)
    {
        Double response = scnr.nextDouble();
        if ((response - answ) >= .0001 || (answ - response) >= .0001)
        {
            getRandomWrongResponse();
            return 0;
        }
        getRandomRightResponse();
        return 1;
    }

    public static void getRandomWrongResponse()
    {
        SecureRandom rand = new SecureRandom();
        int n = rand.nextInt(4) + 1;
        switch(n)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void getRandomRightResponse()
    {
        SecureRandom rand = new SecureRandom();
        int n = rand.nextInt(4) + 1;
        switch(n)
        {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }
}


