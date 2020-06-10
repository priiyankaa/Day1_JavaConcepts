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
public class Multithreading {

    public static void main(String[] args)
    {
        Producer producer= new Producer();
        producer.setName("producer 1");
        producer.start();
        
        Consumer consumer = new Consumer (producer);
        consumer.setName("consumer 1");
        consumer.start();
        
    }
    
}
