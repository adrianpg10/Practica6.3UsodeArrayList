/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaAlquiler;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author adrip
 */
public class EmpresaAlquilerVehiculos {

    private String cif;
    private String nombre;
    private String paginaWeb;
    
    private int totalVehiculos;
    private ArrayList<Vehiculo> vehiculos;
    
    private int totalAlquileres;
    private ArrayList<VehiculoAlquiler> alquileres;
    
    private int totalClientes;
    private ArrayList<Cliente> clientes;
    
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public ArrayList<VehiculoAlquiler> getAlquileres() {
        return alquileres;
    }
    
    public void setAlquileres(ArrayList<VehiculoAlquiler> alquileres) {
        this.alquileres = alquileres;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;

// Incialmente no hay clientes creados en la empresa
        this.totalClientes = 0;
        this.clientes = new ArrayList<>(50); // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new ArrayList<>(50); // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new ArrayList<>(100); // apuntan a null
    }
    
    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(nuevo);
        
    }
    
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos.add(nuevo);
        
    }
    
    public void imprimirClientes() {
       
        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(clientes.get(i));
        }
    }
    
    public void imprimirVehiculos() {
       
        for (int i = 0; i < this.totalVehiculos; i++) {
            System.out.println(vehiculos.get(i));
        }
    }
    
    private Cliente getCliente(String nif) {
         for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes.get(i).getNif().equals(nif)) {
                return this.clientes.get(i);
            }
        }
        return null;
    }

    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.getTotalVehiculos(); i++) {
            if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
                return this.vehiculos.get(i);
            }
        }
        
        return null;
    }
    
    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres.add(new VehiculoAlquiler(cliente, vehiculo, diaHoy(), mesHoy(), añoHoy(), dias));
        }
    }
    
    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }
    }
    
    public static int diaHoy() {
        return LocalDate.now().getDayOfMonth();
    }
    
    public static Month mesHoy() {
        return LocalDate.now().getMonth();
    }
    
    public static int añoHoy() {
        return LocalDate.now().getYear();
    }
    
    public String getCif() {
        return cif;
    }
    
    public void setCif(String cif) {
        this.cif = cif;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPaginaWeb() {
        return paginaWeb;
    }
    
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
    public int getTotalVehiculos() {
        return totalVehiculos;
    }
    
    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }
    
    public int getTotalAlquileres() {
        return totalAlquileres;
    }
    
    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }
    
    public int getTotalClientes() {
        return totalClientes;
    }
    
    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }
    
    public ArrayList <Cliente> rellenarCLientes() {
        int clientesSeleccionables = this.totalClientes;
        for (int i = 0; i < 25; i++) {
            registrarCliente(Cliente.ClienteAleatorio());
            this.totalClientes++;
        }
        return this.clientes;
    }

    public ArrayList<Vehiculo> rellenarVehiculos() {
        int vehiculosSeleccionables = this.totalVehiculos;
        for (int i = 0; i < 25; i++) {
            registrarVehiculo(Vehiculo.vehiculoAleatorio());
            this.totalVehiculos++;
        }
        return this.vehiculos;
    }

    public ArrayList<Cliente> ordenarClientes() {
        Cliente tmp;
        for (int i = 0; i < clientes.size() - 1; i++) {
            for (int j = i + 1; j < clientes.size(); j++) {
                if (clientes.get(i).getNif().compareTo(clientes.get(j).getNif()) > 0) {
                    tmp = clientes.get(i);
                    clientes.set(j, clientes.get(j));
                    clientes.set(j, tmp);
                }
            }
        }

        return clientes;

    }

    public ArrayList<Vehiculo> ordenarVehiculos() {
        Vehiculo tmp;
        for (int i = 0; i < vehiculos.size() - 1; i++) {
            for (int j = i + 1; j < vehiculos.size(); j++) {
                if (vehiculos.get(i).getMatricula().compareTo(vehiculos.get(j).getMatricula()) > 0) {
                    tmp = vehiculos.get(i);
                    vehiculos.set(i, vehiculos.get(j));
                    vehiculos.set(j, tmp);
                }
            }
        }
        return vehiculos;
    }
    
    public int buscarCliente(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = clientes.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes.get(mitad).getNif().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (clientes.get(mitad).getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (clientes.get(mitad).getNif().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }
            
        }
        return -1;
        
    }
    
    public int buscarVehiculo(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = vehiculos.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos.get(mitad).getMatricula().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Lo ha encontrado en la posicion: " + mitad);
                return mitad;
            } else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } //buscar en el trozo izquierdo
            else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }
            
        }
        return -1;
        
    }
}
