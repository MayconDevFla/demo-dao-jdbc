package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==== TESTE 1 - findAll Department");
        DepartmentDao depNew = DaoFactory.createDepartmentDao();

        List<Department> list = depNew.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("==== TESTE 2 - findById Department");
        Department dep = depNew.findById(2);
        System.out.println(dep);

        System.out.println("==== TESTE 3 - insert Department");
        dep = new Department(null, "Corregedoria");
        depNew.insert(dep);
        System.out.println("Insert completed!");

        System.out.println("==== TESTE 4 - update Department");
        dep = new Department(7, "Tecnology");
        depNew.update(dep);
        System.out.println("Update completed!");

        System.out.println("==== TESTE 5 - delete Department");
        System.out.println("Digite um código de departamento para exclusão: ");
        int id = sc.nextInt();
        depNew.deleteById(id);
        System.out.println("Deleted completed!");
    }
}
