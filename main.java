import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class main {
	public static void main (String args[]) throws IOException {
		BufferedWriter writer=new BufferedWriter(new FileWriter(args[0]));
		double p=0.5;
		int[] success=new int[500];
		for(int i=0; i<500; i++) {
			int count=0;
			for(int j=0;j<1000;j++) {
				double b=generateRandom();
				if(b>=p) {
					count++;
				}
			}success[i]=count;
		}
		double average=0.0;
		int total=0;
		for(int k=0;k<500;k++) {
			total+=success[k];
		}average=total/500.0;
		double standardD=0.0;
		for(int l=0;l<500;l++) {
			standardD+=Math.pow(success[l]-average, 2);
		}writer.write("Standard Deviation: " + Math.sqrt(standardD/500)+"\n");
		int per=0;
		for(int a=0;a<500;a++) {
			if(success[a]>=468&&success[a]<=531) {
				per++;
			}
		}
		writer.write("Percentage of result that is among 468 to 531 successes: "+(double)per/5+"%\n");
		writer.close();
	}
	
	static double generateRandom() {
		double d=new Random().nextDouble();
		return d;
	}
}
