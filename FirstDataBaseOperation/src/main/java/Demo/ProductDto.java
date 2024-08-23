package Demo;

public class ProductDto {
    private int productId;
    private String ProductName;
    private double productPrice;
    private int productQty;
    private String productCat;

    public ProductDto() {
    }

    public ProductDto(int productId, String productName, double productPrice, int productQty, String productCat) {
        this.productId = productId;
        ProductName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productCat = productCat;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getProductCat() {
        return productCat;
    }

    public void setProductCat(String productCat) {
        this.productCat = productCat;
    }
}
