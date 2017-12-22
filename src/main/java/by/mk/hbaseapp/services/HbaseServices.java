package by.mk.hbaseapp.services;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HbaseServices {

    Configuration conf = HBaseConfiguration.create();

    private final Logger log = LoggerFactory.getLogger(HBaseService.class);


    public List<String> ListTables() throws IOException {
        List<String> listTables = null;

        try (HBaseAdmin admin = new HBaseAdmin(conf)) {
            HTableDescriptor[] tableDescriptor = admin.listTables();

            for (int i = 0; i < tableDescriptor.length; i++) {
                listTables.add(tableDescriptor[i].getNameAsString());
            }

            log.info("List tables returned");
        }

        return listTables;
    }

    public boolean tableExists(String tableName) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);

        boolean bool = admin.tableExists(tableName);
        return bool;
    }

    public void isTableEnable(String tableName) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);

        boolean bool = admin.isTableEnabled(tableName);

        if (!bool) {
            admin.enableTable(tableName);

            log.info("Table {} is enable", tableName);
        }
    }

    public void isTableDisable(String tableName) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);

        boolean bool = admin.isTableDisabled(tableName);

        if (!bool) {
            admin.disableTable(tableName);

            log.info("Table {} is disable", tableName);
        }
    }

}
