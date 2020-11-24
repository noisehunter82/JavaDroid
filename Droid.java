public class Droid {

  String name;
  int batteryLevel;

  public Droid(String name) {
    this.name = name;
    this.batteryLevel = 100;
  }

  public String toString() {
    return "Hello, I'm the droid: " + this.name + "\n";
  }

  public void performTask(String task) {
    System.out.println("Droid " + this.name + " is performing task: " + task + "\n");
    this.batteryLevel -= 10;
  }

  public void stateBatteryLevel() {
    System.out.println("Droid " + this.name + "'s battery level is: " + this.batteryLevel + "\n");
  }

  public void shareEnergy(Droid otherDroid, int energyAmount) {
    // Check battery level. Droid can't transfer more than 50% of its current
    // battery level.
    if (energyAmount <= this.batteryLevel / 2) {
      this.batteryLevel -= energyAmount;
      otherDroid.batteryLevel += energyAmount;
      System.out.println("Energy transfer complete\n");
      stateBatteryLevel();
      otherDroid.stateBatteryLevel();
    } else {
      System.out.println(this.name + "'s battery level is too low! Try transferring smaller amount of energy\n");
    }
  }

  public static void main(String[] args) {

    Droid codey = new Droid("Codey");
    System.out.println(codey);
    codey.performTask("skating");
    codey.stateBatteryLevel();

    Droid sigma = new Droid("Sigma");
    System.out.println(sigma);
    sigma.performTask("dancing");
    sigma.stateBatteryLevel();

    sigma.shareEnergy(codey, 50); // This request will be rejected
    sigma.shareEnergy(codey, 45); // This request will be accepted
    codey.shareEnergy(sigma, 70); // This request will be rejected
    codey.shareEnergy(sigma, 45); // This request will be accepted
  }
}
