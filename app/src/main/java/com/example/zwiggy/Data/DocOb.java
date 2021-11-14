package com.example.zwiggy.Data;

public class DocOb {
    private String mName;
    private String mDesc;
    private int mPrice;
    public DocOb(String Name,String Desc,int Price)
    {
      mName=Name;
      mDesc=Desc;
      mPrice=Price;
    }
    public String getmName()
    {
        return mName;
    }
    public String getmDesc()
    {
        return mDesc;
    }
    public int getmPrice()
    {
        return mPrice;
    }

}