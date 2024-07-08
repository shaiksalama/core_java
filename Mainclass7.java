package approch4_programming;

public class Mainclass7 {
		public static void usage(Train t1) {
			t1.getTrainDetails();
		}
		public static void main(String[] args) {
			usage(new Train("Mumbai", "MumbaiExpress", "KaMu24", 100, 1000));
			usage(new Train("Banglore", "BangloreExpress", "KaBa24", 100,1000));
		}
	}
