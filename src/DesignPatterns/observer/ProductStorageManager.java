package DesignPatterns.observer;

public class ProductStorageManager implements IProductStorageManager{
    @Override
    public void UpdateStorage(Product product) {
        System.out.println("Product stored in storage");
    }
}

