package statepattern;

public class ReadyState extends State {
	
	
	public ReadyState(Recorder recorder) {
        super(recorder);
    }

    @Override
    public String onLock() {
    	recorder.changeState(new LockedState(recorder));
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = recorder.startPlayback();
        recorder.changeState(new RecordingState(recorder));
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }


}
