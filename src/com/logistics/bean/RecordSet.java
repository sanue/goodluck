package com.logistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class RecordSet<T>{



    private int rowCount;
    private int pageSize;
    private List<T> recordSet;

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getRowCount() {
        return rowCount;
    }
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCode() {
        return rowCount % pageSize  == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
    }
    public RecordSet(){
        this.recordSet = new ArrayList<T>();
    }

    public void setRecordSet(List<T> recordSet) {
        this.recordSet = recordSet;
    }
    public List<T> getRecordSet() {
        return recordSet;
    }




}
