package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.List;
import java.util.Queue;

public interface Producer extends Runnable
{
	List<Integer> getProducedList();

	int getHowMany();

	int getSizeLimit();

	Queue<Integer> getQueue();

	Object getConsumerLock();

	Object getProducerLock();
}
