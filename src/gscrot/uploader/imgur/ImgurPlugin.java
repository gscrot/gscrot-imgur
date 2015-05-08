package gscrot.uploader.imgur;

import gscrot.api.Plugin;

import com.redpois0n.gscrot.CaptureUploader;

public class ImgurPlugin extends Plugin {

	public ImgurPlugin() {
		super("Imgur");
		CaptureUploader.addUploader(new Uploader());
	}

}
