package viewmodel;

import model.AuctionModel;

public class ViewModelFactory {
	private AuctionModel model;

	public ViewModelFactory(AuctionModel model) {
		this.model = model;
	}

	public AuctionModel getAuctionItemViewModel() {
		return model;
	}
}
