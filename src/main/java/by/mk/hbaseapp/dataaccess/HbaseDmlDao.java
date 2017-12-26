package by.mk.hbaseapp.dataaccess;

import by.mk.hbaseapp.model.HbaseTable;

import java.io.IOException;

public interface HbaseDmlDao {

    // DML commands
    void InsertData(HbaseTable hbaseTable, byte[] rowId, byte[] value) throws IOException;
    void DeleteData(HbaseTable hbaseTable, byte[] rowId) throws IOException;
    void UpdateData(HbaseTable hbaseTable, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException;
    void ScanTable(HbaseTable hbaseTable) throws IOException;
//    void ScanTable(HbaseTable hbaseTable, String familyName, String columnName) throws IOException;

}
