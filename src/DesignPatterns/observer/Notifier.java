package DesignPatterns.observer;

public class Notifier implements INotifier
{
    public void NotifyMarketingTeam(Product product)
    {
        System.out.println("Notifying marketing team");
        //Other notification logic
    }
}
