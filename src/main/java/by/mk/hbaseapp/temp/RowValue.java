package by.mk.hbaseapp.temp;

import java.util.List;

public class RowValue {

    private final String rowKey;
    private final List<ColumnFamilyValue> columnFamilies;

    public RowValue() {
        this.rowKey = null;
        this.columnFamilies = null;
    }

    public RowValue(String rowKey, List<ColumnFamilyValue> columnFamilies) {
        this.rowKey = rowKey;
        this.columnFamilies = columnFamilies;
    }

    public String getRowKey() {
        return rowKey;
    }

    public List<ColumnFamilyValue> getColumnFamilies() {
        return columnFamilies;
    }
}
