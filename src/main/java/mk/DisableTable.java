package main.java.mk;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DisableTable {
    public static void main(String args[]) throws MasterNotRunningException, IOException{
        String tblName = "people";

//    public String getTblName() {
//        return tblName;
//    }
//
//    public void setTblName(String tblName) {
//        this.tblName = tblName;
//    }

    // Instantiating configuration class
        Configuration conf = HBaseConfiguration.create();

        // Instantiating HBaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(conf);

        // Verifying weather the table is disabled
        Boolean bool = admin.isTableDisabled(tblName);
        System.out.println(bool);

        // Disabling the table using HBaseAdmin object
        if(!bool){
            admin.disableTable(tblName);
            System.out.println("Table disabled");
        }
    }
}