package statepattern;

public class Demo {
	public static void main(String[] args) {
        Recorder recorder = new Recorder();
        UI ui = new UI(recorder);
        ui.init();
    }
}
