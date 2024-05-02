package example;

/**
 * Represents a town with name and number of residents.
 */
public class Town {

  /** The name of the town. */
  private String name;

  /** The number of residents in the town. */
  private int residents;

  public Town(String name, int residents) {
    this.setName(name);
    this.setResidents(residents);
  }

  public String getName() {
    return this.name;
  }

  public int getResidents() {
    return this.residents;
  }

  public void setName(String name) {
    if (name == null || name.isBlank())
      throw new IllegalArgumentException("Name cannot be null, empty or contain only white spaces.");
    this.name = name;
  }

  public void setResidents(int residents) {
    this.residents = residents;
  }

  /** Returns the summarized information of the town. */
  public String getInfo() {
    return "The town " + this.name + " has " + this.residents + " residents.";
  }

  @Override
  /** Returns a string representation of the object. */
  public String toString() {
    return "Town('" + name + "', " + residents + ")";
  }

}
