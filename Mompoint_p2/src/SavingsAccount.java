public class SavingsAccount
{
        private static double annualInterestRate = 0;
        private double savingsBalance;
        public SavingsAccount(double Balance)
        {
            savingsBalance = Balance;
        }

        public void calculateMonthlyInterest()
        {
            savingsBalance += (annualInterestRate / 12.0) * savingsBalance;
        }

        public static void modifyInterestRate(double interestRate)
        {
            annualInterestRate = interestRate;
        }

        public double getBalance()
        {
            return savingsBalance;
        }
}
