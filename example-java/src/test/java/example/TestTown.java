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
    String message;
    Town t = new Town(testValue1Name, testValue1Residents);

    // assert 1 - null
    message = "name is null";
    assertThrows(IllegalArgumentException.class, () -> new Town(null, 0), message + " (constructor)");
    assertThrows(IllegalArgumentException.class, () -> t.setName(null), message + " (set)");

    // assert 2 - empty
    message = "name is empty";
    assertThrows(IllegalArgumentException.class, () -> new Town("", 0), message + " (constructor)");
    assertThrows(IllegalArgumentException.class, () -> t.setName(""), message + " (set)");

    // assert 3 - only white spaces
    message = "name contains only spaces";
    assertThrows(IllegalArgumentException.class, () -> new Town("  ", 0), message + " (constructor)");
    assertThrows(IllegalArgumentException.class, () -> t.setName("  "), message + " (set)");
  }

  @DisplayName("T02: Add correct town residents")
  @Test
  void test2_TownResidents() {
    String message = "residents is less 0";

    // assert 1 - less 0 -> IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Town(testValue1Name,
        -1), message + " (constructor)");
    assertThrows(IllegalArgumentException.class, () -> {
      Town t = new Town(testValue1Name, testValue1Residents);
      t.setResidents(-2);
    }, message + " (set)");

    /*
     * // assert 1 - less 0 -> 0
     * Town t = new Town(testValue1Name, -1);
     * assertFalse(t.getResidents() < 0, message + " (constructor)");
     * t = new Town(testValue1Name, testValue1Residents);
     * t.setResidents(-2);
     * assertFalse(t.getResidents() < 0, message + " (set)");
     */
  }

  @DisplayName("T03: Get correct town name")
  @Test
  void test3_getNameFunction() {
    // assert 1 - constructor equals get
    Town t = new Town(testValue1Name, testValue1Residents);
    assertEquals(testValue1Residents, t.getResidents(), "Output not match input");

    // assert 2 - set equals get
    t.setResidents(testValue2Residents);
    assertEquals(testValue2Residents, t.getResidents(), "Output not match input");
  }

  @DisplayName("T04: Get correct town residents")
  @Test
  void test4_getResidentsFunction() {
    // assert 1 - constructor equals get
    Town t = new Town(testValue1Name, testValue1Residents);
    assertEquals(testValue1Name, t.getName(), "Output not match input");

    // assert 2 - set equals get
    t.setName(testValue2Name);
    assertEquals(testValue2Name, t.getName(), "Output not match input");
  }

  @DisplayName("T05: Get correct town information")
  @Test
  void test5_getInfoFunction() {
    // assert 1 - correct info string
    Town t = new Town(testValue1Name, testValue1Residents);
    String template = "The town " + t.getName() + " has " + t.getResidents() + " residents.";
    assertEquals(template, t.getInfo(), "Output not match template");
  }

  @DisplayName("T06: Get correct town as string")
  @Test
  void test6_toStringFunction() {
    // assert 1 - correct toString
    Town t = new Town(testValue1Name, testValue1Residents);
    String template = "Town('" + testValue1Name + "', " + testValue1Residents + ")";
    assertEquals(template, t.toString(), "Output not match template");
  }

}
