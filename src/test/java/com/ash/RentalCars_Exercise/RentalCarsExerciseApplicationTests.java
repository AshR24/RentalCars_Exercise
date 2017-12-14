package com.ash.RentalCars_Exercise;

import com.ash.RentalCars_Exercise.objects.Vehicle;
import com.ash.RentalCars_Exercise.tasks.AscendingPrice;
import com.ash.RentalCars_Exercise.tasks.ITask;
import com.ash.RentalCars_Exercise.tasks.TaskResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalCarsExerciseApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkAscendingPrice()
	{
		ArrayList<Vehicle> testVehicles = new ArrayList<>();
		testVehicles.add(new Vehicle("car1", 25.0));
		testVehicles.add(new Vehicle("car2", 50.0));
		testVehicles.add(new Vehicle("car3", 25.43));
		testVehicles.add(new Vehicle("car4", 24.9999999999999999999999999999999999));

		ITask taskToTest = new AscendingPrice();
		taskToTest.loadData(testVehicles);
		taskToTest.start();

		ArrayList<TaskResult> sortedList = taskToTest.getResults();


		Assert.assertTrue(sortedList.get(0).toString().contains("car1"));
		Assert.assertTrue(sortedList.get(1).toString().contains("car4"));
		Assert.assertTrue(sortedList.get(2).toString().contains("car3"));
		Assert.assertTrue(sortedList.get(3).toString().contains("car2"));
	}

}
