package main.java.mk;

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class TableExists {
    public static void main(String args[])throws IOException{
        String tableName = "people";

        // Instantiating configuration class
        Configuration conf = HBaseConfiguration.create();

        // Instantiating HBaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(conf);

        // Verifying the existance of the table
        boolean bool = admin.tableExists(tableName);
        System.out.println(bool);
    }
}
