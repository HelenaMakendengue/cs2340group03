import java.io.*;

public class LocationReader {
    public static void main(String[] args) throws Exception {

        File file = new File("//Users//helenamakendengue//Desktop//cs2340//LocationData.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String text;

        br.mark(1000);

        while ((text = br.readLine()) != null) {
            System.out.println(text);
        }

        br.reset();

        String st;

        br.readLine();

        st = br.readLine();
        System.out.println(st);

        String[] ar = st.split(",");

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
