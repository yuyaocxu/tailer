package me.cxy.tailer.tree;

import java.util.Stack;

/**
 * 尾行者的笔记本（树结构）
 * @author cxy
 *
 */
public class NoteBook {
	
	private Chapter root;
	
	/**
	 *	本文的主人公（事务id，表示一次请求）
	 */
	private String target;
	
	/**
	 * 主要用于记录所经历的method
	 */
	private Stack<Chapter> via = new Stack<>();
	
	public NoteBook() {
		super();
	}
	
	public NoteBook(String target) {
		super();
		this.target = target;
	}

	public NoteBook(String target, Chapter root) {
		super();
		this.target = target;
		this.root = root;
		via.push(root);
	}
	
	public Chapter getCurrent() {
		return via.pop();
	}
	
	public Chapter getParent() {
		if(!via.isEmpty()) {
			return via.peek();
		}
		return null;
	}
	
	public void note(Chapter chapter) {
		Chapter parent = getParent();
		if(parent != null) {
			parent.addChildren(chapter);
		}else {
			this.root = chapter;
		}
		via.push(chapter);
	}
	
	public Chapter getRoot() {
		return root;
	}

	public void setRoot(Chapter root) {
		this.root = root;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
