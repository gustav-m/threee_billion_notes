
public class ThreeBillion {

    public static final double[] ORACLE = { 110.0, 55.0, 65.4063, 73.416 };
    public static final double[] JAVA = {164.814, 220.000, 293.665};
    public static final double[] YOU = {349.228, 493.883, 659.225, 880.000, 587.330, 783.991 };
    public static final double[] DOWNLOAD = { 659.225, 987.767, 523.251 };
    public static final double[] DEVICE = { 1479.977, 3951.0664, 1975.533, 1760.000, 1174.659, 1174.659, 1760.000, 1760.000 };


    


    public static void main(String[] args) {
	SinWave s1 = new SinWave("JAVA", JAVA, 200);
	s1.start();
	SinWave s2 = new SinWave("YOU", YOU, 124);
	s2.start();
	SinWave s3 = new SinWave("DOWNLOAD", DOWNLOAD, 60);
	s3.start();
	SinWave s4 = new SinWave("ORACLE", ORACLE, 1500);
	s4.start();
	SinWave s5 = new SinWave("DEVICE", DEVICE, 80);
	s5.start();

    }
}
