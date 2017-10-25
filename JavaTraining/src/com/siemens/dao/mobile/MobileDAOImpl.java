package com.siemens.dao.mobile;

import com.siemens.beans.mobile.Mobile;
import com.siemens.exceptions.mobile.MobileNotFoundException;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public boolean addMobile(Mobile mob) throws MobileNotFoundException {
		System.out.println("Adding mobile " + mob.getName() + " to DataBase");
		if (mob.getId() <= 0)
			throw new MobileNotFoundException("ID cannot e <= 0");
		else
			return false;
	}

	@Override
	public boolean deleteMobile(int mobileID) throws MobileNotFoundException {
		System.out.println("Deleting mobile " + mobileID + " from DataBase");
		if (mobileID <= 0)
			throw new MobileNotFoundException("ID cannot e <= 0");
		else
			return false;
	}

	@Override
	public Mobile fetchMobileById(int mobileID) throws MobileNotFoundException {
		System.out.println("Fetching mobile " + mobileID + " from DataBase");
		return null;
	}

}
