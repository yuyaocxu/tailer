package me.cxy.tailer.boss;

import me.cxy.tailer.tree.NoteBook;

/**
 * 尾行者记录所有节点之后把记录上交给雇主
 * @author cxy
 *
 */
public interface Boss {

	void handle(NoteBook noteBook);
}
