package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.MongoDB.*;

public class Main {
    //private static boolean loopcloser = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> acclist = new ArrayList<BankAccount>();
        //acclist=fetchFromDB(acclist);

        //System.out.println("Hello world!");
        while(true){
            System.out.println("Choose an option: (a)Add Account (l)Display Accounts (s)Save to database (q)Quit");
            String option = sc.nextLine();
            switch(option){
                case "a":{
                    System.out.println("Enter type of account:");

                    String acctype = sc.nextLine();

                    System.out.println("Enter account holder name:");
                    String bankName = sc.nextLine();

                    System.out.println("Enter account balance:");
                    int bankBalance = Integer.parseInt(sc.nextLine());
                    acclist.add(new BankAccount(acctype,bankName,bankBalance));
                    break;
                }
                case "l":{
                    for (BankAccount i: acclist){
                        System.out.printf("Type of Account: %s; Account holder name: %s; Account balance: %s\n",i.getAccountType(),i.getAccn(),i.getBalance());
                }
                    break;
            }
                case "s":{
                    insertToDB(acclist);
                    //connectMongo();
                }
            }


            if (option.equals("q")){
                //loopcloser=false;
                break;
            }

            }



//            if (acctype=="Savings Account"){
//                SavingsAccount acc1= new SavingsAccount(bankName,bankBalance);
//            }
//            else {
//                BankAccount acc1= new BankAccount(bankName,bankBalance);
//            }
//            System.out.printf("Type of Account: %s; Account holder name: %s; Account balance: %s\n",acctype,bankName,bankBalance);
        }

    /*private static void saveToDatabase(List<BankAccount> bankAccount) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Bank");
        collection = database.getCollection("bankData");
        for (BankAccount b : bankAccount ){

            Document insertDoc = new Document();
            insertDoc.put("accountName",b.getAccountName());
            insertDoc.put("balance",b.getBalance());
            insertDoc.put("accountType",b.getAccountType());

            collection.insertOne(insertDoc);

            System.out.println("Account details got inserted into DB");
        }


    }*/
}
