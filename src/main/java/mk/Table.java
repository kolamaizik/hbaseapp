package main.java.mk;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Table {
    private Configuration config;
    private HTable hTable;

    private String tableName;
    private String columnFamilyName;
    private String columnName;

    Table() throws IOException {
        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        // Instantiating HTable class
        HTable hTable = new HTable(this.config, this.tableName);

        this.config = config;
        this.hTable = hTable;
    }

    protected void finalize () throws IOException {
        // closing the HTable object
        this.hTable.close();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnFamilyName() {
        return columnFamilyName;
    }

    public void setColumnFamilyName(String columnFamilyName) {
        this.columnFamilyName = columnFamilyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

//    public void insertRecord(byte[] rowId, byte[] value) throws IOException {
      public void insertRecord(String rowId, String value) throws IOException {
        Put p = new Put(Bytes.toBytes(rowId));
        p.add(Bytes.toBytes(this.columnFamilyName), Bytes.toBytes(this.columnName), Bytes.toBytes(value));

        try {
            this.hTable.put(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("data inserted");

        // closing HTable
//        hTable.close();
    }

    public void deleteRecordById(String rowId, HBaseConstants.TypeObject type) throws IOException {
        // Instantiating Delete class
        Delete delete = new Delete(Bytes.toBytes(rowId));

        switch (type){
            case FAMILY:
                delete.deleteFamily(Bytes.toBytes(this.columnFamilyName));
            case COLUMN:
                delete.deleteColumn(Bytes.toBytes(this.columnFamilyName), Bytes.toBytes(this.columnName));
            default:
                System.out.println("======== Switch default!!! =========");
            }
//        delete.deleteColumn(Bytes.toBytes("name"), Bytes.toBytes("first"));
//        delete.deleteFamily(Bytes.toBytes("name"));

        // deleting the data
        this.hTable.delete(delete);

        // closing the HTable object
//        this.hTable.close();
    }

}