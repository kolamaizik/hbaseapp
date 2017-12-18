package main.java.mk;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class AddColumn {
    public static void main(String args[]) throws MasterNotRunningException, IOException{
        String tableName = "people";
        String columnName = "contactDetails";

        // Instantiating configuration class.
        Configuration conf = HBaseConfiguration.create();

        // Instantiating HBaseAdmin class.
        HBaseAdmin admin = new HBaseAdmin(conf);

        // Instantiating columnDescriptor class
        HColumnDescriptor columnDescriptor = new HColumnDescriptor(columnName);

        // Adding column family
        admin.addColumn(tableName, columnDescriptor);
        System.out.println("column added");
    }
}