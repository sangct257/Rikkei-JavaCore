package bai3.business;

import bai3.entity.Invoice;
import bai3.entity.Manage;
import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> invoiceList = new ArrayList<>();

    public ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    @Override
    public void add(Invoice item) {
        invoiceList.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void update(int index, Invoice item) {
        int actualIndex = index - 1;
        if (actualIndex >= 0 && actualIndex < invoiceList.size()) {
            invoiceList.set(actualIndex, item);
            System.out.println("Hóa đơn đã được sửa thành công.");
        } else {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + index);
        }
    }

    @Override
    public void delete(int index) {
        int actualIndex = index - 1;
        if (actualIndex >= 0 && actualIndex < invoiceList.size()) {
            invoiceList.remove(actualIndex);
            System.out.println("Hóa đơn đã được xoa thành công.");
        } else {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + index);
        }
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            return;
        }
        int displayIndex = 1;
        for (Invoice inv : invoiceList) {
            System.out.println(displayIndex + ". ID : " + displayIndex + " , " + inv);
            displayIndex++;
        }
    }
}