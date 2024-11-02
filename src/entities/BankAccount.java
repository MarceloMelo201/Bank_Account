package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private int number;
    private String name;
    private double balance;
    private List<Double> transactions = new ArrayList<>();
    private List<Date> transactionsDates = new ArrayList<>();
    private List<String> transactionsNames = new ArrayList<>();



    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public BankAccount(){}

    public BankAccount(int number, String cardholderName, double balance) {
        this.number = number;
        this.name = cardholderName;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

   public void deposit(String cardholderName, double amount){

        if(cardholderName.equals(this.name)){
            this.balance += amount;
            Date now = new Date();
            transactionsDates.add(now);
            transactionsNames.add("Depósito");
        }
        else {
            System.out.println("Nome de titular não encontrado. Operação cancelada");
        }

   }

   public void withdraw(double amount){
        if(balance - amount >= 0){
            balance -= amount;
            transactions.add(amount);

            Date now = new Date();

            transactionsDates.add(now);
            transactionsNames.add("Saque");
        }
        else {
            System.out.println("Operação cancelada. O montante não pode ser maior que o saldo em conta!");
        }
   }

   public void transactions() throws ParseException {

       System.out.println(" === Transação, Valor, Data ===");
        for(int i = 0; i < transactions.size(); i++){
            System.out.println(transactionsNames.get(i) + ": R$ " + transactions.get(i) + ", " + transactionsDates);

        }
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(", ");
        sb.append(name);
        sb.append(", R$ ");
        sb.append(balance);

        return sb.toString();
    }


}
