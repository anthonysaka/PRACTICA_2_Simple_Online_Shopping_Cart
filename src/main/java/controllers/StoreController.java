package controllers;

import encapsulations.InvoiceProduct;
import encapsulations.Product;
import encapsulations.User;

import java.util.ArrayList;

public class StoreController {

    private ArrayList<Product> listProduct;
    private ArrayList<User> listUser;
    private ArrayList<InvoiceProduct> listSaleProduct;

    private static StoreController storeController;


    /* SINGLETON */
    public static StoreController getInstance() {
        if(storeController == null) {
            storeController = new StoreController();
        }
        return storeController;
    }

    private StoreController() {
        this.listProduct =  new ArrayList<Product>();
        this.listUser = new ArrayList<User>();
        this.listSaleProduct = new ArrayList<InvoiceProduct>();
    }

    /* Gets and Sets */

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public ArrayList<InvoiceProduct> getListSaleProduct() {
        return listSaleProduct;
    }

    public void setListSaleProduct(ArrayList<InvoiceProduct> listSaleProduct) {
        this.listSaleProduct = listSaleProduct;
    }

    public static StoreController getStoreController() {
        return storeController;
    }

    public static void setStoreController(StoreController storeController) {
        StoreController.storeController = storeController;
    }

    public void addProduct(Product p){
        listProduct.add(p);
    }

    public User searchUser(String username, String password) {
        User auxUser = null;

        for (User user: listUser) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                auxUser = user;
                break;
            }
        }
        return  auxUser;
    }

    public Product searchProduct(Integer id) {
        Product auxProd = null;

        for (Product p: listProduct) {
            if (p.getId().equals(id)){
               auxProd = p;
                break;
            }
        }
        return  auxProd;
    }

    public void editProduct(Integer id, String name, Double price, String description){
        Product aux = searchProduct(id);
        aux.setName(name);
        aux.setPrice(price);
        aux.setDescription(description);
    }

    public void addUser(User u){
        listUser.add(u);
    }

    public void addInvoice(InvoiceProduct i) { listSaleProduct.add(i);}

    public void deleteProduct(Integer id){
        for (int x = 0;x<listProduct.size();x++){
            if (listProduct.get(x).getId().equals(id)){
                listProduct.remove(x);
                break;
            }
        }
    }
}

