/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaAlquiler;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author adrip
 */
public class Cliente {

    private String nif;
    private String nombre;
    private String apellidos;

    public Cliente(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return nif + " " + apellidos + ", " + nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public static Cliente ClienteAleatorio() {

        Random aleatorio = new Random();
        ArrayList<String> abecedario = new ArrayList<>();

        abecedario.add("A");
        abecedario.add("B");
        abecedario.add("C");
        abecedario.add("D");
        abecedario.add("E");
        abecedario.add("F");
        abecedario.add("G");
        abecedario.add("H");
        abecedario.add("I");
        abecedario.add("J");
        abecedario.add("K");
        abecedario.add("L");
        abecedario.add("M");
        abecedario.add("N");
        abecedario.add("O");
        abecedario.add("P");
        abecedario.add("Q");
        abecedario.add("R");
        abecedario.add("S");
        abecedario.add("T");
        abecedario.add("U");
        abecedario.add("V");
        abecedario.add("W");
        abecedario.add("X");
        abecedario.add("Y");
        abecedario.add("Z");

        int posicion1 = aleatorio.nextInt(9);
        int posicion2 = aleatorio.nextInt(9);
        int posicion3 = aleatorio.nextInt(9);
        int posicion4 = aleatorio.nextInt(9);
        int posicion5 = aleatorio.nextInt(9);
        int posicion6 = aleatorio.nextInt(9);
        int posicion7 = aleatorio.nextInt(9);
        int posicion8 = aleatorio.nextInt(9);
        int posicion9 = aleatorio.nextInt(9);

        String numeroDni = posicion1 + "" + posicion2 + "" + posicion3 + "" + posicion4 + "" + posicion5 + "" + posicion6 + "" + posicion7 + "" + posicion8 + "" + posicion9;

        String letra = abecedario.get(aleatorio.nextInt(abecedario.size()));

        String dni = numeroDni + " - " + letra;

        numeroDni = posicion1 + "" + posicion2 + "" + posicion3 + "" + posicion4 + "" + posicion5 + "" + posicion6 + "" + posicion7 + "" + posicion8 + "" + posicion9;

        dni = numeroDni + "-" + letra;

        ArrayList<String> nombre = new ArrayList<>();
        nombre.add("Adrián");
        nombre.add("Paco");
        nombre.add("Juan");
        nombre.add("Manolo");
        nombre.add("Raúl");

        ArrayList<String> apellido = new ArrayList<>();
        apellido.add("Pérez");
        apellido.add("Gómez");
        apellido.add("Martín");
        apellido.add("Gonzalez");
        apellido.add("Sanchez");

        System.out.println("Nif: " + dni);

        String nombreElegido = nombre.get(aleatorio.nextInt(nombre.size()));
       

        String apellidoElegido = apellido.get(aleatorio.nextInt(apellido.size()));
        

        Cliente cliente = new Cliente(dni, nombreElegido, apellidoElegido);
        return cliente;
    }

    public static void main(String[] args) {

        Cliente.ClienteAleatorio();

    }

}
