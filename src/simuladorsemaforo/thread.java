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
public class thread implements Runnable {

    private CorSemaforo cor;
    private boolean flag;
    private boolean corMudou;

    public thread() {
        this.cor = CorSemaforo.VERMELHO;

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!flag) {
            try {
                switch (this.cor) {
                    case VERMELHO:
                        Thread.sleep((1000));
                        break;
                    case AMARELO:
                        Thread.sleep((500));
                        break;
                    case VERDE:
                        Thread.sleep((2000));
                        break;

                    default:
                        break;
                }
                this.mudarCor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mudarCor() {
        switch (this.cor) {
            case VERMELHO:
                this.cor = CorSemaforo.VERDE;
                break;

            case AMARELO:
                this.cor = CorSemaforo.VERMELHO;
                break;
            case VERDE:
                this.cor = CorSemaforo.AMARELO;
                break;
            default:
                break;
        }
        this.corMudou = true;
        notify();
    }
    
    public synchronized void esperaCorMudar() {
        while(!this.corMudou) {
            try{
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.corMudou = false;
    }
    
    public synchronized void desligarSemaforo() {
        this.flag = true;
    }
    
    public CorSemaforo getCor() {
        return cor;
    }

}
