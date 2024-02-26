package mediatorServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;

public class ChatClientHandler implements Runnable, PropertyChangeListener {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean running;
	private Gson gson;
	private Model model;

	public ChatClientHandler(Socket socket, Model model) throws IOException {
		this.socket = socket;
		this.model = model;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE)
				.registerTypeHierarchyAdapter(byte[].class, new GsonByteArrayToBase64())
				.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime());
		gson = builder.create();
		running = true;
	}

	public void close() throws IOException{
		running = false;
		socket.close();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("Event name: " + event.getPropertyName());
		System.out.println("First value: " + event.getOldValue().toString());
		System.out.println("Second value: " + event.getNewValue().toString());
	}

	@Override
	public void run() {
		System.out.println("ChatClientHandler is running....");

		while (running){
			String errorMessage = "";

			try {
				String requestJson = in.readLine();
				System.out.println(requestJson);
				//USERNAME
				if (gson.fromJson(requestJson, Map.class).get("type").equals("USERNAME")) {
					try {
						RequestPackage requestPackage1 = gson.fromJson(requestJson, RequestPackage.class);
						model.logIn(requestPackage1.getText());
						RequestPackage reply1 = new RequestPackage("OK","");
						String replyJson = gson.toJson(reply1);
						out.println(replyJson);
					}
					catch (Exception e){
						System.out.println(e.getMessage());

						RequestPackage reply1 = new RequestPackage("ERROR",e.toString());
						String replyJson = gson.toJson(reply1);
						out.println(replyJson);
						System.out.println(e);
					}
				}

				//POST
				else if (gson.fromJson(requestJson, Map.class).get("type").equals("POST")) {
					try {
						System.out.println();
						MessagePackage requestPackage2 = gson.fromJson(requestJson, MessagePackage.class);
						Message message2 = requestPackage2.getMessage();

						model.addMessage(message2, socket.getInetAddress().toString());
						RequestPackage reply2 = new RequestPackage("OK","");
						MessagePackage reply2and5 = new MessagePackage("BROADCAST", message2);
						String replyJson = gson.toJson(reply2and5);
						out.println(replyJson);
					}

					catch (Exception e){
						System.out.println(e.getMessage());
						RequestPackage reply2 = new RequestPackage("ERROR",e.toString());
						String replyJson = gson.toJson(reply2);
						out.println(replyJson);
						System.out.println(e);
					}
				}

				//EXIT
				else if (gson.fromJson(requestJson, Map.class).get("type").equals("EXIT")){
					try {
						running = false;
						socket.close();
					}
					catch (IOException e){
						System.out.println(e.getMessage());
					}
				}
			}

			catch (IOException e) {
				System.out.println(e.getMessage());

				throw new RuntimeException(e);

			}
		}
	}
}
