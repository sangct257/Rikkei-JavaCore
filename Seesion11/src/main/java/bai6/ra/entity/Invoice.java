package bai6.ra.entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails = new InvoiceDetail[0];
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate, InvoiceDetail[] invoiceDetails, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        // Giả định mảng quản lý hóa đơn tổng sẽ được check trùng ID ở tầng Business (như bài trước)
        getInvoiceIdInput(scanner);
        getCustomerNameInput(scanner);
        getInvoiceDateInput(scanner);

        // Tiến hành nhập các mặt hàng mua trong hóa đơn này
        getInvoiceDetailsInput(scanner, arrProd, prodIndex);

        // Sau khi nhập xong xuôi danh sách mặt hàng, tự động tính toán tổng tiền luôn
        calculateTotalAmount();
    }

    public void inputUpdateData(Scanner scanner, Product[] arrProd, int prodIndex) {
        System.out.println("--- Cập nhật thông tin cho hóa đơn " + this.invoiceId + " ---");
        getCustomerNameInput(scanner);
        getInvoiceDateInput(scanner);

        // Cho phép nhập lại danh sách các mặt hàng mua (hoặc cập nhật giỏ hàng mới)
        getInvoiceDetailsInput(scanner, arrProd, prodIndex);

        // Tính toán lại tổng tiền mới sau khi danh sách chi tiết thay đổi
        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        this.totalAmount = 0;
        if (this.invoiceDetails != null) {
            for (InvoiceDetail detail : this.invoiceDetails) {
                if (detail != null) {
                    // Lấy thẳng subTotal đã được tính sẵn từ bên trong InvoiceDetail
                    this.totalAmount += detail.getSubTotal();
                }
            }
        }
    }

    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=================================================================");
        System.out.println("Mã HĐ: " + this.invoiceId + " | Khách hàng: " + this.customerName + " | Ngày lập: " + sdf.format(this.invoiceDate));
        System.out.println("---------------- DANH SÁCH SẢN PHẨM MUA ----------------");

        if (this.invoiceDetails == null || this.invoiceDetails.length == 0) {
            System.out.println("   (Chưa có sản phẩm nào trong hóa đơn này)");
        } else {
            System.out.println("STT, Mã SP, Tên sản phẩm, Giá bán, Số lượng, Thành tiền");
            for (int i = 0; i < this.invoiceDetails.length; i++) {
                InvoiceDetail dt = this.invoiceDetails[i];
                if (dt != null) {
                    // In ra số thứ tự trước
                    System.out.print((i + 1) + ", ");
                    dt.displayData();
                }
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("TỔNG TIỀN THANH TOÁN: " + nf.format(this.totalAmount));
        System.out.println("=================================================================\n");
    }

    private void getInvoiceIdInput(Scanner scanner) {
        do {
            System.out.print("Mời nhập vào mã hóa đơn (Định dạng HDxxxx, ví dụ HD0001): ");
            this.invoiceId = scanner.nextLine().trim();
            if (this.invoiceId.matches("^HD\\d{4}$")) {
                break;
            } else {
                System.out.println("Mã hóa đơn sai định dạng! (Phải gồm 6 ký tự và bắt đầu bằng chữ HD)");
            }
        } while (true);
    }

    private void getCustomerNameInput(Scanner scanner) {
        do {
            System.out.print("Mời nhập vào tên khách hàng: ");
            this.customerName = scanner.nextLine().trim();
            if (!this.customerName.isEmpty()) {
                break;
            } else {
                System.out.println("Tên khách hàng không được để trống!");
            }
        } while (true);
    }

    private void getInvoiceDateInput(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Chặn việc nhập ngày phi lý (ví dụ ngày 32/01)
        do {
            System.out.print("Mời nhập vào ngày lập hóa đơn (dd/MM/yyyy, ví dụ: 19/05/2026): ");
            try {
                this.invoiceDate = sdf.parse(scanner.nextLine().trim());
                break;
            } catch (ParseException e) {
                System.out.println("Sai định dạng ngày tháng! Vui lòng nhập đúng kiểu ngày/tháng/năm.");
            }
        } while (true);
    }

    private void getInvoiceDetailsInput(Scanner scanner, Product[] arrProd, int prodIndex) {
        if (prodIndex == 0) {
            System.out.println("Hệ thống chưa có sản phẩm nào! Không thể thêm chi tiết mua hàng.");
            this.invoiceDetails = new InvoiceDetail[0];
            return;
        }

        int numberItems = 0;
        do {
            try {
                System.out.print("Mời nhập số lượng mặt hàng mua trong hóa đơn này: ");
                numberItems = Integer.parseInt(scanner.nextLine().trim());
                if (numberItems > 0) {
                    break;
                } else {
                    System.out.println("Số lượng mặt hàng mua phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Bạn phải nhập vào số nguyên!");
            }
        } while (true);

        this.invoiceDetails = new InvoiceDetail[numberItems];

        // Vòng lặp điền thông tin cho từng mặt hàng mua
        for (int i = 0; i < numberItems; i++) {
            System.out.println("Nhập thông tin cho mặt hàng thứ " + (i + 1) + ":");
            InvoiceDetail detail = new InvoiceDetail();

            // Gọi hàm inputData nội bộ của InvoiceDetail để lấy Mã SP, Số lượng, và gán thông tin Product hợp lệ
            detail.inputData(scanner, arrProd, prodIndex);

            // Chặn trùng lặp: Nếu khách hàng mua cùng 1 sản phẩm 2 lần, bắt nhập lại hoặc bạn có thể gom số lượng (ở đây thiết kế bắt chọn mã khác)
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (this.invoiceDetails[j].getProduct().getProductId().equalsIgnoreCase(detail.getProduct().getProductId())) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Sản phẩm này đã có trong hóa đơn rồi! Vui lòng nhập lại mã sản phẩm khác.");
                i--; // Lùi chỉ số i để nhập lại ô này
            } else {
                this.invoiceDetails[i] = detail;
            }
        }
    }
}
