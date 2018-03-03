package com.letter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "data_dict_item")
public class DataDictItem implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "dict_id")
    private String dictId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_code")
    private String itemCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
