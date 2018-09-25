package me.cxy.tailer.boss.impl;

import com.alibaba.fastjson.JSON;

import me.cxy.tailer.boss.Boss;
import me.cxy.tailer.tree.NoteBook;

public class SimpleBoss implements Boss {

	@Override
	public void handle(NoteBook noteBook) {
		System.out.println(noteBook.getTarget() + "---" +JSON.toJSONString(noteBook.getRoot()));
	}

}
