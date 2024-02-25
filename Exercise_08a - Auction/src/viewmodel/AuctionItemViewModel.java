package viewmodel;

import javafx.beans.property.StringProperty;
import model.AuctionModel;
import view.AuctionItemViewController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AuctionItemViewModel implements PropertyChangeListener {
	private StringProperty item;
	private StringProperty time;
	private StringProperty bid;
	private StringProperty bidder;
	private StringProperty currentBid;
	private StringProperty currentBidder;
	private StringProperty error;
	private StringProperty end;
	private StringProperty currentBidTitle;
	private AuctionModel model;

	public AuctionItemViewModel(AuctionModel model) {
		this.model = model;
	}

	public void clear(){
		this.item = null;
		this.time = null;
		this.bid = null;
		this.bidder = null;
		this.currentBid = null;
		this.currentBidder = null;
		this.error = null;
		this.end = null;
		this.currentBidTitle = null;
	}

	public void bid(){
		this.bid = bid;
	}

	public StringProperty getItemProperty(){
		return item;
	}

	public StringProperty getTimeProperty() {
		return time;
	}

	public StringProperty getBidProperty() {
		return bid;
	}

	public StringProperty getBidderProperty() {
		return bidder;
	}

	public StringProperty getCurrentBidProperty() {
		return currentBid;
	}

	public StringProperty getCurrentBidderProperty() {
		return currentBidder;
	}

	public StringProperty getErrorProperty() {
		return error;
	}

	public StringProperty getEndProperty() {
		return end;
	}

	public StringProperty getCurrentBidTitleProperty() {
		return currentBidTitle;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}
}
