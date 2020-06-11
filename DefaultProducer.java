package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.List;
import java.util.Queue;

public class DefaultProducer implements Producer {

	@Override
	public void run() {
		int addedAmount = getHowMany();
		int capacity = getSizeLimit();
		List<Integer> produced = getProducedList();
		Queue<Integer> q = getQueue();
		Object p = getProducerLock();
		Object c = getConsumerLock();
		synchronized(p) {
			
		
			try {
			while(q.size()==capacity)
				p.wait();
			
			for(int i = 0; i < addedAmount; i ++) {
				produced.add(i);
				q.add(produced.get(produced.size()-1));
			}		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		synchronized(c) {
			c.notify();
		}
	}
	

	

	@Override
	public List<Integer> getProducedList() {
		return DefaultMain.producedList;
	}

	@Override
	public int getHowMany() {
		return DefaultMain.howMany;
	}

	@Override
	public int getSizeLimit() {
		return DefaultMain.sizeLimit;
	}

	@Override
	public Queue<Integer> getQueue() {
		return DefaultMain.queue;
	}

	@Override
	public Object getConsumerLock() {
		return DefaultMain.consumerLock;
	}

	@Override
	public Object getProducerLock() {
		return DefaultMain.producerLock;
	}

}
