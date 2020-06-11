package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.List;
import java.util.Queue;

public class DefaultConsumer implements Consumer {

	@Override
	public void run() {
		int addedAmount = getHowMany();
		List<Integer> consumed = getConsumedList();
		Queue<Integer> q = getQueue();
		Object p = getProducerLock();
		Object c = getConsumerLock();
		synchronized (c) {
			try {

				while (q.size() == 0) {

					c.wait();

				}

				for (int i = 0; i < addedAmount; i++) {
					System.out.println("Consuming...");
					int value = q.remove();
					consumed.add(value);
					System.out.println(q);
					if (q.size() == 0) {
						System.out.println("Consumed! Now, let the producer do some work");
						break;
					}
				}

				synchronized (p) {
					p.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Integer> getConsumedList() {
		return DefaultMain.consumedList;
	}

	@Override
	public int getHowMany() {
		return DefaultMain.howMany;
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
