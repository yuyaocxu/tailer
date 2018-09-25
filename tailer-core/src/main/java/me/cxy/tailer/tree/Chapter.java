package me.cxy.tailer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 章节
 * @author cxy
 *
 */
public class Chapter {

	private String site;
	private Long startTime;
	private Long endTime;
	private Long myTime;
	private Long totalTime;
	private List<Chapter> children;

	public void arrange() {
		if (this.totalTime == null) {
			this.totalTime = this.endTime - this.startTime;
		}
		if (this.myTime == null) {
			this.myTime = this.totalTime;
			if (children != null && children.size() > 0) {
				for (Chapter child : children) {
					this.myTime -= child.getTotalTime();
				}
			}
		}
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}


	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getMyTime() {
		return myTime;
	}

	public void setMyTime(Long myTime) {
		this.myTime = myTime;
	}

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public List<Chapter> getChildren() {
		return children;
	}

	public void setChildren(List<Chapter> children) {
		this.children = children;
	}
	
	public void addChildren(Chapter node) {
		if(children == null) {
			children = new ArrayList<>();
		}
		children.add(node);
	}

}
