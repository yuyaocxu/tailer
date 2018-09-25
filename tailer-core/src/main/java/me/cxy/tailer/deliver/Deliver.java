package me.cxy.tailer.deliver;

import me.cxy.tailer.tree.NoteBook;

/**
 * 尾行者记录所有故事章节之后把记录上传
 * @author cxy
 *
 */
public interface Deliver {

	void handle(NoteBook noteBook);
}
