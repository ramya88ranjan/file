package org.koshik.jb.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resource {


    private String filepath;
    private String filename;
    
    
    
    public String getFilepath() {
		return filepath;
	}



	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public Resource() {
    	
    }
    
   
}
