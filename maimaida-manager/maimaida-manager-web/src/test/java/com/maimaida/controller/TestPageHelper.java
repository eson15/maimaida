package com.maimaida.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maimaida.mapper.TbItemMapper;
import com.maimaida.po.TbItem;
import com.maimaida.po.TbItemExample;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		// 创建一个spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
		// 从spring容器中获取mapper代理对象
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		// 执行查询并分页
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(2, 10);
		List<TbItem> list = mapper.selectByExample(example);
		// 取商品列表
		for(TbItem item : list) {
			System.out.println(item.getTitle());
		}
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品信息：" + total);
	}
}
