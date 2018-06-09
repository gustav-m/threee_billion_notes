import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class noteTest {

    private static final int SAMPLE_RATE = 32 * 2048;

    public static void main(String[] args){

	Note notes = new Note("Ab", "dorian");

	double[] scale = notes.getScale();

	for(int i = 0; i < scale.length; i++){
	    playNote(scale[i]);
	}
	
	//SinWave sinWave = new SinWave("test", notes.getScale(), 300 , 20f);
	//sinWave.start();
    }

    private static void playNote(double frequency){
	System.out.println(frequency);
	try{
	    final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
	    SourceDataLine line = AudioSystem.getSourceDataLine(af);
	    line.open(af, SAMPLE_RATE);
	    line.start();
	
	    int samples = (int)((400 * SAMPLE_RATE) / 1000);
	    byte[] output = new byte[samples];
	    double period = (double)SAMPLE_RATE / frequency;
	    for (int i = 0; i < output.length; i++) {
		double angle = 2.0 * Math.PI * i / period;
		double sampleVol = Math.sin(angle) * 20f;
		output[i] = (byte)(sampleVol);
	    }
	    int count = line.write(output, 0, output.length);
	    line.drain();
	    line.close();
	}catch(LineUnavailableException e){
	}

    }
}
