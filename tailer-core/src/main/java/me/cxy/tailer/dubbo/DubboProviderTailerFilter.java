package me.cxy.tailer.dubbo;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

import me.cxy.tailer.Tailer;

public class DubboProviderTailerFilter implements Filter{
	
	private Tailer tailer;

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String target = RpcContext.getContext().getAttachment("target");
		if(StringUtils.isBlank(target)) {
			tailer.init();
		}else {
			tailer.init(target);
		}
		return invoker.invoke(invocation);
	}

	public Tailer getTailer() {
		return tailer;
	}

	public void setTailer(Tailer tailer) {
		this.tailer = tailer;
	}

}
