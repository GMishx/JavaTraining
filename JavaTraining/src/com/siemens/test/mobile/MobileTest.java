package com.siemens.test.mobile;

import com.siemens.beans.mobile.Mobile;
import com.siemens.exceptions.mobile.MobileNotFoundException;
import com.siemens.service.mobile.MobileService;
import com.siemens.service.mobile.MobileServiceImpl;

public class MobileTest {

	public static void main(String[] args) {
		MobileService mob = new MobileServiceImpl();

		Mobile mobile1 = new Mobile();
		mobile1.setId(100);
		mobile1.setName("OnePlus 3T");
		mobile1.setPrice(32000.00);

		try {
			mob.addMobile(mobile1);
			mob.fetchMobileById(100);
			mob.deleteMobile(100);
		} catch (MobileNotFoundException e) {
			// System.out.println(e);
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Done!");
		}
	}

}
