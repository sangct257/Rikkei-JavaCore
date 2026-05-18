package bai6.ra.business;

import bai6.ra.entity.Invoice;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class InvoiceDetailBusiness {

    public static void calculateTotalRevenue() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        double grandTotal = 0;

        Invoice[] activeInvoices = InvoiceBusiness.getInvoices();
        int totalInvoices = InvoiceBusiness.getCurrentIndex();

        for (int i = 0; i < totalInvoices; i++) {
            grandTotal += activeInvoices[i].getTotalAmount();
        }
        System.out.println("TỔNG DOANH THU HỆ THỐNG ĐẠT ĐƯỢC: " + nf.format(grandTotal));
    }

    public static void findMaxAmountInvoice() {
        Invoice[] activeInvoices = InvoiceBusiness.getInvoices();
        int totalInvoices = InvoiceBusiness.getCurrentIndex();

        if (totalInvoices == 0) {
            System.out.println("Chưa có hóa đơn nào trên hệ thống để so sánh!");
            return;
        }

        Invoice maxInvoice = activeInvoices[0];
        for (int i = 1; i < totalInvoices; i++) {
            if (activeInvoices[i].getTotalAmount() > maxInvoice.getTotalAmount()) {
                maxInvoice = activeInvoices[i];
            }
        }
        System.out.println("HÓA ĐƠN CÓ GIÁ TRỊ LỚN NHẤT LÀ:");
        maxInvoice.displayData();
    }

    private static Date[] inputDateRange(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date[] dates = new Date[2];
        try {
            System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
            dates[0] = sdf.parse(scanner.nextLine().trim());
            System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
            dates[1] = sdf.parse(scanner.nextLine().trim());

            if (dates[0].after(dates[1])) {
                System.out.println("Lỗi: Ngày bắt đầu không được lớn hơn ngày kết thúc!");
                return null;
            }
            return dates;
        } catch (ParseException e) {
            System.out.println("Sai định dạng ngày tháng! Vui lòng nhập đúng kiểu dd/MM/yyyy.");
            return null;
        }
    }

    public static void countInvoicesInDateRange(Scanner scanner) {
        Date[] range = inputDateRange(scanner);
        if (range == null) return;

        Invoice[] activeInvoices = InvoiceBusiness.getInvoices();
        int totalInvoices = InvoiceBusiness.getCurrentIndex();

        int count = 0;
        for (int i = 0; i < totalInvoices; i++) {
            Date invDate = activeInvoices[i].getInvoiceDate();
            if (!invDate.before(range[0]) && !invDate.after(range[1])) {
                count++;
            }
        }
        System.out.println("Số lượng hóa đơn phát sinh trong khoảng ngày trên: " + count + " hóa đơn.");
    }

    public static void sumRevenueInDateRange(Scanner scanner) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        Date[] range = inputDateRange(scanner);
        if (range == null) return;

        Invoice[] activeInvoices = InvoiceBusiness.getInvoices();
        int totalInvoices = InvoiceBusiness.getCurrentIndex();

        double periodTotal = 0;
        for (int i = 0; i < totalInvoices; i++) {
            Date invDate = activeInvoices[i].getInvoiceDate();
            if (!invDate.before(range[0]) && !invDate.after(range[1])) {
                periodTotal += activeInvoices[i].getTotalAmount();
            }
        }
        System.out.println("Tổng doanh thu tích lũy trong khoảng ngày đã chọn: " + nf.format(periodTotal));
    }
}
