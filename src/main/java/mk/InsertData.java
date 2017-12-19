package main.java.mk;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData {
    public static void main(String[] args) throws IOException {

        String tblName = "people";

        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();

        // Instantiating HTable class
        HTable hTable = new HTable(config, tblName);

        // Instantiating Put class
        // accepts a row name.
        Put p = new Put(Bytes.toBytes("row1"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        p.add(Bytes.toBytes("name"), Bytes.toBytes("first"), Bytes.toBytes("Raju"));
        p.add(Bytes.toBytes("name"), Bytes.toBytes("last"), Bytes.toBytes("Kui"));
        p.add(Bytes.toBytes("contactinfo"), Bytes.toBytes("email"), Bytes.toBytes("manager@gmail.com"));

        // Saving the put Instance to the HTable.
        hTable.put(p);
        System.out.println("data inserted");

        // closing HTable
        hTable.close();
    }
}