package me.cxy.tailer.deliver.impl;

import com.alibaba.fastjson.JSON;

import me.cxy.tailer.deliver.Deliver;
import me.cxy.tailer.tree.NoteBook;

public class SimpleDeliver implements Deliver {

	@Override
	public void handle(NoteBook noteBook) {
		System.out.println(noteBook.getTarget() + "---" +JSON.toJSONString(noteBook.getRoot()));
	}

}
