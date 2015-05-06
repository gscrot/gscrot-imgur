package gscrot;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.CaptureUploader;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Imgur");
	}

	@Override
	public void process(BufferedImage image) {
		try {
			System.out.println(Imgur.upload(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
