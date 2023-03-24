package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args){
        /*Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "Bob@gmail.com", new Date(), 3000.0, obj);*/

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: Seller findById =====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== Test 2: Seller findByDepartament =====");

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByIdDepartament(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: Seller findAll =====");

        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: Seller insert =====");

        Seller sellerInsert = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(sellerInsert);
        System.out.println("Inserted! new id = " + sellerInsert.getId());

        System.out.println("\n=== Test 5: Seller update =====");

        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!!");
    }
}
