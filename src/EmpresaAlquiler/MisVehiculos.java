/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaAlquiler;

import java.util.Scanner;

/**
 *
 * @author adrip
 */
public class MisVehiculos {

    public static void main(String[] args) {
 Scanner teclado = new Scanner(System.in);
// la instancia easydrive de la clase EmpresaAlquilerVehiculos
        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive",
                "www.easydrive.com");

        // registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));

        // registro de los vehículos de la empresa
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));

        // imprime la relación de clientes de easydrive
        easydrive.imprimirClientes();
// imprime el catálogo de vehículos de easydrive
        easydrive.imprimirVehiculos();

        easydrive.rellenarVehiculos();
        easydrive.rellenarCLientes();

        easydrive.imprimirVehiculos();
        easydrive.imprimirClientes();

        System.out.println("---------------");
//Ordenamos vehiculos y clientes e imprimimos
        easydrive.ordenarVehiculos();
        easydrive.ordenarCliente();

        easydrive.imprimirVehiculos();
        easydrive.imprimirClientes();

        System.out.println("--------------");


        easydrive.buscarVehiculo("8701WOP");
        easydrive.buscarCliente("8903JOU");
        
        easydrive.imprimirVehiculos();
        easydrive.imprimirClientes();

        System.out.println("-------------");
        
        System.out.println("Indica tu NIF:");
        String dni = teclado.nextLine();
        
        System.out.println("Indica la matricula del vehiculo:");
        String matricula = teclado.nextLine();
        
        System.out.println("Indica los dias de alquiler");
        int dias = teclado.nextInt();
        
        easydrive.alquilarVehiculo(matricula, dni, 0);

        //Busqueda binaria nif y matricula
        
        System.out.println("------------");
        
        teclado.nextLine();
        
        System.out.println("Indica tu NIF:");
        dni = teclado.nextLine();
        System.out.println(easydrive.buscarCliente(dni));
        
        System.out.println("Indica la matricula del vehiculo:");
         matricula = teclado.nextLine();
         System.out.println(easydrive.buscarVehiculo(matricula));
    }
}
