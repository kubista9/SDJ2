package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import viewmodel.AuctionItemViewModel;
import viewmodel.ViewModelFactory;

import javax.swing.plaf.synth.Region;



public class AuctionItemViewController{

	private @FXML Label itemLabel;
	private @FXML Label timeLabel;
	private @FXML Label title;
	private @FXML Label currentBidLabel;
	private @FXML Label currentBidderLabel;
	private @FXML TextField bidLabel;
	private @FXML Label errorBidLabel;
	private Region root;
	private ViewHandler viewHandler;
	private AuctionItemViewModel viewModel;

	public AuctionItemViewController() {

	}

	public void init(ViewHandler viewHandler, AuctionItemViewModel viewModel, Region root) {
		this.viewHandler = viewHandler;
		this.viewModel = viewModel;
		this.root = root;
	}

	public void start(Stage primaryStage){
		this.stage = primaryStage;
	}

	public void reset(){
		;
	}

	public Region getRoot(){
		return root;
	}

	public @FXML void bidOnAuction(){

	}
}
