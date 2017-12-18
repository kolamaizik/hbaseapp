package main.java.mk;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class EnableTable {
    public static void main(String args[]) throws MasterNotRunningException, IOException{
        String tblName = "people";

        // Instantiating configuration class
        Configuration conf = HBaseConfiguration.create();

        // Instantiating HBaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(conf);

        // Verifying weather the table is disabled
        Boolean bool = admin.isTableEnabled(tblName);
        System.out.println(bool);

        // Disabling the table using HBaseAdmin object
        if(!bool){
            admin.enableTable(tblName);
            System.out.println("Table Enabled");
        }
    }
}
