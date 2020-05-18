/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorsemaforo;

/**
 *
 * @author joaov
 */
public class SimuladorSemaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        thread semaforo = new thread();
        
        for (int i=0; i < 11; i++)  {
            System.out.println(semaforo.getCor());
            semaforo.esperaCorMudar();
        }
        
        semaforo.desligarSemaforo();
    }    
}
