package com.gif.controller;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	private final static Logger Logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Value("${multipart.location}")
	private String location;

	@PostMapping(value = "/upload", produces = MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("start") int start,
			@RequestParam("end") int end, @RequestParam("speed") int speed) throws IllegalStateException, IOException {

		File vedioFile = new File(location + "/" + System.currentTimeMillis() + ".mp4");
		multipartFile.transferTo(vedioFile);

		Logger.info("file save to{} " + vedioFile.getAbsolutePath());
		return location;

	}
}
//C:\Users\TONMOY~1\AppData\Local\Temp


//my life is in hell please help me someone ....please.......i want to get out of it....please please....
