package com.zt.java.thread.product;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class Product {
    private String producedBy="N/A";
    private String consumedBy="N/A";

    public Product() {
    }

    public Product(String producedBy, String consumedBy) {
        this.producedBy = producedBy;
        this.consumedBy = consumedBy;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getConsumedBy() {
        return consumedBy;
    }

    public void setConsumedBy(String consumedBy) {
        this.consumedBy = consumedBy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "producedBy='" + producedBy + '\'' +
                ", consumedBy='" + consumedBy + '\'' +
                '}';
    }

}
