package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.List;
import java.util.Queue;

public interface Main
{
	//howMany means how many elements should be produced by each producer
	//sizeLimit is the maximal size of a queue
	void produceConsume(int howMany, int sizeLimit, int consumerCount, int producerCount);

	List<Consumer> getConsumers();

	List<Producer> getProducers();

	Queue<Integer> getQueue();

}
