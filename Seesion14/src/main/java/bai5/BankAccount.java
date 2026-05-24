package bai5;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Gửi tiền
    public void Deposit() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số tiền gửi: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                throw new IllegalArgumentException("Lỗi: Số tiền gửi phải lớn hơn 0!");
            }

            balance = balance + amount;
            System.out.println("Đã gửi thành công số tiền: " + nf.format(amount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lỗi: Định dạng nhập vào phải là một số hợp lệ!");
        }
    }

    // Rút tiền
    public void Withdraw() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền cần rút: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút phải lớn hơn 0!");
            }
            if (amount > this.balance) {
                throw new IllegalArgumentException("Lỗi: Số dư tài khoản không đủ để rút!");
            }
            balance = balance - amount;
            System.out.println("Đã rút thành công số tiền : " + nf.format(amount));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lỗi: Định dạng nhập vào phải là một số hợp lệ!");
        }
    }

    // chuyển tiền
    public void Transfer(String targetAccountId, List<BankAccount> accountList) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền cần chuyển: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                throw new IllegalArgumentException("Lỗi: Số tiền chuyển phải lớn hơn 0!");
            }

            // 2. Kiểm tra số dư tài khoản nguồn (tài khoản hiện tại)
            if (amount > this.balance) {
                throw new IllegalArgumentException("Lỗi: Không đủ số dư tài khoản để chuyển!");
            }

            // 3. Tìm tài khoản đích
            BankAccount targeBankAccount = null;
            for (BankAccount account : accountList) {
                if (account.getAccountId().equalsIgnoreCase(targetAccountId)) {
                    targeBankAccount = account;
                    break;
                }
            }

            if (targeBankAccount == null) {
                throw new IllegalArgumentException("Lỗi: Không tìm thấy số tài khoản người nhận: " + targetAccountId);
            }

            this.balance = this.balance - amount;
            targeBankAccount.balance = targeBankAccount.balance + amount;

            System.out.println("Chuyển thành công " + nf.format(amount) + " tới số tài khoản " + targetAccountId);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: phải nhập một số");
        }
    }

}

