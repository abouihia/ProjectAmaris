package choppyng.dao;

import choppyng.bean.Product;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.Optional;
import java.util.ArrayList;

/**
 * @author baboulhia
 * @since 24/11/2020
 */
public class ProductCRUD {

    private List<Product>  listShopping   = new ArrayList<>();

    public List<Product> getListShopping() {
        return listShopping;
    }

    public void  addProduct(final Product  product){
        if(Objects.nonNull(product)){

            final Optional<Product> productExist = listShopping.stream().filter(o -> o.getName().equals(product.getName()))
                    .findFirst();
            if( productExist.isPresent()){
                product.setQuantite(productExist.get().getQuantite()+1);
                listShopping.set(listShopping.indexOf(productExist.get()), product);
            }else{
                product.setIdentifiant(UUID.randomUUID().getMostSignificantBits());
                product.setQuantite(1);
                listShopping.add(product);
            }
        }

    }

    public boolean  deleteProduct( final Product  product){
        if(Objects.nonNull(product)&&  listShopping.stream().filter(o -> o.getName().equals(product.getName()))
                .findFirst().isPresent()){
           return listShopping.remove(product);
        }
        return false;
    }

    public double  sumShoppingCard(){
        return !listShopping.isEmpty() ?
                listShopping.stream().mapToDouble(el -> el.getPrice()).sum()
                :0D;
    }

    public void  printShoppingCard(){
        if( !listShopping.isEmpty()){
            System.out.println("Your shopping cart : ");
            listShopping.stream().forEach(el ->{
                System.out.println(" Name: "+ el.getName() + "  Quantite: "+ el.getQuantite()+"\n");

            });
        }
        System.out.println("Your shopping cart is empty");
    }

}
