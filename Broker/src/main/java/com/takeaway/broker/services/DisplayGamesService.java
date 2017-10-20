package com.takeaway.broker.services;

import com.takeaway.broker.core.Inventory;
import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.responsebean.DisplayResponse;

public class DisplayGamesService implements Service<DisplayRequest, DisplayResponse> {

	@Override
	public DisplayResponse execute(DisplayRequest t) {
		return new DisplayResponse(Inventory.display());
	}

}
