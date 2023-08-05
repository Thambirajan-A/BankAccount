//package org.example;
//
//public class BankApp {
//}

/*package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection ;
    public static void main(String[] args){
        List<BankAccount> bankAccount = new ArrayList<BankAccount>();
        initialisationToDatabase(bankAccount);
        System.out.println("a)Add account    l)Display all accounts    s)Save to database   d)Deposit   q)Quit");
        System.out.println("Enter the option: ");
        Scanner in = new Scanner(System.in);
        String choice = in.next();

        while(!choice.equals("q")) {

            if (choice.equals("a")) {
                System.out.println("Do you want to open a saving account(Y/N): " );
                String IsSavings = in.next();
                String accountType;
                if(IsSavings.equals("Y") || IsSavings.equals("y")) {
                    accountType = "Savings";
                }
                else{
                    accountType = "Others";
                }
                System.out.println("Enter the Account Name: ");
                String name = in.next();
                System.out.println("Enter the initial amount");
                Double initialAmount = in.nextDouble();
                bankAccount.add(new BankAccount(accountType,name, initialAmount));
                //saveToDatabase(bankAccount);

            } else if (choice.equals("l")) {
                System.out.println();
                for (BankAccount b : bankAccount) {
                    System.out.println("AccountName: "+b.getAccn() +"\tAccountBalance: "+ b.getBalance()+"\tAccountType: "+b.getAccountType());
                }

            } else if (choice.equals("s")) {
                saveToDatabase(bankAccount);

            }
            else if (choice.equals("d")){
                String accountName;
                for (BankAccount b : bankAccount) {
                    System.out.println("AccountName: "+b.getAccn() +"\tAccountType: "+b.getAccountType());
                }
                System.out.println("Enter a account to deposit: ");
                accountName = in.next();


                System.out.println("Enter the amount to deposit: ");
                Double amount = in.nextDouble();
                //  BankAccount.deposit(amount);
            }

            System.out.println("a)Add account    l)Display all accounts    s)Save to database   d)Deposit    q)Quit");
            System.out.println("Enter the option: ");
            choice = in.next();
        }

    }

    private static void initialisationToDatabase(List<BankAccount> bankAccount) {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Bank");
        collection = database.getCollection("bankData");
        Iterable<Document> allDoc = collection.find();
        for (Document d : allDoc ){
            String name = (String) d.get("accountName");
            Double initialAmount = (double) d.get("balance");
            String accountType = (String) d.get("accountType");
            bankAccount.add(new BankAccount(accountType,name, initialAmount));
            //System.out.println("Account details got inserted into DB");
        }
    }

    private static void saveToDatabase(List<BankAccount> bankAccount) {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Bank");
        collection = database.getCollection("bankData");
        for (BankAccount b : bankAccount ){

            Document insertDoc = new Document();
            insertDoc.put("accountName",b.getAccn());
            insertDoc.put("balance",b.getBalance());
            insertDoc.put("accountType",b.getAccountType());

            collection.insertOne(insertDoc);

            System.out.println("Account details got inserted into DB");
        }


    }
}
*/