package com.href.biz.tiz.proxy;

import java.util.List;

import com.href.biz.tiz.domain.SeatMasterOfScreen;
import com.href.biz.tiz.dto.SeatMasterOfScreenDTO;

public interface SeatMasterOfScreenProxy extends BaseProxy<SeatMasterOfScreen> {

	List<SeatMasterOfScreenDTO> getSeatMasterByScreenId(Long id);
}
