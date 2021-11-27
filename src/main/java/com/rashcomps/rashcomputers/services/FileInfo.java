/**
 * 
 */
package com.rashcomps.rashcomputers.services;

/**
 * @author ntwari
 *
 * @date 2020-May-15 4:48:28 PM 
 *
 */
public class FileInfo {

	private String name;
	  private String url;

	  
	  public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileInfo(String name, String url) {
	    this.name = name;
	    this.url = url;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getUrl() {
	    return this.url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }
}
