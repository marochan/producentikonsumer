package pl.edu.agh.automatedgrader.jtp2.lab2.interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DefaultMain implements Main {
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static List<Producer> listOfProducers = new ArrayList<Producer>();
	public static List<Consumer> listOfConsumers = new ArrayList<Consumer>();
	public static List<Integer> consumedList = new ArrayList<Integer>();
	public static List<Integer> producedList = new ArrayList<Integer>();
	public static int howMany;
	public static int sizeLimit;
	public static int consumerCount;
	public static int producerCount;
	static Object consumerLock = new Object();
	static Object producerLock = new Object();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		howMany = 2;

		sizeLimit = 3;
		DefaultMain dm = new DefaultMain();

		producerCount = 2;
		consumerCount = 2;

		dm.produceConsume(howMany, sizeLimit, consumerCount, producerCount);
	}

	@Override
	public void produceConsume(int howMany, int sizeLimit, int consumerCount, int producerCount) {

		for (int i = 0, j = 0; i < producerCount && j < consumerCount; i++, j++) {

			DefaultProducer pro = new DefaultProducer();
			DefaultConsumer con = new DefaultConsumer();
			Thread t = new Thread(pro);
			Thread t1 = new Thread(con);
			try {
				t.start();
				t1.start();
				t.join();
				t1.join();
				listOfConsumers.add(con);
				listOfProducers.add(pro);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(listOfConsumers.size());
		System.out.println(listOfProducers.size());
	}

	@Override
	public List<Consumer> getConsumers() {
		return listOfConsumers;
	}

	@Override
	public List<Producer> getProducers() {
		return listOfProducers;
	}

	@Override
	public Queue<Integer> getQueue() {

		return queue;
	}

}
