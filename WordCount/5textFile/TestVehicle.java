package P72_16;

class TestVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Vehicle vehicle=new Vehicle("Lalala",1f,2f);
      System.out.println(vehicle.getPrice());
      vehicle.SetUpPrice(3f);
      System.out.println(vehicle.getPrice());
      vehicle.SetDownPrice(2f);
      System.out.println(vehicle.getPrice());
	}

}
