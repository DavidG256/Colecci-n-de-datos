import java.util.*;

class Vendedor {
    private String idVendedor;
    private boolean esJefe;
    private int salario;
    private String jornadaLaboral;
    private static List<Vendedor> vendedores = new ArrayList<>();

    public Vendedor(String idVendedor, boolean esJefe, int salario, String jornadaLaboral) {
        this.idVendedor = idVendedor;
        this.esJefe = esJefe;
        this.salario = salario;
        this.jornadaLaboral = jornadaLaboral;
    }

    public String getIdVendedor() { return idVendedor; }
    public boolean isEsJefe() { return esJefe; }
    public int getSalario() { return salario; }
    public String getJornadaLaboral() { return jornadaLaboral; }

    public void setEsJefe(boolean esJefe) { this.esJefe = esJefe; }
    public void setSalario(int salario) { this.salario = salario; }
    public void setJornadaLaboral(String jornadaLaboral) { this.jornadaLaboral = jornadaLaboral; }

    public static boolean addNewVendedor(Vendedor v) {
        if (findVendedor(v.getIdVendedor()) == null) {
            vendedores.add(v);
            return true;
        }
        return false;
    }

    public static boolean removeVendedor(String id) {
        Vendedor v = findVendedor(id);
        if (v != null) {
            vendedores.remove(v);
            return true;
        }
        return false;
    }

    public static boolean updateVendedor(String id, boolean esJefe, int salario, String jornadaLaboral) {
        Vendedor v = findVendedor(id);
        if (v != null) {
            v.setEsJefe(esJefe);
            v.setSalario(salario);
            v.setJornadaLaboral(jornadaLaboral);
            return true;
        }
        return false;
    }

    public static Vendedor findVendedor(String id) {
        for (Vendedor v : vendedores) {
            if (v.getIdVendedor().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public static void printVendedor() {
        for (Vendedor v : vendedores) {
            System.out.println(v);
        }
    }

    @Override
    public String toString() {
        return "ID: " + idVendedor + ", Jefe: " + esJefe + ", Salario: " + salario + ", Jornada: " + jornadaLaboral;
    }
}