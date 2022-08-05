package statepattern;
import javax.swing.*;
import java.awt.*;

public class UI {
	 private Recorder recorder;
	    private static JTextField textField = new JTextField();

	    public UI(Recorder recorder) {
	        this.recorder = recorder;
	    }

	    public void init() {
	        JFrame frame = new JFrame("SDD Recorder");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel context = new JPanel();
	        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
	        frame.getContentPane().add(context);
	        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        context.add(textField);
	        context.add(buttons);

	        // Context delegates handling user's input to a state object. Naturally,
	        // the outcome will depend on what state is currently active, since all
	        // states can handle the input differently.
	        JButton play = new JButton("Record");
	        play.addActionListener(e -> textField.setText(recorder.getState().onPlay()));
	        JButton stop = new JButton("Stop");
	        stop.addActionListener(e -> textField.setText(recorder.getState().onLock()));
	        JButton next = new JButton("Save");
	        next.addActionListener(e -> textField.setText(recorder.getState().onNext()));
	        frame.setVisible(true);
	        frame.setSize(300, 100);
	        buttons.add(play);
	        buttons.add(stop);
	        buttons.add(next);
	        
	    }
}
