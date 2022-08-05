package statepattern;

public class RecordingState extends State {

	RecordingState(Recorder recorder) {
        super(recorder);
    }

	 @Override
	    public String onLock() {
		 recorder.changeState(new LockedState(recorder));
		 recorder.setCurrentTrackAfterStop();
	        return "Stop playing";
	    }

	    @Override
	    public String onPlay() {
	    	recorder.changeState(new ReadyState(recorder));
	        return "Paused...";
	    }

	    @Override
	    public String onNext() {
	        return recorder.nextTrack();
	    }

	 

}
