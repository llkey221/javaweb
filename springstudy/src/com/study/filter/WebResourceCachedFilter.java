package com.study.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class WebResourceCachedFilter
 */
@WebFilter("/WebResourceCachedFilter")
public class WebResourceCachedFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WebResourceCachedFilter() {
        // TODO Auto-generated constructor stub
    }
    
    private Map<String,byte[]> map=new HashMap<String,byte[]>();

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri=req.getRequestURI();
		//首先获取当前请求URL是否已经被缓存 
		byte [] b=map.get(uri);
		if(b!=null){
			//如果缓存中存在则直接输出
			String webResourceHtmlStr=new String(b,response.getCharacterEncoding());
			System.out.println(webResourceHtmlStr);
			response.getOutputStream().write(b);
			return;
		}
		
		BufferResponse myResponse=new BufferResponse(res);

		// pass the request along the filter chain
		chain.doFilter(request, myResponse);
		
		byte out[]=myResponse.getBuffer();
		map.put(uri, out);
		response.getOutputStream().write(out);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	class BufferResponse extends HttpServletResponseWrapper{
		//捕获输出的缓存
		private ByteArrayOutputStream bout=new ByteArrayOutputStream();
		private PrintWriter pw;
		private HttpServletResponse response;
		public BufferResponse(HttpServletResponse response){
			super(response);
			this.response=response;
		}
		
		public ServletOutputStream getOutputStream() throws IOException{
			return new MyServletOutputStream(bout);
		}
		
		public PrintWriter getWriter() throws IOException{
			pw=new PrintWriter(new OutputStreamWriter(bout,this.response.getCharacterEncoding()));
			return pw;
		}
		
		public byte[]getBuffer(){
			try{
				if(pw!=null){
					pw.close();
				}
				return bout.toByteArray();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	
	class MyServletOutputStream extends ServletOutputStream{
		private ByteArrayOutputStream bout;
		public MyServletOutputStream(ByteArrayOutputStream bout){
			this.bout=bout;
		}
		
		@Override
		public void write(int b) throws IOException{
			bout.write(b);
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener listener) {
			// TODO Auto-generated method stub
			
		}
	}

}
