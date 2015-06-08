package com.href.biz.tiz.proxy;

import java.util.List;

import com.href.biz.tiz.domain.Screen;

public interface ScreenProxy extends BaseProxy<Screen> {
	
	List<Screen> getScreensByCinemaId(Long id);

}
