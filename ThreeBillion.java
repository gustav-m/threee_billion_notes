
public class ThreeBillion {

    public static final int[] ORACLE = { 0, 3, 6 , 9, 0, 0 ,0 };
    public static final int[] JAVA = {7, 10, 9, 13, 16, 16, 20, 20 };
    public static final int[] YOU = { 7, 9, 11, 13, 14, 16, 18, 21, 22, 22};
    public static final int[] DOWNLOAD = { 7, 8, 10, 13, 12, 12, 14, 7, 10, 8};
    public static final int[] DEVICE = { 14, 16, 18, 27, 26, 26, 27, 14, 17, 15};

    public static final String[] TonalCenters = { "A", "D", "C", "F", "Bb", "Eb", "Ab", "D", "A", "E", "Ab" };


    public volatile static int conductor = 0;
    

    public static void main(String[] args) throws InterruptedException {
	    
	SinWave s1 = new SinWave("JAVA", ORACLE, TonalCenters , 300, 26f);
	s1.start();
	SinWave s2 = new SinWave("YOU", JAVA, TonalCenters , 124, 16f);
	s2.start();
	SinWave s3 = new SinWave("DOWNLOAD", YOU, TonalCenters,  60, 18f);
	s3.start();
	SinWave s4 = new SinWave("ORACLE", DOWNLOAD, TonalCenters, 1500, 19f);
	s4.start();
	SinWave s5 = new SinWave("DEVICE", DEVICE, TonalCenters, 140, 9f);
	s5.start();

	while(true){
	    try{
		Thread.sleep(25000);
		conductor++;
		System.out.println("next part");
	    }catch(InterruptedException e){
		System.out.println("interrupted");
	    }
	}
    }
}
