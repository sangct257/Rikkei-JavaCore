package bai5;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        List<BankAccount> accountList = new ArrayList<>();

        accountList.add(new BankAccount("VCB001", 1000000));
        accountList.add(new BankAccount("TBP002", 300000));

        System.out.println("=== DANH SÁCH TÀI KHOẢN BAN ĐẦU ===");
        inDanhSach(accountList);
        System.out.println("-----------------------------------\n");

        BankAccount myAccount = accountList.get(0);

        while (true){
            System.out.println("[THỰC HIỆN GỬI TIỀN]");
            try {
                myAccount.Deposit();
                break;
            } catch (IllegalArgumentException e) {
                // Hàm main bắt ngoại lệ phát sinh từ hàm Deposit và hiển thị lỗi rõ ràng
                System.out.println("[THÔNG BÁO] " + e.getMessage());
            }
            System.out.println("Số dư hiện tại: " + nf.format(myAccount.getBalance()));
        }

        while (true){
            System.out.println("[THỰC HIỆN RÚT TIỀN]");
            try {
                myAccount.Withdraw();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[THÔNG BÁO] " + e.getMessage());
            }
            System.out.println("Số dư hiện tại: " + nf.format(myAccount.getBalance()));
        }

        while (true){
            System.out.println("[THỰC HIỆN CHUYỂN TIỀN]");
            try {
                myAccount.Transfer("TBP002", accountList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[THÔNG BÁO] " + e.getMessage());
            }
        }

        System.out.println("\n=== DANH SÁCH TÀI KHOẢN SAU GIAO DỊCH ===");
        inDanhSach(accountList);
    }

    private static void inDanhSach(List<BankAccount> list) {
        for (BankAccount acc : list) {
            System.out.println("Mã TK: " + acc.getAccountId() + " | Số dư: " + String.format("%,.0f", acc.getBalance()) + "đ");
        }
    }

}
