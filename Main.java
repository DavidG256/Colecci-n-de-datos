import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //David García Antón
    public static void main(String[] args) {
        boolean menu = true;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("0. Salir");
                System.out.println("1. Insertar");
                System.out.println("2. Eliminar");
                System.out.println("3. Actualizar");
                System.out.println("4. Consultar");
                System.out.println("5. Imprimir");
                System.out.print("Elige una opción: ");

                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del programa");
                        menu = false;
                        break;
                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("¿Es jefe? (true/false): ");
                        String entrada = sc.nextLine().toLowerCase();
                        boolean esJefe;

                        if (entrada.equals("true")) {
                            esJefe = true;
                        } else if (entrada.equals("false")) {
                            esJefe = false;
                        } else {
                            System.out.println("Entrada inválida. Debes escribir 'true' o 'false'.");
                            continue;
                        }

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
                        entrada = sc.nextLine().toLowerCase();

                        if (entrada.equals("true")) {
                            esJefe = true;
                        } else if (entrada.equals("false")) {
                            esJefe = false;
                        } else {
                            System.out.println("Entrada inválida. Debes escribir 'true' o 'false'.");
                            continue;
                        }

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
                        System.out.print("ID del vendedor a consultar: ");
                        id = sc.nextLine();
                        Vendedor vendedor = Vendedor.queryVendedor(id);
                        if (vendedor != null) {
                            System.out.println("Vendedor encontrado: " + vendedor);
                        } else {
                            System.out.println("Vendedor no encontrado.");
                        }
                        break;
                    case 5:
                        Vendedor.printVendedor();
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                sc.nextLine();
            }
        } while (menu);

        sc.close();
    }
}
