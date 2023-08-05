package org.example;

import ch.qos.logback.core.net.server.Client;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;


//import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private static MongoCollection<Document> bankCollection;
//    private Client MongoClient mongoClient;
    //
    public static void connectMongo(){
         mongoClient = MongoClients.create("mongodb://localhost:27017");
         database = mongoClient.getDatabase("bank");
         bankCollection = database.getCollection("bankCollection");
        FindIterable<Document> cursor = bankCollection.find();
        cursor.forEach(System.out::println);
    }

//    public static void finalInsertToDB(List<BankAccount> i) {
//        connectMongo();
//        bankCollection.drop();
//        for (BankAccount j: i){
//        Document doc = new Document();
//
//        doc.put("name",j.getAccn());
//        doc.put("accountType",j.getAccountType());
//        doc.put("balance",j.getBalance());
//
//        bankCollection.insertOne(doc);
//    }
//        closeMongo();
//    }
    public static void insertToDB(List<BankAccount> i) {
        connectMongo();
        bankCollection.drop();

        for (BankAccount j: i){
            Document doc = new Document();

            doc.put("name",j.getAccn());
            doc.put("accountType",j.getAccountType());
            doc.put("balance",j.getBalance());

            bankCollection.insertOne(doc);
        }
        closeMongo();
    }

    public static void closeMongo(){
        mongoClient.close();
    }
    public static List<BankAccount> fetchFromDB(List<BankAccount> accList){
        connectMongo();
        List<BankAccount> acclist = new ArrayList<BankAccount>();
//        Document doc = new Document();
//
//        doc.put("name","To be deleted");
//        doc.put("accountType","j.getAccountType()");
//        doc.put("balance",0);
//        bankCollection.insertOne(doc);
        FindIterable<Document> allDocs =  bankCollection.find();
        for(Document d: allDocs){
            acclist.add(new BankAccount((String)d.get("accountType"),(String)d.get("name"),(double)d.get("balance")));
        }
        //bankCollection.deleteOne(doc);

        closeMongo();
        return acclist;

    }
    public static void depositAccount(String bankName, int depAmount){
        connectMongo();
        Document query = new Document();
        query.put("name",bankName);
        Document updateDocument = new Document();
        double newBalance =0;
        FindIterable<Document> allDocs =  bankCollection.find(query);
        for(Document d: allDocs){
            newBalance= depAmount+(double)d.get("balance");
            newBalance = newBalance;
        }
        updateDocument.put("balance",newBalance);
        Document updateObject = new Document();
        updateObject.put("$set", updateDocument);
        System.out.println(newBalance);
        bankCollection.updateOne(query,updateObject);
        closeMongo();
        //acclist=fetchFromDB(acclist);
        /*for (BankAccount i: acclist) {
            System.out.printf("Type of Account: %s; Account holder name: %s; Account balance: %s\n", i.getAccountType(), i.getAccn(), i.getBalance());
        }*/
        //System.out.println(acclist);
        //return acclist;

    }
    public static void withdrawAccount(String bankName, int withAmount){
        connectMongo();
        Document query = new Document();
        query.put("name",bankName);
        Document updateDocument = new Document();
        double newBalance =0;
        FindIterable<Document> allDocs =  bankCollection.find(query);
        for(Document d: allDocs){
            newBalance= (double)d.get("balance")-withAmount;
            newBalance = newBalance;
        }
        updateDocument.put("balance",newBalance);
        Document updateObject = new Document();
        updateObject.put("$set", updateDocument);
        System.out.println(newBalance);
        bankCollection.updateOne(query,updateObject);
        closeMongo();
    }
//    Document query = new Document();
//    query.put("name", "If You Dare");
//    query.put("artist-group","AC/DC");
//    FindIterable<Document> cursor = musicItems.find();
//    cursor.forEach(System.out::println);


}
