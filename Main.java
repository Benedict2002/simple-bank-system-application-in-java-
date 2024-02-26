package BankingApplication;

public class Main {
    public static void main(String[] args) {
        Bank bank= new Bank("KCB");
        bank.addBranch("Kasarani");

        bank.addCustomer("Kasarani","Ben",300.40);
        bank.addCustomer("Kasarani","Brayo",60.40);
        bank.addCustomer("Kasarani","Job",30.40);

        bank.addBranch("Bungoma");
        bank.addCustomer("Bungoma","Ken",400.30);

        bank.addCustomerTransaction("Bungoma","Ken",600.50);
        bank.addCustomerTransaction("Bungoma","Ken",230.50);
        bank.addCustomerTransaction("Kasarani","Job",670.50);
        bank.listCustomers("Kasarani",false);
        System.out.println("*********************************************************");
        bank.listCustomers("Bungoma",false);
        System.out.println("********************************************************");

        bank.listCustomers("Kasarani",true);
        System.out.println("*********************************************************");
        bank.listCustomers("Bungoma",true);

    }
}