package by.mk.hbaseapp.services.impl;

import by.mk.hbaseapp.dataaccess.HbaseDmlDao;
import by.mk.hbaseapp.model.HbaseTable;
import by.mk.hbaseapp.services.HbaseServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HbaseServicesImpl implements HbaseServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseServicesImpl.class);

    private HbaseDmlDao hbaseDmlDao;

    @Override
    public List<String> ListTables() throws IOException {
//        List<String> listTables = hbaseDmlDao.ListTables();

        LOGGER.info(": {}", hbaseDmlDao);

//        return listTables;
        return null;
    }

    @Override
    public boolean tableExists(String tableName) throws IOException {
        return false;
    }

    @Override
    public void InsertData(String tableName, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException {

    }

    @Override
    public void DeleteData(String tableName, byte[] rowId) throws IOException {

    }

    @Override
    public void UpdateData(String tableName, byte[] rowId, String familyName, String columnName, byte[] value) throws IOException {

    }

    @Override
    public void ScanTable(String tableName, String familyName, String columnName) throws IOException {

    }
}
