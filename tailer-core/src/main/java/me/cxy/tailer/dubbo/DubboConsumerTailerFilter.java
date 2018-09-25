package me.cxy.tailer.dubbo;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

import me.cxy.tailer.Tailer;
import me.cxy.tailer.tree.NoteBook;

public class DubboConsumerTailerFilter implements Filter{
	
	private Tailer tailer;

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		NoteBook noteBook = tailer.getNoteBook();
		if(noteBook == null) {
			tailer.init();
		}
		RpcContext.getContext().setAttachment("target", noteBook.getTarget());
		Result result = invoker.invoke(invocation);
		return result;
	}

	public Tailer getTailer() {
		return tailer;
	}

	public void setTailer(Tailer tailer) {
		this.tailer = tailer;
	}

}
