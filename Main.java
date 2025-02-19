import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1. Insertar\n2. Eliminar\n3. Actualizar\n4. Consultar\n5. Imprimir\n6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("¿Es jefe? (true/false): ");
                    boolean esJefe = sc.nextBoolean();
                    System.out.print("Salario: ");
                    int salario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Jornada Laboral: ");
                    String jornada = sc.nextLine();
                    if (Vendedor.addNewVendedor(new Vendedor(id, esJefe, salario, jornada))) {
                        System.out.println("Vendedor agregado.");
                    } else {
                        System.out.println("ID ya existente.");
                    }
                    break;
                case 2:
                    System.out.print("ID a eliminar: ");
                    id = sc.nextLine();
                    if (Vendedor.removeVendedor(id)) {
                        System.out.println("Vendedor eliminado.");
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID a actualizar: ");
                    id = sc.nextLine();
                    System.out.print("¿Es jefe? (true/false): ");
                    esJefe = sc.nextBoolean();
                    System.out.print("Salario: ");
                    salario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Jornada Laboral: ");
                    jornada = sc.nextLine();
                    if (Vendedor.updateVendedor(id, esJefe, salario, jornada)) {
                        System.out.println("Vendedor actualizado.");
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID a consultar: ");
                    id = sc.nextLine();
                    Vendedor vendedor = Vendedor.findVendedor(id);
                    if (vendedor != null) {
                        System.out.println(vendedor);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 5:
                    Vendedor.printVendedor();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        sc.close();
    }
}
