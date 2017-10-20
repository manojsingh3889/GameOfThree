package com.takeaway.broker.services;

import com.takeaway.requestbean.ServiceRequest;
import com.takeaway.responsebean.ServiceResponse;

public interface Service<T extends ServiceRequest,K extends ServiceResponse> {
	K execute(T t);
}
