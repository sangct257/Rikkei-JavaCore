package bai2.model;

public class CreditCardPayment extends Payment implements Refundable{

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Đang thanh toán qua thẻ tín dụng (Credit Card)...");
    }

    @Override
    public void refund() {
        System.out.println("-> Đã thực hiện hoàn tiền vào thẻ tín dụng.");
    }
}
