package by.mk.hbaseapp.dataaccess.impl;

import by.mk.hbaseapp.dataaccess.HbaseDmlDao;
import by.mk.hbaseapp.model.HbaseTable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HbaseDmlDaoImlp implements HbaseDmlDao {

//    private static HbaseTable hbaseTable;

//    protected HbaseDmlDaoImlp(HbaseTable hbaseTable){
//        this.hbaseTable = hbaseTable;
//    }

    Configuration conf = HBaseConfiguration.create();

    private final Logger LOGGER = LoggerFactory.getLogger(HbaseDmlDaoImlp.class);

    @Override
    public void InsertData(HbaseTable hbaseTable, byte[] rowId, byte[] value) throws IOException {
        try {
            // Instantiating HTable class
            HTable hTable = new HTable(conf, hbaseTable.getTableName());

            // Instantiating Put class
            // accepts a row name.
            Put p = new Put(rowId);

            // adding values using add() method
            // accepts column family name, qualifier/row name ,value
            p.add(Bytes.toBytes(hbaseTable.getFamilyName()), Bytes.toBytes(hbaseTable.getColumnName()), value);

            // Saving the put Instance to the HTable.
            hTable.put(p);

            // closing HTable
            hTable.close();

        } catch (Exception e) {
            LOGGER.error("Error insert data to {}",hbaseTable.getTableName(), e.getMessage());

        }


    }

    @Override
    public void DeleteData(HbaseTable hbaseTable, byte[] rowId) throws IOException {

    }

    @Override
    public void UpdateData(HbaseTable hbaseTable, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException {

    }

    @Override
    public void ScanTable(HbaseTable hbaseTable) throws IOException {

    }
}
