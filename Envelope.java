public class Envelope {

    private int attackTime;
    private int decayTime;
    private int sustainTime;
    private int releaseTime;

    private int attackLevel;
    private int decayLevel;
    private int sustainLevel;
    private int releaseLevel;

    private int samples;

    private int envelope[];

    Envelope(int sampleSize){
	samples = sampleSize;
	envelope = new int[samples];
    }

    public Envelope randomizeEnvelope(){
	attackTime = (int)(Math.random() * samples);
	decayTime = (int)(Math.random() * (samples - attackTime));
	sustainTime = samples - attackTime - decayTime;

	attackLevel = (int)(Math.random() * 100000);
	decayLevel = (int)(Math.random() * 100000);
	sustainLevel = (int)(Math.random() * 100000);
		
        return this;
    }

    public int[] getEnvelope(){
	int currentvol = attackLevel;
	for(int i = 0; i < samples; i++){
	    if(i >= 0 && i <= attackTime){
		currentvol = currentvol + (int)((100000 - attackLevel) / attackTime);
	    }else if(i > attackTime && i <= (attackTime + decayTime)){
		currentvol = currentvol - (int)((100000 - decayLevel) / decayTime);
	    }else if(i > (attackTime + decayTime)){
		if(currentvol > sustainLevel){
		    currentvol = currentvol - (int)((decayLevel - sustainLevel) / sustainTime);
		}else{
		    currentvol = currentvol + (int)((decayLevel - sustainLevel) / sustainTime);   
		}
	    }
	    if(currentvol > 100000) {
		currentvol = 100000;
	    }
	    if(currentvol < 0){
		currentvol = 0;
	    }
	    envelope[i] = currentvol;
	}
	return envelope;
    }
}
