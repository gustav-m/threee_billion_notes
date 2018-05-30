
public class ThreeBillion {

    public static final double[] JAVA = {164.814, 220.000, 293.665};
    public static final double[] YOU = {349.228, 493.883, 659.225, 880.000, 587.330, 783.991 };
    public static final double[] DOWNLOAD = { 659.225, 987.767, 523.251 };


    


    public static void main(String[] args) {
	SinWave s1 = new SinWave("JAVA", JAVA, 200);
	s1.start();
	SinWave s2 = new SinWave("YOU", YOU, 124);
	s2.start();
	SinWave s3 = new SinWave("DOWNLOAD", DOWNLOAD, 40);
	s3.start();	
    }
}
