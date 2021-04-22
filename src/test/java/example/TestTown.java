package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


class TestTown {

	static String testValue1Name, testValue2Name;
	static int testValue1Residents, testValue2Residents;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testValue1Name = "Dresden";
		testValue1Residents = 556780;
		testValue2Name = "Leipzig";
		testValue2Residents = 593145;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("T01: Add correct town name")
	@Test
	void test1_TownName() {
		// assert 1 - null pointer
		assertThrows(
				java.lang.RuntimeException.class,
				() -> new Town(null, 0),
				"Expected a RuntimeException (Name is null) - but it did not come.");

		// assert 2 - empty
		assertThrows(
				java.lang.RuntimeException.class,
				() -> new Town("", 0),
				"Expected a RuntimeException (Name is empty) - but it did not come.");

		// assert 3 - only white spaces
		assertThrows(
				java.lang.RuntimeException.class,
				() -> new Town("  ", 0),
				"Expected a RuntimeException (Name contains only white spaces) - but it did not come.");
	}

	@DisplayName("T02: Add correct town residents")
	@Test
	void test2_TownResidents() {
		Town t = new Town(testValue1Name, -1);
		assertTrue(t.getResidents() == 0, "Residents less than 0");
	}

	@DisplayName("T03: Get correct town name")
	@Test
	void test3_getNameFunction() {
		// assert 1
		Town t = new Town(testValue1Name, testValue1Residents);
		assertEquals(testValue1Name, t.getName(), "Output not match input");
		// assert 2
		t.setName(testValue2Name);
		assertEquals(testValue2Name, t.getName(), "Output not match input");
	}

	@DisplayName("T04: Get correct town residents")
	@Test
	void test4_getResidentsFunction() {
		// assert 1
		Town t = new Town(testValue1Name, testValue1Residents);
		assertEquals(testValue1Residents, t.getResidents(), "Output not match input");
		// assert 2
		t.setResidents(testValue2Residents);
		assertEquals(testValue2Residents, t.getResidents(), "Output not match input");
	}

	@DisplayName("T05: Get correct town as string")
	@Test
	void test5_toStringFunction() {
		Town t = new Town(testValue1Name, testValue1Residents);
		String testValue = "Town [name=" + testValue1Name + ", residents=" + testValue1Residents + "]";
		assertEquals(testValue, t.toString(), "Output not match template");
	}

}
