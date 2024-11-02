package application;

import entities.BankAccount;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        double amount = 0;
        boolean escolha = true;

        System.out.print("Digite o número da conta: ");
        int number = sc.nextInt();

        System.out.print("Digite o nome do titular: ");
        String name = scan.nextLine();

        System.out.print("Digite o montante inicial: ");
        double balance = sc.nextDouble();

        BankAccount bankAccount = new BankAccount(number, name, balance);

        System.out.println();

        System.out.println(bankAccount);

        while(escolha){
            System.out.println();

            System.out.println("1 - Saque\n2 - Depósito\n3 - Listar transações\n4 - sair\n");
            int num = sc.nextInt();

            switch (num){

                case 1:
                    System.out.print("Digite o valor a ser sacado: ");
                    amount = sc.nextDouble();

                    bankAccount.withdraw(amount);
                    break;

                case 2:
                    System.out.printf("Digite o valor a ser depositado: ");
                    amount = sc.nextDouble();

                    bankAccount.deposit(name, amount);
                    break;

                case 3:
                    bankAccount.transactions();
                    break;

                case 4:
                    escolha = false;
                    break;


                default:
                    System.out.printf("Opção inválida.");
            }
        }

        System.out.printf("Saldo: R$ " + bankAccount.getBalance());

        System.out.println(bankAccount);


        System.out.printf("Saldo: R$ " + bankAccount.getBalance());

        sc.close();
        scan.close();
    }
}