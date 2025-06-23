package DesignPatterns.observer;

public class WebsiteStorageManager implements IWebsiteStorageManager
{
    @Override
    public void UpdateProductList(Product product)
    {
        System.out.println("Product added to website");
        //Other website logic
    }
}
