package by.mk.hbaseapp.dataaccess;

import by.mk.hbaseapp.model.HbaseTable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HbaseDdlDao {
    List<String> ListTables() throws IOException;
    boolean tableExists(HbaseTable hbaseTable) throws IOException;
    void isTableEnable(HbaseTable hbaseTable) throws IOException;
    void isTableDisable(HbaseTable hbaseTable) throws IOException;

    void CreateTable(HbaseTable hbaseTable) throws IOException;
    void DeleteTable(HbaseTable hbaseTable) throws IOException;

    void DeleteColumn(HbaseTable hbaseTable) throws IOException;
    void AddColumn(HbaseTable hbaseTable) throws IOException;

    void ShutDownHbase() throws IOException;

}
