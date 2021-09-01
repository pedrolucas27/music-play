package classes;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class ControladorPlayer {

    private Thread newThrd;
    private Play objPlay;
    private StatusControlador status;

    public ControladorPlayer(Play objPlay) {
        this.objPlay = objPlay;
        this.newThrd = new Thread(objPlay);
        status = StatusControlador.PARADO;
    }

    public void tocarMusica() {
        if (!newThrd.isAlive()) {
            newThrd.start();
            status = StatusControlador.EXECUTANDO;
        } 
    }
    
    public void continuarMusica(){
        
        if (newThrd.isAlive()) {
            objPlay.continuar();
            status = StatusControlador.EXECUTANDO;
        }
    }

    public void pausarMusica() {

        if (newThrd.isAlive()) {
            objPlay.aguardar();
            status = StatusControlador.PAUSADO;
        }
    }
    public void pararMusica() {
        
        if (newThrd.isAlive()) {
            objPlay.parar();
            status = StatusControlador.PARADO;
            newThrd = null;
        }
    }
    
    public StatusControlador getStatus(){
        return status;
    }
}