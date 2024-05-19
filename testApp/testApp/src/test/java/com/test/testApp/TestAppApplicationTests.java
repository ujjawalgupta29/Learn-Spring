package com.test.testApp;


import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class TestAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
			throws ClientProtocolException, IOException {

		String url = "http://localhost:8080/getAllUsers";

		// Number of concurrent calls
		int concurrentCalls = 200;

		// Create a thread pool
		ExecutorService executor = Executors.newFixedThreadPool(concurrentCalls);

		// List to hold the results
		List<Future<Long>> results = new ArrayList<>();

		// Perform concurrent calls
		for (int i = 0; i < concurrentCalls; i++) {
			Callable<Long> callableTask = () -> {
				long startTime = System.currentTimeMillis();

				Random random = new Random();
				int sleepTime = random.nextInt(2000) + 2000; // 1000-2000 milliseconds (2-3 seconds)
				Thread.sleep(sleepTime);

				// Make HTTP request
				HttpGet request = new HttpGet(url);
				CloseableHttpClient client = HttpClients.createDefault();
				try {
					client.execute(request, new BasicHttpClientResponseHandler());
//					System.out.println(response);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					client.close(); // Close the HttpClient to release connections
				}
				long endTime = System.currentTimeMillis();
				return endTime - startTime;
			};
			// Submit task to the executor
			Future<Long> result = executor.submit(callableTask);
			results.add(result);
		}

		// Shutdown the executor to prevent new tasks
		executor.shutdown();

		// Wait for all tasks to complete and collect timings
		long totalExecutionTime = 0;
		for (Future<Long> result : results) {
			try {
				long executionTime = result.get();
				totalExecutionTime += executionTime;
				System.out.println("Execution time: " + executionTime + " ms");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		// Calculate average execution time
		double averageExecutionTime = (double) totalExecutionTime / concurrentCalls;
		System.out.println("Average execution time: " + averageExecutionTime + " ms");
	}

}
