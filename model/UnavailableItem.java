package model;

public class UnavailableItem {
    private Product product ;
    private String reason ;

    public UnavailableItem(Product product , String reason) {
        this.product = product ;
        this.reason = reason ;
    }

    public Product getProduct() {
        return this.product ;
    }

    public String getReason() {
        return this.reason ;
    }
}
