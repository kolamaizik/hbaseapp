package by.mk.hbaseapp.model;

public class ColumnValue {
    private final String column;
    private final String value;

    public ColumnValue() {
        this.column = null;
        this.value = null;
    }

    public ColumnValue(String column, String value) {
        this.column = column;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.format("ColumnFamilyValue{column = '%s', value = %s", column, value);
    }
}
