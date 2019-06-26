package com.parguello;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "video", propOrder = { "name", "url" })
public class Video {

	private Integer id;
    private String name;
    private String url;

    public Video() {
    }

    public Video(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    public Video(Integer id, Video video) {
        this.id = id;
        this.name = video.getName();
        this.url = video.getUrl();
    }
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

    

   
}
