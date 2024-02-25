public class TestClass {
	public static void main(String[] args) {

		//Part 1
//		LogLine log1 = Log.getInstance();
//		System.out.println(log1.hashCode());
//
//		LogLine log2 = Log.getInstance();
//		System.out.println(log2.hashCode());

		Log log1 = Log.getInstance("File_1.txt");
		Log log2 = Log.getInstance("FIle_2.txt");
		log1.addLog("YUpiii");
		log2.addLog("oubawfbawbfaweofaweowo");

	}
}
