package com.href.biz.tiz.proxy;

import java.util.List;

import com.href.biz.tiz.dto.ShowOnScreenDTO;

public interface ShowOnScreenProxy extends BaseProxy<ShowOnScreenDTO> {
	
	List<ShowOnScreenDTO> getShowOnScreenByStatus(String status);
}
