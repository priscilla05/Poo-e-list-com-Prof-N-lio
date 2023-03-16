package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = scanner.nextInt();

            while (hasId(list, id)){
                System.out.println("Id already taken, Try again");
                id = scanner.nextInt();

            }
            System.out.println("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Salary: ");
            Double salary = scanner.nextDouble();

            Employee employee = new Employee(id, name, salary);

            list.add(employee);


        }
        System.out.println(); // quebra d linha
        System.out.println("Enter the employee id that will have salary increase");

        int idSalary = scanner.nextInt();
        Employee employee = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
       // Integer posi = position(list, idSalary);
        if (employee == null) {
            System.out.println("This id does not exist");
        } else {
            System.out.println("Enter the percentage");
            double percent = scanner.nextDouble();
            employee.increaseSalary(percent);
        }
        System.out.println();
        System.out.println("List of employee: ");
        for (Employee emp : list) {
            System.out.println(emp);

        }

        scanner.close();
    }

    public static Integer position(List<Employee> list, int id) { // esse metodo vai me dizer a posicao do id na lista
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }

        }
        return null;

    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}
