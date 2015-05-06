package gscrot;

import gscrot.api.Plugin;

import com.redpois0n.gscrot.actions.Action;

public class ImgurPlugin extends Plugin {

	public ImgurPlugin() {
		super("Imgur");
		Action.addAction(new UploadAction());
	}

}
