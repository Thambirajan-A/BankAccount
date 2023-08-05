package org.example;

import ch.qos.logback.core.net.server.Client;
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
         MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
         MongoDatabase database = mongoClient.getDatabase("bank");
         MongoCollection<org.bson.Document> bankCollection = database.getCollection("bankCollection");
        FindIterable<Document> cursor = bankCollection.find();
        cursor.forEach(System.out::println);
    }

    public static void insertToDB(List<BankAccount> i){
        connectMongo();

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
        Document doc = new Document();

        doc.put("name","To be deleted");
        doc.put("accountType","j.getAccountType()");
        doc.put("balance",0);
        bankCollection.insertOne(doc);
        FindIterable<Document> allDocs =  bankCollection.find();
        for(Document d: allDocs){
            acclist.add(new BankAccount((String)d.get("acctype"),(String)d.get("bankName"),(double)d.get("bankBalance")));
        }
        bankCollection.deleteOne(doc);

        closeMongo();
        return acclist;

    }
//    Document query = new Document();
//    query.put("name", "If You Dare");
//    query.put("artist-group","AC/DC");
//    FindIterable<Document> cursor = musicItems.find();
//    cursor.forEach(System.out::println);


}
