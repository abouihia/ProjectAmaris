package choppyng.bean;


public class Product {

    private long identifiant;

    private String  name;
    private double price;
    private int quantite;

    public Product(  final String name, final double price ) {

        this.name = name;
        this.price = price;

    }

    public Product( final long identifiant,  final String name, final double price, final int quantite) {

        this.identifiant = identifiant;
        this.name = name;
        this.price = price;
        this.quantite  = quantite;
    }

    public long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(final long identifiant) {
        this.identifiant = identifiant;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(final int quantite) {
        this.quantite = quantite;
    }
}
