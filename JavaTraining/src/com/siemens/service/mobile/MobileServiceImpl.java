package com.siemens.service.mobile;

import com.siemens.beans.mobile.Mobile;
import com.siemens.dao.mobile.MobileDAO;
import com.siemens.dao.mobile.MobileDAOImpl;
import com.siemens.exceptions.mobile.MobileNotFoundException;

public class MobileServiceImpl implements MobileService {

	MobileDAO mobileDao;

	public MobileServiceImpl() {
		mobileDao = new MobileDAOImpl();
	}

	@Override
	public boolean addMobile(Mobile mob) throws MobileNotFoundException {
		System.out.println("Trying to add " + mob.getName());
		return mobileDao.addMobile(mob);
	}

	@Override
	public boolean deleteMobile(int mobileID) throws MobileNotFoundException {
		System.out.println("Trying to delete " + mobileID);
		return mobileDao.deleteMobile(mobileID);
	}

	@Override
	public Mobile fetchMobileById(int mobileID) throws MobileNotFoundException {
		System.out.println("Trying to fetch " + mobileID);
		return mobileDao.fetchMobileById(mobileID);
	}

}
