
public class ThreeBillion {

    public static final int[] ORACLE = { 0, 3, 6 , 9, 0, 0 ,0 };
    public static final int[] JAVA = {7, 10, 9, 13, 16, 16, 20, 20 };
    public static final int[] YOU = { 7, 9, 11, 13, 14, 16, 18, 21, 22, 22};
    public static final int[] DOWNLOAD = { 7, 8, 10, 13, 12, 12, 14, 7, 10, 8};
    public static final int[] DEVICE = { 14, 16, 18, 27, 26, 26, 27, 14, 17, 15};
    

    public static void main(String[] args) {
	Note notes = new Note("A", "dorian");
	double[] scale = notes.getScale();
	
	SinWave s1 = new SinWave("JAVA", getPartScale(scale, ORACLE) , 300, 26f);
	s1.start();
	SinWave s2 = new SinWave("YOU", getPartScale(scale, JAVA) , 124, 16f);
	s2.start();
	SinWave s3 = new SinWave("DOWNLOAD", getPartScale(scale, YOU),  60, 18f);
	s3.start();
	SinWave s4 = new SinWave("ORACLE", getPartScale(scale, DOWNLOAD), 1500, 19f);
	s4.start();
	SinWave s5 = new SinWave("DEVICE", getPartScale(scale, DEVICE), 140, 9f);
	s5.start();

    }

    private static double[] getPartScale(double[] scale, int[] indexes){
	double[] ret = new double[indexes.length];

	for(int i = 0; i < indexes.length; i++){
	    ret[i] = scale[indexes[i]];
	}

	return ret;
    }
}
