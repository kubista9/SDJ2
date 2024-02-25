public class LogLevelController implements Logger {
	private String logLevel;
	private ConsoleLogger logger;

	public LogLevelController(String logLevel) {
		this.logLevel = logLevel;
		this.logger = new ConsoleLogger();
	}

	@Override
	public synchronized void log(String txt) {
		switch(logLevel){
			case "verbose":
				logger.log(txt);
			case "sparse":
				if (txt.toLowerCase().contains("error")){
					logger.log(txt);
				}
		}
	}

}
