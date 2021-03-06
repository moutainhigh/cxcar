package com.enation.app.shop.component.search.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.enation.app.shop.core.model.Attribute;
import com.enation.app.shop.core.plugin.search.IGoodsDataFilter;
import com.enation.app.shop.core.service.IGoodsTypeManager;
import com.enation.framework.plugin.AutoRegisterPlugin;

/**
 * 商品属性数据过滤器
 * @author kingapex
 *
 */
@Component
public class GoodsPropertyDataFilter extends AutoRegisterPlugin implements
		IGoodsDataFilter {

	private IGoodsTypeManager goodsTypeManager;
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void filter(List<Map>  goodsList)   {
		
		for(Map goods:goodsList){
			if(goods==null) continue;
			if(goods.get("type_id")==null){ continue;}
			Map propMap = new HashMap();
			List<Attribute> attrList =goodsTypeManager.getAttrListByTypeId((Integer)goods.get("type_id"));
		//	//System.out.println(" goodsid "+ goods.get("goods_id")+"----------------------");
			int i=1;
			for(Attribute attr: attrList){
				String value =(String)goods.get("p"+i);
			//	//System.out.println(i+"--"+value);
				attr.setValue(value);
				propMap.put("p"+i,  attr.getValStr());
				i++;
			}
			
			goods.put("propMap", propMap);
		}
	}

	
	public String getAuthor() {
		
		return "kingapex";
	}

	
	public String getId() {
		
		return "goodsPropertyDataFilter";
	}

	
	public String getName() {
		
		return "商品属性数据过滤器";
	}

	
	public String getType() {
		
		return "searchFilter";
	}

	
	public String getVersion() {
		
		return "1.0";
	}


	public IGoodsTypeManager getGoodsTypeManager() {
		return goodsTypeManager;
	}


	public void setGoodsTypeManager(IGoodsTypeManager goodsTypeManager) {
		this.goodsTypeManager = goodsTypeManager;
	}


	
	
}
