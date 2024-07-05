package model;

import java.util.ArrayList;

public class Oder  {
    private String oderId, ngayTao;
    private Customer khachHang;
    private ArrayList<Product> listSanPhamDuocChon = new ArrayList<>();
    public Oder(String oderId, String ngayTao, Customer khachHang, ArrayList<Product> listSanPhamDuocChon) {
        this.oderId = oderId;
        this.ngayTao = ngayTao;
        this.khachHang = khachHang;
        this.listSanPhamDuocChon = listSanPhamDuocChon;
    }
    public String getOderId() {
        return oderId;
    }
    public void setOderId(String oderId) {
        this.oderId = oderId;
    }
    public String getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    public Customer getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(Customer khachHang) {
        this.khachHang = khachHang;
    }
    public ArrayList<Product> getListSanPhamDuocChon() {
        return listSanPhamDuocChon;
    }
    public void setListSanPhamDuocChon(ArrayList<Product> listSanPhamDuocChon) {
        this.listSanPhamDuocChon = listSanPhamDuocChon;
    }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Oder other = (Oder) obj;
        if (oderId == null) {
            if (other.oderId != null)
                return false;
        } else if (!oderId.equals(other.oderId))
            return false;
        return true;


        
    }

    public void listspdc(){
            for (Product listspdc : listSanPhamDuocChon) {
                System.out.println(listspdc);
            }
    }
    @Override
    public String toString() {
        return "Oder [oderId=" + oderId + ", ngayTao=" + ngayTao + ", khachHang=" + khachHang + ", listSanPhamDuocChon="
                + listSanPhamDuocChon + "]";
    }
    



}
