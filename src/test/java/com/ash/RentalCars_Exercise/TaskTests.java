package com.ash.RentalCars_Exercise;

import com.ash.RentalCars_Exercise.objects.Supplier;
import com.ash.RentalCars_Exercise.objects.Vehicle;
import com.ash.RentalCars_Exercise.parsers.SippLoader;
import com.ash.RentalCars_Exercise.tasks.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TaskTests
{
	private ArrayList<Vehicle> testVehicles = new ArrayList<>();

	public TaskTests()
	{
		SippLoader sippLoader = SippLoader.getInstance();

		Vehicle v1 = new Vehicle("car1", 25.0);
		v1.setSipp(sippLoader.findSipp("CXMR"));
		v1.setSupplier(new Supplier("supplier1", 2.0));
		testVehicles.add(v1);

		Vehicle v2 = new Vehicle("car2", 50.0);
		v2.setSipp(sippLoader.findSipp("LCMN"));
		v2.setSupplier(new Supplier("supplier2", 3.0));
		testVehicles.add(v2);

		Vehicle v3 = new Vehicle("car3", 25.43);
		v3.setSipp(sippLoader.findSipp("CBAR"));
		v3.setSupplier(new Supplier("supplier3", 5.0));
		testVehicles.add(v3);

		Vehicle v4 = new Vehicle("car4", 24.999999999999);
		v4.setSipp(SippLoader.getInstance().findSipp("CFAR"));
		v4.setSupplier(new Supplier("supplier3", 5.6));
		testVehicles.add(v4);

		Vehicle v5 = new Vehicle("car5", 5000.0);
		v5.setSipp(SippLoader.getInstance().findSipp("CXMN"));
		v5.setSupplier(new Supplier("supplier3", 9.2));
		testVehicles.add(v5);
	}

	@Test
	public void checkAscendingPrice()
	{
		ITask taskToTest = new AscendingPrice();
		taskToTest.loadData(testVehicles);
		taskToTest.start();

		ArrayList<TaskResult> sortedList = taskToTest.getResults();

		System.out.println(taskToTest.getReadableResults());

		Assert.assertTrue(sortedList.get(0).toString().contains("car4"));
		Assert.assertTrue(sortedList.get(1).toString().contains("car1"));
		Assert.assertTrue(sortedList.get(2).toString().contains("car3"));
		Assert.assertTrue(sortedList.get(3).toString().contains("car2"));
		Assert.assertTrue(sortedList.get(4).toString().contains("car5"));
	}

	@Test
	public void checkCalculateSpecification()
	{
		ITask taskToTest = new CalculateSpecification();
		taskToTest.loadData(testVehicles);
		taskToTest.start();

		ArrayList<TaskResult> sortedList = taskToTest.getResults();

		System.out.println(taskToTest.getReadableResults());

		Assert.assertTrue(sortedList.get(0).toString().contains("Compact Special"));
		Assert.assertTrue(sortedList.get(1).toString().contains("Luxury"));
		Assert.assertTrue(sortedList.get(2).toString().contains("Compact"));
		Assert.assertTrue(sortedList.get(3).toString().contains("Compact SUV"));
		Assert.assertTrue(sortedList.get(4).toString().contains("Compact Special"));
	}

	@Test
	public void checkHighestRatedSupplierByCarType()
	{
		ITask taskToTest = new HighestRatedSupplierByCarType();
		taskToTest.loadData(testVehicles);
		taskToTest.start();

		ArrayList<TaskResult> sortedList = taskToTest.getResults();

		System.out.println(taskToTest.getReadableResults());

		Assert.assertTrue(sortedList.get(0).toString().contains("9.2"));
		Assert.assertTrue(sortedList.get(1).toString().contains("5.6"));
		Assert.assertTrue(sortedList.get(2).toString().contains("5.0"));
		Assert.assertTrue(sortedList.get(3).toString().contains("3.0"));

		Assert.assertTrue(sortedList.size() == 4);
	}

	@Test
	public void checkVehicleScores()
	{
		ITask taskToTest = new VehicleScores();
		taskToTest.loadData(testVehicles);
		taskToTest.start();

		ArrayList<TaskResult> sortedList = taskToTest.getResults();

		System.out.println(taskToTest.getReadableResults());

		Assert.assertTrue(sortedList.get(0).toString().contains("12.6"));
		Assert.assertTrue(sortedList.get(1).toString().contains("12.0"));
		Assert.assertTrue(sortedList.get(2).toString().contains("10.2"));
		Assert.assertTrue(sortedList.get(3).toString().contains("5.0"));
		Assert.assertTrue(sortedList.get(4).toString().contains("4.0"));
	}
}
