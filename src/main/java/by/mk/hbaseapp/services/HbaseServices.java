package by.mk.hbaseapp.services;

import java.io.IOException;
import java.util.List;

public interface HbaseServices {
    List<String> ListTables() throws IOException;
    boolean tableExists(String tableName) throws IOException;

//    void isTableEnable(String tableName) throws IOException;
//    void isTableDisable(String tableName) throws IOException;

//    void CreateTable(String tableName) throws IOException;
//    void CreateTable(String tableName, String familyName) throws IOException;
//    void CreateTable(String tableName, List<String> familiesName) throws IOException;
//    void CreateTable(String tableName, Map.Entry listFamiliesColumns) throws IOException;

//    void DeleteTable(String tableName) throws IOException;
//
//    void DeleteColumn(String tableName, String familyName, String columnName) throws IOException;
//    void AddColumn(String tableName, String familyName, String columnName) throws IOException;
//    void ShutDownHbase() throws IOException;

    // DML commands
    void InsertData(String tableName, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException;
    void DeleteData(String tableName, byte[] rowId) throws IOException;
    void UpdateData(String tableName, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException;
    void ScanTable(String tableName, String familyName, String columnName) throws IOException;

}
