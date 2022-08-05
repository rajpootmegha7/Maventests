package statepattern;

	public abstract class State {
	    Recorder recorder;

	    /**
	     * Context passes itself through the state constructor. This may help a
	     * state to fetch some useful context data if needed.
	     */
	    State(Recorder player) {
	        this.recorder = player;
	    }

	    public abstract String onLock();
	    public abstract String onPlay();
	    public abstract String onNext();
	    
	}

