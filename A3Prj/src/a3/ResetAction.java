package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ResetAction extends AbstractAction {

	private Camera cam;
	private Starter start;
	
	public ResetAction(Camera c, Starter s) {
		cam = c;
		start = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		start.reset();
		cam.reset();
	}
}
