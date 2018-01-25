package com.manager.tools;

public class PageHelper {
	//最大页数
	private int MaxPage;
	//当前页数
	private int page=1;
	//一页显示多少条记录，limit第2个参数
	private int cout=10;
	//总记录数
	private int MaxCout;
	
	//每一页开始的数字,即limit第一个参数
	public int getPageStart(){
		int pageStart= (this.page*this.cout)-this.cout;
		return pageStart;
	}
	//得到总记录数
	public void setMaxCout(int i){
		MaxCout=i;
	}
	//得到最大页数
	public int getMaxPage(){
		return MaxPage;
	}
	//设置最大页数
	public void setMaxPage() {
		if(MaxCout%cout==0){
			MaxPage=MaxCout/cout;
		}else{
			MaxPage=((int)(MaxCout/cout))+1;
		}
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public int getMaxCout() {
		return MaxCout;
	}
	
	//下一页
		public void nextPage(){
			page+=1;
			if(page>MaxPage)
				page=MaxPage;
		}
		//上一页
		public void lastPage(){
			page-=1;
			if(page<=0)
				page=1;
		}
		//首页
		public void fristPage(){
			page=1;
		}
		//最后一页
		public void theLastPage(){
			page=MaxPage;
		}
	
}
