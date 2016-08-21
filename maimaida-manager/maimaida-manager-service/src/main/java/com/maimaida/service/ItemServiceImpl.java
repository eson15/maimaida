package com.maimaida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maimaida.mapper.TbItemMapper;
import com.maimaida.po.TbItem;
import com.maimaida.po.TbItemExample;

/**
 * 商品管理Service
 * @author Ni Shengwu
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
//		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> itemList = itemMapper.selectByExample(example);
		if(itemList != null && itemList.size() > 0) {
			TbItem item = itemList.get(0);
			return item;
		}
		return null;
	}

}
