package gscrot;

import iconlib.IconUtils;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.CaptureUploader;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Imgur", IconUtils.getIcon("imgur", Uploader.class));
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
