package statepattern;

import java.util.ArrayList;
import java.util.List;

public class Recorder {
	private State state;
    private boolean recording = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Recorder() {
        this.state = new ReadyState(this);
        setRecording(true);
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public boolean isRecording() {
        return recording;
    }

    public String startPlayback() {
        return "Recording " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Saving " + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
