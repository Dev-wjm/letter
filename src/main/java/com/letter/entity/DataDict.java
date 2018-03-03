package com.letter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_dict")
public class DataDict {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "data_dict")
    private String dataDict;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataDict() {
        return dataDict;
    }

    public void setDataDict(String dataDict) {
        this.dataDict = dataDict;
    }
}
