package approch4_programming;

public class Train {
	String trainName;
	static String boardingPoint = "Kachiguda";
	String trainNumber;
	String destinationPoint;
	int speed;
	double distance;

	// method for initializing variables

	public Train(String destinationPoint, String trainName, String trainNumber, int speed, double distance) {
		// System.out.println(trainNumber);
		/*
		 * //initializing destination point
		 * 
		 * if(checkDPoint(destinationPoint)) { this.destinationPoint=destinationPoint; }
		 * else System.err.println("invalid destinatioinPoint");
		 * 
		 * //initializing trainNumber
		 */

		if (checkTrainNumber(trainNumber, destinationPoint) == 4) {
			this.trainNumber = trainNumber;
		} else
			System.err.println("invalid train number");

		// initializing destination point

		if (checkDPoint(destinationPoint)) {
			this.destinationPoint = destinationPoint;
		} else
			System.err.println("invalid destinatioinPoint");

		// initializing trainName

		if (verifyTrainName(trainName, destinationPoint)) {
			this.trainName = trainName;
		} else
			System.err.println("invalid train name");

		// Initializing speed

		if (checkSpeed(speed)) {
			this.speed = speed;
		} else
			System.err.println("invalid speed");

		// initializing distance

		if (verifyDistance(distance)) {
			this.distance = distance;
		} else
			System.err.println("invalid distance");
	}

	// verifying destinationPoint

	private boolean checkDPoint(String destinationPoint) {
		if (destinationPoint.equalsIgnoreCase("Mumbai") || destinationPoint.equalsIgnoreCase("pune")
				|| destinationPoint.equalsIgnoreCase("Banglore")) {
			return true;
		}

		return false;
	}

	// Verifying trainNumber

	private int checkTrainNumber(String trainNumber, String destinationPoint) {
		int b = 0;
		for (int i = 0; i < 2; i++) {
			// System.out.println(trainNumber.charAt(i)+","+boardingPoint.charAt(i));
			if (trainNumber.charAt(i) == boardingPoint.charAt(i)) {
				// System.out.println(b);
				b++;
			}
			if (trainNumber.charAt(i + 2) == destinationPoint.charAt(i)) {
				// System.out.println(b);
				b++;
			}
		}

		return b;
	}

	// Verifying trainName

	private boolean verifyTrainName(String trainName, String destinationPoint) {
		if (trainName.equalsIgnoreCase(destinationPoint + "express")) {
			return true;
		}
		return false;
	}

	// Verifying speed

	private boolean checkSpeed(int speed) {
		if (speed >= 60 && speed <= 120) {
			return true;
		}
		return false;
	}

	// Verifying distance

	private boolean verifyDistance(double distance) {
		if (distance >= 600 && distance <= 1000) {
			return true;
		}
		return false;
	}

	public void getTrainDetails() {
		System.out.println("Train boarding Point: " + boardingPoint);
		System.out.println("Train destinantion Point: " + destinationPoint);
		System.out.println("Train Number: " + trainNumber);

		System.out.println("Train Name: " + trainName);
		System.out.println("Train is travelling with: " + speed + " km/h");
		System.out.println("Train travels: " + distance + " kms");
		double time = distance / speed;
		System.out.println("Train takes: " + time + " hrs to travel");

	}

}
