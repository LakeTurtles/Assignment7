package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class CustomArrayListTest {
	
	private CustomList<Integer> numberList;
	private static Integer count = 0;

	@BeforeAll
	public static void beforeClass1(){
		System.out.println("This Executes before any test cases, Count = " + count++);
	}
	
	@BeforeEach
	void instantiate_before_each_test () {
		numberList = new CustomArrayList<>();
		for (int i=0; i< 99; i++) {
			numberList.add(i+1);
//			System.out.println("\u001B[34m"+i);
		}
		System.out.println("\u001B[35m---------------");
		System.out.println("Running a test...");
	}

	@Test
	void add_at_end_of_array(){
		numberList.add(666_000_000);
		assertEquals(666_000_000, numberList.get(numberList.getSize()-1));
	}
	
	@Test
	void add_in_the_middle_of_arraylist() {
		assertNull(null);
		numberList.add(4, 36);
		numberList.add(5,44);
		numberList.add(4, 44);

		Integer recentAdd = numberList.get(4);
		Integer expected = 44;
		assertEquals(expected, recentAdd);
		assertEquals(102, numberList.getSize());

		
	}

	
	@Test
	void add_in_the_beginning_of_arraylist() {
		numberList.add(0, 99);

		assertEquals(99, numberList.get(0));
		assertEquals(100, numberList.getSize());
	}

	
	@Test
	void remove_from_beginning_of_arraylist() {
		Integer itemRemoved = numberList.remove(0);
		
		assertEquals(1, itemRemoved);
		assertEquals(98, numberList.getSize());
		assertEquals(2, numberList.get(0));
		assertEquals(99, numberList.get(numberList.getSize()-1));
	}
	
	@Test
	void remove_from_middle_of_arraylist() {
		Integer itemRemoved = numberList.remove(11);
		
		assertEquals(12, itemRemoved);
		assertEquals(98, numberList.getSize());
		assertEquals(1, numberList.get(0));
		assertEquals(99, numberList.get(numberList.getSize()-1));
	}
	
	@Test
	void add_and_remove_large_indexes() {
		for (int i=0; i<100000; i++) {
			numberList.add(i);
		}

		Integer itemRemoved = numberList.remove(50000);

		assertEquals(49901, itemRemoved);
		assertEquals(100098, numberList.getSize());
		assertEquals(1, numberList.get(0));
		int halfSize = numberList.getSize() / 2;

		for (int i = numberList.getSize()-1; i > halfSize; i--){
			Integer item = numberList.remove(i);

		}
		assertEquals(50049, numberList.getSize()-1);
		System.out.println("NumberList = " + numberList.getSize());
		System.out.println("value at end of the list is = " + numberList.get(numberList.getSize()-1));
	}
	
	@Test
	void remove_from_end_of_arraylist() {
		Integer itemRemoved = numberList.remove(19);
		
		assertEquals(20, itemRemoved);
		assertEquals(98, numberList.getSize());
		assertEquals(1, numberList.get(0));
		assertEquals(98, numberList.get(numberList.getSize()-2));
	}
	
	@Test
	void throw_exception_when_getting_out_of_bounds () {
		Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> numberList.get(15000));
		
	}
	@Test
	void throw_exception_when_removing_out_of_bounds () {
		Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> numberList.remove(1200));
		
	}
	
	@Test
	void throw_exception_when_adding_out_of_bounds ()  throws Exception{
			Assertions.assertThrows(IndexOutOfBoundsException.class,
					()-> numberList.add(1100, 66));

	}

	@AfterEach
	public void  teardown(){
		System.out.println("Count = " + count++);
	}

	@AfterAll
	public static void afterClass(){
		System.out.println("This executes after any test cases, Count = " + count++);
	}

}
