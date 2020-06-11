package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.List;
import java.util.Queue;

public interface Consumer extends Runnable
{
	List<Integer> getConsumedList();

	int getHowMany();

	Queue<Integer> getQueue();

	Object getConsumerLock();

	Object getProducerLock();
}
