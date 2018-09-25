package me.cxy.tailer;

import java.util.UUID;

import me.cxy.tailer.deliver.Deliver;
import me.cxy.tailer.tree.Chapter;
import me.cxy.tailer.tree.NoteBook;

/**
 * 真正的尾行者
 * @author cxy
 *
 */
public class Tailer {
	
	private Deliver deliver;
	
	private ThreadLocal<NoteBook> threadLocal = new ThreadLocal<>();
	
	public Tailer(Deliver deliver) {
		super();
		this.deliver = deliver;
	}

	/**
	 * 锁定一个目标
	 * @return
	 */
	public NoteBook init() {
		return init(UUID.randomUUID().toString());
	}
	
	/**
	 * 锁定一个目标
	 * @param target
	 * @return
	 */
	public NoteBook init(String target) {
		NoteBook noteBook = new NoteBook(target);
		threadLocal.set(noteBook);
		return noteBook;
	}
	
	/**
	 * 跟随目标，并记录时间和地点
	 * @param site
	 */
	public void arrive(String site) {
		NoteBook noteBook = getNoteBook();
		if(noteBook == null) {
			noteBook = init();
		}
		Chapter chapter = new Chapter();
		chapter.setSite(site);
		chapter.setStartTime(System.currentTimeMillis());
		noteBook.note(chapter);
	}
	
	/**
	 * 记录目标离开的时间,如果所有章节已经写完则将笔记本交给雇主
	 */
	public void leave() {
		NoteBook noteBook = getNoteBook();
		Chapter chapter = noteBook.getCurrent();
		chapter.setEndTime(System.currentTimeMillis());
		chapter.arrange();
		if(noteBook.peek() == null) {
			clear();
			deliver(noteBook);
		}
	}
	
	/**
	 * 将笔记本交给雇主
	 * @param noteBook
	 */
	private void deliver(NoteBook noteBook) {
		deliver.handle(noteBook);
	}
	
	public NoteBook getNoteBook() {
		return threadLocal.get(); 
	}
	
	public void clear() {
		threadLocal.remove(); 
	}
	
}
