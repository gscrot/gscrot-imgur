package gscrot;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.actions.Action;
import com.redpois0n.gscrot.actions.Event;

public class UploadAction extends Action {
	
	public UploadAction() {
		super(Event.AFTER_CAPTURE);
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
