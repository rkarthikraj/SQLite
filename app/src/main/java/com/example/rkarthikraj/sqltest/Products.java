package com.example.rkarthikraj.sqltest;

/**
 * Created by R KARTHIK RAJ on 20-12-2016.
 */

public class Products {
    int _id;
    String _productname;

    public Products(){
    }

    public Products(String _productname) {
        this._productname = _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public String get_productname() {
        return _productname;
    }

    public int get_id() {
        return _id;
    }
}
