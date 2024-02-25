import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//SINGLETON
//
//public class Log {
//	private ArrayList<LogLine> logLines;
//	private static Log instance;   //Singleton
//	private static Object lock = new Object();
//
//	private Log(){
//		this.logLines = new ArrayList<>();
//	}
//
//	public void addLog(String text){
//		LogLine newLogLine = new LogLine(text);
//		logLines.add(newLogLine);
//		addToFile(newLogLine);
//		System.out.println("Log line added: " + newLogLine);
//	}
//
//	public ArrayList<LogLine> getALl(){
//		return logLines;
//	}
//
//	public String toString(){
//		String s = "";
//		for (int i = 0; i < logLines.size(); i++){
//			LogLine logLineWithIndex = logLines.get(i);
//			s += "Log line with index" + i + "is" + logLineWithIndex + "\n";
//		}
//		return s;
//	}
//
//	private void addToFile(LogLine log){
//		if (log == null){
//			return;
//		}
//		BufferedWriter out = null;
//		try{
//			String filename= "Log-" + log.getDateTime().getSortableDate()+ ".txt";
//			out = new BufferedWriter(new FileWriter(filename, true));
//			out.write(log + "\n");
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//			try{out.close();
//			}
//			catch (Exception e){
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static Log getInstance(){   //Singleton
//		if (instance == null){
//			synchronized(lock){
//				if (instance == null){
//					instance = new Log();
//				}
//			}
//		}
//		return instance;
//	}
//}


//MULTITON

public class Log {
	private static Map <String, Log> map = new HashMap<>();
	private ArrayList<LogLine> logLines;
	private static Log instance;
	private static Object lock = new Object();
	private String filename;

	private Log(String filename){
		this.logLines = new ArrayList<>();
		this.filename = filename;
	}
	public void addLog(String text){
		LogLine newLogLine = new LogLine(text);
		logLines.add(newLogLine);
		addToFile(newLogLine);
		System.out.println("Log line added: " + newLogLine);
	}

	public ArrayList<LogLine> getALl(){
		return logLines;
	}

	public String toString(){
		String s = "";
		for (int i = 0; i < logLines.size(); i++){
			LogLine logLineWithIndex = logLines.get(i);
			s += "Log line with index" + i + "is" + logLineWithIndex + "\n";
		}
		return s;
	}

	private void addToFile(LogLine log){
		if (log == null){
			return;
		}
		BufferedWriter out = null;
		try{
			String filename = "Log-" + log.getDateTime().getSortableDate()+ ".txt";
			out = new BufferedWriter(new FileWriter(filename, true));
			out.write(log + "\n");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{out.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	public static Log getInstance(String key){
		Log log = map.get(key);
		if (log == null){
			synchronized (lock){
				log = map.get(key);
				if (log == null){
					log = new Log(key);
					map.put(key, log);
				}
			}
		}
		return log;
	}
}
