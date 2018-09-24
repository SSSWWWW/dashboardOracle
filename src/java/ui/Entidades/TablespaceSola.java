/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Entidades;

/**
 *
 * @author stefvn
 * DA LA INFO DE UN TABLESPACE INDIVIDUAL
 */
public class TablespaceSola {
    
 private String Tablaspace;
 private int MaximoMB;
  private float LibreMB;
 private float UsadoMB;
 private int porSP;
 private int DiasparaSP;
 private int DiasparaSatTotal;

    public TablespaceSola() {
    }

    public TablespaceSola(String Tablaspace, int MaximoMB, float LibreMB, float UsadoMB, int porSP, int DiasparaSP, int DiasparaSatTotal) {
        this.Tablaspace = Tablaspace;
        this.MaximoMB = MaximoMB;
        this.LibreMB = LibreMB;
        this.UsadoMB = UsadoMB;
        this.porSP = porSP;
        this.DiasparaSP = DiasparaSP;
        this.DiasparaSatTotal = DiasparaSatTotal;
    }

    public String getTablaspace() {
        return Tablaspace;
    }

    public void setTablaspace(String Tablaspace) {
        this.Tablaspace = Tablaspace;
    }

    public int getMaximoMB() {
        return MaximoMB;
    }

    public void setMaximoMB(int MaximoMB) {
        this.MaximoMB = MaximoMB;
    }

    public float getLibreMB() {
        return LibreMB;
    }

    public void setLibreMB(float LibreMB) {
        this.LibreMB = LibreMB;
    }

    public float getUsadoMB() {
        return UsadoMB;
    }

    public void setUsadoMB(float UsadoMB) {
        this.UsadoMB = UsadoMB;
    }

    public int getPorSP() {
        return porSP;
    }

    public void setPorSP(int porSP) {
        this.porSP = porSP;
    }

    public int getDiasparaSP() {
        return DiasparaSP;
    }

    public void setDiasparaSP(int DiasparaSP) {
        this.DiasparaSP = DiasparaSP;
    }

    public int getDiasparaSatTotal() {
        return DiasparaSatTotal;
    }

    public void setDiasparaSatTotal(int DiasparaSatTotal) {
        this.DiasparaSatTotal = DiasparaSatTotal;
    }

   
 
    
}
