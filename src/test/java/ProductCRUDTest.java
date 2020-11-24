import java.util.ArrayList;
import java.util.List;

import choppyng.bean.Product;
import choppyng.dao.ProductCRUD;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class ProductCRUDTest {


    private  static List<Product> list;
    private  static ProductCRUD productCRUD;

    final Product productOne  = new Product("product1", 12.5);
    final Product productTWo  = new Product("product2", 12.5);

    @BeforeClass
    public static void setup() {
        list = new ArrayList<>();
        productCRUD = new ProductCRUD();
    }

    @Test
    public void mustNotAddProductWhenIsNull(){
        final Product  productNull  = null;
        productCRUD.addProduct(productNull);
        Assert.assertTrue(productCRUD.getListShopping().size()==0);
    }

    @Test
    public void mustAddProductWhenIsNotNull(){
        productCRUD.addProduct(productOne);
        Assert.assertTrue(productCRUD.getListShopping().size()>0);
    }

    @Test
    public void mustAddSameProductWhenWithQuantities(){
        productCRUD.addProduct(productOne);
        productCRUD.addProduct(productOne);
        Assert.assertTrue(productCRUD.getListShopping().size()==1);
        Assert.assertTrue(productCRUD.getListShopping().stream().map(el -> el.getQuantite()).reduce(0, Integer::sum) == 2);
        productCRUD.printShoppingCard();
    }

    @Test
    public void mustAddProductWhenIsNotSame() {
        productCRUD.addProduct(productOne);
        productCRUD.addProduct(productTWo);
        Assert.assertTrue(productCRUD.getListShopping().size() == 2);
        productCRUD.printShoppingCard();
    }

    @Test
    public void mustDeleteProductWhenIsExisted() {
        productCRUD.addProduct(productOne);
        productCRUD.addProduct(productTWo);
        Assert.assertTrue(productCRUD.getListShopping().size() == 2);
        productCRUD.deleteProduct(productOne);
        Assert.assertTrue(productCRUD.getListShopping().size() == 1);
        productCRUD.printShoppingCard();
    }

    @Test
    public void mustSumShoppingCard() {
        productCRUD.addProduct(productOne);
        productCRUD.addProduct(productTWo);
        Assert.assertTrue(productCRUD.getListShopping().size() == 2);
        double sumShoppingCart = productCRUD.sumShoppingCard();
        Assert.assertTrue(sumShoppingCart == 25);
        productCRUD.printShoppingCard();
    }

    @After
    public void tearThis() {
        productCRUD.getListShopping().clear();
    }

    @AfterClass
    public static void tear() {
    }
}