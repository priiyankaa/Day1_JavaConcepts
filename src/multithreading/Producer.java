/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.time.LocalDateTime;
import java.util.ArrayList;



/**
 *
 * @author cutie_000
 */
public class Producer extends Thread
{
    private static final int MAX_SIZE=5;
    private final ArrayList<String> messages= new ArrayList<>();

    @Override
    public void run() 
    {
        try
        {
            while(true)
            {
                produce();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
        
    }

    private synchronized void produce() throws Exception
    {
        while(messages.size()==MAX_SIZE)
        {
            System.out.println("Queue limit reached waiting for consumer");
            wait();
            System.out.println("Queue limit reached waiting for consumer");
        }
        
        String data=LocalDateTime.now().toString();
        messages.add(data);
        System.out.println("producer produced data");
        notify();
    }
    public synchronized String consume() throws Exception
    {
        notify();
        while(messages.isEmpty())
        {
            wait();
        }
        String data=messages.get(0);
        messages.remove(data);
        return data;
    }
    
    
    
    
}
