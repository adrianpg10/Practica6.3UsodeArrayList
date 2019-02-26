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
public class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;
    
    @Override
    public String toString() {
        return matricula + "  " + marca + modelo + "  " + color + " " + tarifa + "" + disponible;
    }
    
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    public Vehiculo() {
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public double getTarifa() {
        return tarifa;
    }
    
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public static Vehiculo vehiculoAleatorio() {
        String matricula = "";
        
        Random aleatorio = new Random();
        
        for (int i = 0; i < 7; i++) {
            
            if (i < 4) {
                
                matricula += aleatorio.nextInt(10);
            } else {
                
                matricula += (char) (aleatorio.nextInt(90 - 65 + 1) + 65);
            }
        }
        String Color = "";
        
        int seleccionColor = aleatorio.nextInt(3);
        
        switch (seleccionColor) {
            case 0:
                Color = "Blanco";
                break;
            case 1:
                Color = "Negro";
                break;
            case 2:
                Color = "Azul";
                break;
            
            case 3:
                Color = "Rojo";
                break;
            
        }
        double tarifaseleccionada;
        
        tarifaseleccionada = aleatorio.nextInt(150 - 100 + 1) + 100;
        boolean disponibilidad;
        
        if (aleatorio.nextBoolean()) {
            disponibilidad = true;
        } else {
            disponibilidad = false;
        }
        
        ArrayList<String> marca = new ArrayList<>();
        marca.add("Ferrari");
        marca.add("Audi");
        marca.add("Ford");
        marca.add("BMW");
        
        ArrayList<String> modelo = new ArrayList<>();
        modelo.add("X5");
        modelo.add("A1");
        modelo.add("RSX300");
        modelo.add("TT");
        
        String marcaElegida = marca.get(aleatorio.nextInt(marca.size()));
        
        String modeloElegido = modelo.get(aleatorio.nextInt(modelo.size()));
        System.out.println("Matricula: " + matricula);
        System.out.println("Marca: " + marcaElegida);
        System.out.println("Modelo: " + modeloElegido);
        System.out.println("Color: " + Color);
        System.out.println("Tarifa: " + tarifaseleccionada);
        System.out.println("Disponibilidad: " + disponibilidad);
        Vehiculo aux = new Vehiculo(matricula, marcaElegida, modeloElegido, Color, tarifaseleccionada, disponibilidad);
        return aux;
        
    }
    
    public static void main(String[] args) {
        
        Vehiculo.vehiculoAleatorio();
        
    }
    
}
