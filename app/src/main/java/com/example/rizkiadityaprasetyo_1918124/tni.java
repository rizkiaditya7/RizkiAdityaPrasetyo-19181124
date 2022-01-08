package com.example.rizkiadityaprasetyo_1918124;

public class tni {
    private String _id, _nama, _umur, _pangkat , _satuan;

    public tni (String id, String nama, String umur, String pangkat, String satuan) {
        this._id = id;
        this._nama = nama;
        this._umur = umur;
        this._pangkat = pangkat;
        this._satuan = satuan;
    }
    public tni() {
    }

    public String get_id() { return _id;}
    public void set_id(String _id) { this._id = _id; }

    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_umur() {
        return _umur;
    }
    public void set_umur(String _umur) {
        this._umur = _umur;
    }

    public String get_pangkat() {
        return _pangkat;
    }
    public void set_pangkat(String _pangkat) {
        this._pangkat = _pangkat;
    }

    public String get_satuan() {
        return _satuan;
    }
    public void set_satuan(String _satuan) {
        this._satuan = _satuan;
    }

}
