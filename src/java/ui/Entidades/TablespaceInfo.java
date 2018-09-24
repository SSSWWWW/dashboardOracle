/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Entidades;

/**
 *
 * @author stefvn
 * 
 *  DA LA INFO DE TODOS LOS TABLESPACES
 * 
 */
public class TablespaceInfo {
    
    private String nombre;
    private int size;
    private int free;
    private float porfree;
    private int porused;

    public TablespaceInfo() {
    }

    public TablespaceInfo(String nombre, int size, int free, float porfree, int porused) {
        this.nombre = nombre;
        this.size = size;
        this.free = free;
        this.porfree = porfree;
        this.porused = porused;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public float getPorfree() {
        return porfree;
    }

    public void setPorfree(float porfree) {
        this.porfree = porfree;
    }

    public int getPorused() {
        return porused;
    }

    public void setPorused(int porused) {
        this.porused = porused;
    }
    
    
           
    
}
