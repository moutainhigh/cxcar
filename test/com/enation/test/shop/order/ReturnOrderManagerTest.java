package com.enation.test.shop.order;

import org.junit.Before;
import org.junit.Test;

import com.enation.app.shop.component.orderreturns.service.IReturnsOrderManager;
import com.enation.eop.resource.model.EopSite;
import com.enation.eop.sdk.context.EopContext;
import com.enation.framework.database.Page;
import com.enation.framework.test.SpringTestSupport;

public class ReturnOrderManagerTest extends SpringTestSupport {
	
	private IReturnsOrderManager returnsOrderManager;
	
	@Before
	public void mock(){
		returnsOrderManager = SpringTestSupport.getBean("returnsOrderManager");
		EopSite site = new EopSite();
		site.setUserid(2);
		site.setId(2);
		EopContext context = new EopContext();
		context.setCurrentSite(site);
		EopContext.setContext(context);
	}
	
	@Test
	public void listAllTest(){
		Page page = returnsOrderManager.listAll(1,	15);
		long total = page.getTotalCount();
		//System.out.println(total);
	}

}
