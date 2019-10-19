public class Application {
    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(.04);
        for(int i = 0; i < 12; i++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.println("Saver1 balance: " + saver1.getBalance());
        System.out.println("Saver2 balance: " + saver2.getBalance());
        SavingsAccount.modifyInterestRate(.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver1 balance: " + saver1.getBalance());
        System.out.println("Saver2 balance: " + saver2.getBalance());
    }
}
