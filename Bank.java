package BankingApplication;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches= new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    public  boolean addCustomer(String branchName, String customerName,double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch!= null){
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomertransaction(customerName,initialAmount);
        }
        return false;
    }
    private  Branch findBranch(String branchName){
        for (int i= 0; i< this.branches.size(); i++){
            Branch checkedBranch= this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }
    public boolean listCustomers(String branchName, boolean showtransaction){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customers details for branch "+branch.getName());
            ArrayList<Customer> banchCustomers = branch.getCustomers();
            for (int i=0; i < banchCustomers.size();i++){
                Customer branchCustomer = banchCustomers.get(i);
                System.out.println("Customer: "+branchCustomer.getName()+"["+(i+1)+"]");
                if(showtransaction){
                    System.out.println("Transactions");
                    ArrayList<Double> transaction = branchCustomer.getTransaction();
                    for (int j=0; j<transaction.size();j++) {
                        System.out.println("[" + (j + 1)+"] Amount "+transaction.get(j));
                    }
                }
            }
            return true;

        }else {
            return false;
        }

    }

}
