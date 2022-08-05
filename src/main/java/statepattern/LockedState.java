package statepattern;

public class LockedState extends State {

	 LockedState(Recorder recorder) {
	        super(recorder);
	        recorder.setRecording(false);
	    }

	    @Override
	    public String onLock() {
	        if (recorder.isRecording()) {
	        	recorder.changeState(new ReadyState(recorder));
	            return "Stop playing";
	        } else {
	            return "Locked...";
	        }
	    }

	    @Override
	    public String onPlay() {
	    	recorder.changeState(new ReadyState(recorder));
	        return "Ready";
	    }

	    @Override
	    public String onNext() {
	        return "Locked...";
	    }

	   

}
