package com.maimaida.service;

import com.maimaida.common.pojo.EasyUIDataGridResult;
import com.maimaida.po.TbItem;

public interface ItemService {
	
	TbItem getItemById(long id);
	
	EasyUIDataGridResult getItemList(int page, int rows);

}
