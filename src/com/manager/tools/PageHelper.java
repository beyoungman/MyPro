package com.manager.tools;

public class PageHelper {
	//���ҳ��
	private int MaxPage;
	//��ǰҳ��
	private int page=1;
	//һҳ��ʾ��������¼��limit��2������
	private int cout=10;
	//�ܼ�¼��
	private int MaxCout;
	
	//ÿһҳ��ʼ������,��limit��һ������
	public int getPageStart(){
		int pageStart= (this.page*this.cout)-this.cout;
		return pageStart;
	}
	//�õ��ܼ�¼��
	public void setMaxCout(int i){
		MaxCout=i;
	}
	//�õ����ҳ��
	public int getMaxPage(){
		return MaxPage;
	}
	//�������ҳ��
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
	
	//��һҳ
		public void nextPage(){
			page+=1;
			if(page>MaxPage)
				page=MaxPage;
		}
		//��һҳ
		public void lastPage(){
			page-=1;
			if(page<=0)
				page=1;
		}
		//��ҳ
		public void fristPage(){
			page=1;
		}
		//���һҳ
		public void theLastPage(){
			page=MaxPage;
		}
	
}
