package bai2.model;

public class EWalletPayment extends Payment implements Refundable{

    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Đang thanh toán qua ví điện tử (E-Wallet)...");
    }

    @Override
    public void refund() {
        System.out.println("-> Đã thực hiện hoàn tiền vào ví điện tử.");
    }
}
