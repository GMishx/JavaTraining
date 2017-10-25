package com.siemens.dao.mobile;

import com.siemens.beans.mobile.Mobile;
import com.siemens.exceptions.mobile.MobileNotFoundException;

public interface MobileDAO {
	boolean addMobile(Mobile mob) throws MobileNotFoundException;

	boolean deleteMobile(int mobileID) throws MobileNotFoundException;

	Mobile fetchMobileById(int mobileID) throws MobileNotFoundException;
}
