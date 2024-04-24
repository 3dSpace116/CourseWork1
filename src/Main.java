import java.util.Random;

public class Main {
    private static final Employee[] employees = new Employee[10];
    private static final Random random = new Random(1);

    public static void main(String[] args) {
        for (int i = 0; i < employees.length; i++) {
            double salary = Math.round(20_000 + 50_000 * random.nextDouble());
            employees[i] = new Employee("ФИО сотрудника " + i, random.nextInt(1, 6), salary);

        }

        printAll();
        System.out.println(salaryTotalExpenses());
        System.out.println("Сотрудник с минимальной зарплатой " + findMinimalSalary());
        System.out.println("Сотрудник с максимальной зарплатой " + findMaxSalary());
        System.out.println("Средняя зарплата равна " + averageSalary());
        printAllNames();

        changeSalaryByPercent(10);//чтобы увидеть изменения, индексацию я расположил между блоками сложности
        changeSalaryByPercentByDepartment(5,3);

        System.out.println(findMinimalSalaryByDepartment(3));
        System.out.println(findMaxSalaryByDepartment(3));
        System.out.println(salaryTotalExpensesByDepartment(3));
        System.out.println(averageSalaryByDepartment(3));
        printAllByDepartment(3);

        compareAndPrinfIfLess(40000.0);
        compareAndPrinfIfMore(40000.0);

    }

    private static void printAll() {
        for (Employee employee : employees) {
            System.out.println(employee);

        }
    }

    private static double salaryTotalExpenses() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    private static Employee findMinimalSalary() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < min.getSalary()) {
                min = employee;
            }

        }
        return min;
    }

    private static Employee findMaxSalary() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > max.getSalary()) ;
            max = employee;

        }
        return max;
    }

    private static double averageSalary() {
        return salaryTotalExpenses() / employees.length;

    }

    private static void printAllNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());

        }
    }

    private static void changeSalaryByPercent(int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);

        }
    }

    //методы для повышенной сложности
    private static void changeSalaryByPercentByDepartment(int percent, int department) {
        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);

        }
    }

    private static Employee findMinimalSalaryByDepartment(int department) {
        Employee min = null;
        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            if (min == null || employee.getSalary() < min.getSalary()) {
                min = employee;
            }


        }
        return min;
    }

    private static Employee findMaxSalaryByDepartment(int department) {
        Employee max = null;
        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            if (max == null || employee.getSalary() > max.getSalary()) {
                max = employee;
            }


        }
        return max;
    }

    private static double salaryTotalExpensesByDepartment(int department) {
        double total = 0;
        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            total += employee.getSalary();
        }
        return total;
    }

    private static double averageSalaryByDepartment(int department) {
        int count = 0;
        double salarySum = 0;

        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            count++;
            salarySum += employee.getSalary();


        }
        return salarySum / count;
    }

    private static void printAllByDepartment(int department) {
        for (Employee employee : employees) {
            if (department != employee.getdepartment()) {
                continue;
            }
            System.out.println(employee.getFullName() + " " + employee.getSalary());

        }
    }
    private static void compareAndPrinfIfLess(double compareSalary){
        for (Employee employee : employees) {
            if (employee.getSalary()<compareSalary){
                System.out.println(employee.getId()+" "+employee.getFullName()+" "+employee.getSalary());

        }
    }}
    private static void compareAndPrinfIfMore(double compareSalary){
        for (Employee employee : employees) {
            if (employee.getSalary()>=compareSalary){
                System.out.println(employee.getId()+" "+employee.getFullName()+" "+employee.getSalary());

            }
        }}


}