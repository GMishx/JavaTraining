package com.siemens.service.mobile;

import com.siemens.beans.mobile.Mobile;
import com.siemens.exceptions.mobile.MobileNotFoundException;

public interface MobileService {
	boolean addMobile(Mobile mob) throws MobileNotFoundException;

	boolean deleteMobile(int mobileID) throws MobileNotFoundException;

	Mobile fetchMobileById(int mobileID) throws MobileNotFoundException;
}
