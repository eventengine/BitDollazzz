import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lschubert on 11/15/15.
 */
public class BlockInterpreter {
    public static void main(String[] args)throws Exception{

        Path path = Paths.get("genesisBlock.b");
        byte[] genBytes = Files.readAllBytes(path);
        System.out.println(genBytes.length);
        printHex(genBytes);

    }

    public static void printHex(byte[] ba) {
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<ba.length;i++) {
            String hex=Integer.toHexString(0xff & ba[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}
