/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author cutie_000
 */
public class Consumer extends Thread
{
    private Producer producer;
    
    public Consumer(Producer producer)
    {
        this.producer=producer;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                String data=producer.consume();
                System.out.print("Consumed by :" + Thread.currentThread().getName()+ "data" + data);
                Thread.sleep(800);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
}
