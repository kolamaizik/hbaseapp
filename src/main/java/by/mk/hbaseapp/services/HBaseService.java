package by.mk.hbaseapp.services;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.mk.hbaseapp.model.ColumnFamilyValue;
import by.mk.hbaseapp.model.ColumnValue;
import by.mk.hbaseapp.model.RowValue;
import by.mk.hbaseapp.model.TableDescription;


public class HBaseService {
    private String tableName = "people";

    ConversionsService conversionsService;

    private final Logger log = LoggerFactory.getLogger(HBaseService.class);

    public List<TableDescription> listTables() {
        List<TableDescription> result = null;

//        try (Connection connection = hBaseConnectionFactory.connect();
//             Admin admin = connection.getAdmin()) {
        try{
            Configuration config = HBaseConfiguration.create();

            HBaseAdmin admin = new HBaseAdmin(config);
            HTableDescriptor[] tables = admin.listTables();

            Stream<HTableDescriptor> tableDescriptorsStream = Arrays.stream(tables);

            result = tableDescriptorsStream.map(conversionsService::constructTableDescription)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error while talking to HBase.", e);
        }

        return result;
    }


    public void putRow(String name, RowValue row) throws IOException {
        try {
            Configuration config = HBaseConfiguration.create();
            HTable hTable = new HTable(config, tableName);

            Put p = new Put(Bytes.toBytes(row.getRowKey()));
            for (ColumnFamilyValue family : row.getColumnFamilies() ) {
                for (ColumnValue column : family.getColumnValues()) {
                    p.addColumn(Bytes.toBytes(family.getFamilyName()), Bytes.toBytes(column.getColumn()),Bytes.toBytes(column.getValue()));
                }
            }
            hTable.put(p);

            log.info("Data inserted: {}", tableName);
        }catch (Exception e){
            log.error("Error", e.getMessage());
        }
    }
}
