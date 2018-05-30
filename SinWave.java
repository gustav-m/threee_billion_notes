import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;



public class SinWave implements Runnable {

    private Thread t;

    
    private static final double THREEBILLION = (10 ^ 9) * 3;
    private static final int SAMPLE_RATE = 32 * 2048;

    private double[] notes;
    private String threadName;
    private int baseDuration;
    private float volume;

    SinWave(String tName, double[] givenNotes, int givenBaseDuration, float vol){
	notes = givenNotes;
	threadName = tName;
	baseDuration = givenBaseDuration;
	volume = vol;
	
    }

    private byte[] sinWave(double frequency, int ms){
	int samples = (int)((ms * SAMPLE_RATE) / 1000);
	byte[] output = new byte[samples];
	double period = (double)SAMPLE_RATE / frequency;
	for (int i = 0; i < output.length; i++) {
	    double angle = 2.0 * Math.PI * i / period;
	    output[i] = (byte)(Math.sin(angle) * volume);  }

	return output;
    }

    public void run() {
	try{
	    final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
	    SourceDataLine line = AudioSystem.getSourceDataLine(af);
	    line.open(af, SAMPLE_RATE);
	    line.start();

	    double cnt = 0;
	    while(cnt < THREEBILLION){
		double frequency = notes[(int)(Math.random() * notes.length)];
		int duration = (int)(Math.random() * 10)  * baseDuration;
		byte [] toneBuffer = sinWave(frequency, duration);
		int count = line.write(toneBuffer, 0, toneBuffer.length);
		cnt = cnt + 0.01;
	    }
	    line.drain();
	    line.close();
	}catch(LineUnavailableException e){
	}
    }

    public void start () {
	if (t == null) {
	    t = new Thread (this, threadName);
	    t.start ();
	}
    }
}
