package by.mk.hbaseapp.dataaccess.impl;

import by.mk.hbaseapp.dataaccess.HbaseDdlDao;
import by.mk.hbaseapp.model.HbaseTable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HbaseDdlDaoIpml implements HbaseDdlDao {

    private static HbaseTable hbaseTable;

    protected HbaseDdlDaoIpml(HbaseTable hbaseTable){
        this.hbaseTable = hbaseTable;
    }

    Configuration conf = HBaseConfiguration.create();

    private final Logger LOGGER = LoggerFactory.getLogger(HbaseDdlDaoIpml.class);


    @Override
    public List<String> ListTables() throws IOException {
        List<String> listTables = null;

        try (HBaseAdmin admin = new HBaseAdmin(conf)) {
            HTableDescriptor[] tableDescriptor = admin.listTables();

            for (int i = 0; i < tableDescriptor.length; i++) {
                listTables.add(tableDescriptor[i].getNameAsString());
            }

            LOGGER.info("List tables returned");
        }

        return listTables;
    }

    @Override
    public boolean tableExists(HbaseTable hbaseTable) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
        boolean bool = false;

        try {
            bool = admin.tableExists(hbaseTable.getTableName());

            LOGGER.info("Table {} exists", hbaseTable.getTableName());

        }catch (Exception e){
            LOGGER.info("Error: tableExists", e.getMessage());
        }

        return bool;
    }

    @Override
    public void isTableEnable(HbaseTable hbaseTable) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);

        try {
            boolean bool = admin.isTableEnabled(hbaseTable.getTableName());

            if (!bool) {
                admin.enableTable(hbaseTable.getTableName());

                LOGGER.info("Table {} is enable", hbaseTable.getTableName());
            }
        }catch (Exception e){
            LOGGER.error("Is Table Enable", e.getMessage());
        }
    }

    @Override
    public void isTableDisable(HbaseTable hbaseTable) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);

        try{
            boolean bool = admin.isTableDisabled(hbaseTable.getTableName());

            if (!bool) {
                admin.disableTable(hbaseTable.getTableName());

                LOGGER.info("Table {} is disable", hbaseTable);
            }
        }catch (Exception e){
            LOGGER.error("Is Table Disable", e.getMessage());
        }
    }

    @Override
    public void CreateTable(HbaseTable hbaseTable) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
        try{
            // create the table...
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(hbaseTable.getTableName()));

            admin.createTable(tableDescriptor);

            LOGGER.info("Table {} created", hbaseTable.getTableName());
        }catch (Exception e){
            LOGGER.error("Error table create {}", hbaseTable.getTableName(), hbaseTable);
        }
    }

    @Override
    public void DeleteTable(HbaseTable hbaseTable) throws IOException {
        try{
            // Create an admin object using the config
            HBaseAdmin admin = new HBaseAdmin(conf);

            // Disable, and then delete the table
            admin.disableTable(hbaseTable.getTableName());
            admin.deleteTable(hbaseTable.getTableName());

            LOGGER.info("Deleted table {}", hbaseTable.getTableName());
        }catch (Exception e){
            LOGGER.error("Error {} table delete", hbaseTable.getTableName());

        }
    }

    @Override
    public void DeleteFamily(HbaseTable hbaseTable) throws IOException {
        try {
            // create an admin object using the config
            HBaseAdmin admin = new HBaseAdmin(conf);
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(hbaseTable.getTableName()));

            tableDescriptor.removeFamily(hbaseTable.getFamilyName().getBytes());

            LOGGER.info("{} family removed to {}", hbaseTable.getFamilyName(), hbaseTable.getTableName());
        }catch (Exception e){
            LOGGER.error("Error removed {} family to {}", hbaseTable.getFamilyName(), hbaseTable.getTableName());
        }

    }

    @Override
    public void AddFamily(HbaseTable hbaseTable) throws IOException {
        try {
            // create an admin object using the config
            HBaseAdmin admin = new HBaseAdmin(conf);
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(hbaseTable.getTableName()));

            tableDescriptor.addFamily(new HColumnDescriptor(hbaseTable.getFamilyName()));

            LOGGER.info("{} family added to {}", hbaseTable.getFamilyName(), hbaseTable.getTableName());
        }catch (Exception e){
            LOGGER.error("Error add {} family to {}", hbaseTable.getFamilyName(), hbaseTable.getTableName());
        }

    }

    @Override
    public void DeleteColumn(HbaseTable hbaseTable) throws IOException {
        // Instantiating HTable class
        HTable table = new HTable(conf, hbaseTable.getTableName());

        // Instantiating Delete class
//        Delete delete = new Delete(Bytes.toBytes("row1"));
//        delete.deleteColumn(Bytes.toBytes(hbaseTable.getFamilyName()), Bytes.toBytes(hbaseTable.getColumnName()));

    }

    @Override
    public void AddColumn(HbaseTable hbaseTable) throws IOException {
        try{
            // Instantiating HBaseAdmin class.
            HBaseAdmin admin = new HBaseAdmin(conf);

            // Instantiating columnDescriptor class
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(hbaseTable.getTableName());

            // Adding column family
            admin.addColumn(hbaseTable.getTableName(), columnDescriptor);

            LOGGER.info("column added {}", hbaseTable);
        }catch (Exception e){
            LOGGER.error("Error: AddColumn", e.getMessage());
        }

    }

    @Override
    public void ShutDownHbase() throws IOException {
        // Instantiating HBaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(conf);

        try {
            // Shutting down HBase
            LOGGER.info("Shutting down hbase");

            admin.shutdown();
        } catch (IOException e) {
            LOGGER.error("Error: Shutting down hbase", e.getMessage());
        }
    }

}
