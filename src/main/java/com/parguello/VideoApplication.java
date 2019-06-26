package com.parguello;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.parguello.VideoService;

@ApplicationPath("/")
public class VideoApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public VideoApplication() {
		singletons.add(new VideoService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}