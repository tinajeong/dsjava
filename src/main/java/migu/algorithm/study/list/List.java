package migu.algorithm.study.list;

import migu.algorithm.study.data.IntData;

public interface List {
    void insertData(IntData listData);
    IntData removeData();
    int countData();
    boolean listFirst();
    boolean listNext();
}
