package com.href.biz.tiz.proxy;

import java.util.List;

import com.href.biz.tiz.domain.Film;

public interface FilmProxy extends BaseProxy<Film> {

	List<Film> getFilmByStatus();
}
