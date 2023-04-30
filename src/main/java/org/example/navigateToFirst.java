package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class navigateToFirst extends BaseTest {
    @Test(priority = 4)
    public void selectProductOptions(){
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        try {
            WebElement modelDropdown = driver.findElement(By.id("x-msku__select-box-1000"));
            modelDropdown.click();
            WebElement model = driver.findElement(By.xpath("//option[text()='Apple iPhone X']"));
            model.click();
        }catch (Exception e){}
        try {
            WebElement carrierDropdown = driver.findElement(By.id("x-msku__select-box-1001"));
            carrierDropdown.click();
            WebElement carrier = driver.findElement(By.xpath("//option[text()='Unlocked (GSM)']"));
            carrier.click();
        }catch (Exception e){}
        try {
            WebElement storageDropdown = driver.findElement(By.id("x-msku__select-box-1002"));
            storageDropdown.click();
            WebElement storage = driver.findElement(By.xpath("//option[text()='256 GB']"));
            storage.click();
        }catch (Exception e){}
        try {
            WebElement colorDropdown = driver.findElement(By.id("x-msku__select-box-1003"));
            colorDropdown.click();
            WebElement color = driver.findElement(By.xpath("//option[text()='Gray']"));
            color.click();
        }catch (Exception e){}
        try {
            WebElement cosmeticDropdown = driver.findElement(By.id("x-msku__select-box-1004"));
            cosmeticDropdown.click();
            WebElement cosmetic = driver.findElement(By.xpath("//option[text()='Good']"));
            cosmetic.click();
        }catch (Exception e){}

    }

    @Test(priority = 5)
    public void productName(){
        WebElement name = driver.findElement(By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span"));
        this.strItemName=name.getText();
        System.out.println("item Name : "+name.getText());

        WebElement price = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]/span"));
        this.strItemPrice=price.getText();
        System.out.println("item Price : "+price.getText());

        WebElement condition = driver.findElement(By.xpath("//*[@id=\"SRPSection\"]"));
        System.out.println("item Condition : \n"+condition.getText());

        WebElement quantity = driver.findElement(By.id("qtyTextBox"));
        System.out.println("item Quantity : "+quantity.getAttribute("value"));
    }

    @Test(priority = 6)
    public void addCart(){
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span"));
        btn.click();
    }

    @Test(priority = 7)
    public void assertShoppingCart(){
        WebElement name = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div[1]/div/div/div[1]/div/div[2]/div/h3/span/a/span/span/label"));
        System.out.println("item Name : \n"+name.getText());
        assert !this.strItemName.equals(name):"names are not matching";

        WebElement price = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div[1]/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/div/span/span/span"));
        assert !this.strItemPrice.equals(price):"prices are not matching";
        System.out.println("item Price : \n"+price.getText());

        WebElement subTotal = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span"));
        assert !this.strItemPrice.equals(subTotal):"sub Total is not matching";
        System.out.println("sub total : \n"+subTotal.getText());

        WebElement shippingCharge = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[2]/div[2]/span/span/span"));
        System.out.println("Shipping charge : "+shippingCharge.getText());

        WebElement qty = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div/div/div/div[1]/div/div[3]/div/div[1]/div[1]/div/div/span/span/span[2]"));
        //assert qty.equals("Qty 0"):"Quantity is empty";
        System.out.println("item "+qty.getText());
    }
}